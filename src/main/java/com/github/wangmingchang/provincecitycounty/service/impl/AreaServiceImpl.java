package com.github.wangmingchang.provincecitycounty.service.impl;

import com.github.wangmingchang.provincecitycounty.common.HttpUtil;
import com.github.wangmingchang.provincecitycounty.common.StringUtil;
import com.github.wangmingchang.provincecitycounty.dao.AreaDao;
import com.github.wangmingchang.provincecitycounty.pojo.po.AreaPo;
import com.github.wangmingchang.provincecitycounty.service.AreaService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther wangmingchang
 * @date 2019/4/1 17:11
 */
@Service
public class AreaServiceImpl implements AreaService {

    private static String URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";
    private static String PARENT_CODE = "PARENT_CODE";
    private static String NEXT_URL = "NEXT_URL";
    private static String CITY_PREFIX_URL = "CITY_PREFIX_URL";
    private static String COUNTY_PREFIX_URL = "COUNTY_PREFIX_URL";
    private static String TOWN_PREFIX_URL = "TOWN_PREFIX_URL";
    private static String[] SUFFIX_NAME_ARR = {"社区居委会", "村委会"};
    private static String VILLAGE_NAME = "村";
    private static String STREET_NAME = "街";
    private static String[] STREET_REPETITION_NAME_ARR = {"街村"};
    private static String[] VILLAGE_REPETITION_NAME_ARR = {"村村"};
    private static String[] OFFICE_NAME_ARR = {"办事处"};

    @Autowired
    private AreaDao areaDao;


    /**
     * 保存地区数据
     *
     * @param code
     * @param name
     */
    @Override
    public boolean saveData(String code, String name) {
        boolean flag = false;
        String cityUrl = URL + code + ".html";
        AreaPo provinceAreaPo = areaDao.selectByPrimaryKey(code);
        if (null != provinceAreaPo) {
            //删除，新增
            areaDao.deleteByPrimaryKey(code);
        }
        //省
        provinceAreaPo = new AreaPo(code, null, name);
        int provinceNum = areaDao.insertSelective(provinceAreaPo);
        System.out.println("保存省返回影响行数：" + provinceNum + "省code：" + code + "，省name:" + name + "，下一级URL:" + cityUrl);
        String cityHtml = HttpUtil.doGet(cityUrl);
        Document cityDoc = Jsoup.parse(cityHtml);
        Elements citytr = cityDoc.getElementsByClass("citytr");
        for (Element element : citytr) {
            //市-信息
            Map<String, String> cityMap = saveData(element, code, 1, "");
            String countyUrl = cityMap.get(NEXT_URL);
            String parentCode = cityMap.get(PARENT_CODE);
            String cityPrefixUrl = cityMap.get(CITY_PREFIX_URL);
            if (StringUtils.isNoneBlank(countyUrl)) {
                //有下一级，区、县
                countyUrl = URL + countyUrl;
                String countyHtml = HttpUtil.doGet(countyUrl);
                Document countyDoc = Jsoup.parse(countyHtml);
                Elements countytr = countyDoc.getElementsByClass("countytr");
                for (Element coutyElement : countytr) {
                    //区、县信息
                    Map<String, String> countyMap = saveData(coutyElement, parentCode, 2, cityPrefixUrl);
                    String townUrl = countyMap.get(NEXT_URL);
                    String townParentCode = countyMap.get(PARENT_CODE);
                    String countyPrefixUrl = countyMap.get(COUNTY_PREFIX_URL);
                    if (StringUtils.isNoneBlank(townUrl)) {
                        townUrl = URL + townUrl;
                        String townHtml = HttpUtil.doGet(townUrl);
                        Document townDoc = Jsoup.parse(townHtml);
                        Elements towntr = townDoc.getElementsByClass("towntr");
                        for (Element townElement : towntr) {
                            //镇信息
                            Map<String, String> townMap = saveData(townElement, townParentCode, 3, countyPrefixUrl);
                            String villageUrl = townMap.get(NEXT_URL);
                            String villageParentCode = townMap.get(PARENT_CODE);
                            String villagePrefixUrl = townMap.get(TOWN_PREFIX_URL);
                            if (StringUtils.isNoneBlank(villageUrl)) {
                                //村信息
                                villageUrl = URL + villageUrl;
                                String villageHtml = HttpUtil.doGet(villageUrl);
                                Document villageDoc = Jsoup.parse(villageHtml);
                                Elements villagetr = villageDoc.getElementsByClass("villagetr");
                                for (Element villageElement : villagetr) {
                                    saveData(villageElement, villageParentCode, 4, villagePrefixUrl);
                                }
                            }
                        }
                    }

                }

            }
        }
        flag = true;
        return flag;
    }

    /**
     * 保存区、县、镇、村数据
     *
     * @param element
     * @param parentCode
     * @param currntNum
     * @param prefixUrl
     * @return
     */
    private Map<String, String> saveData(Element element, String parentCode, int currntNum, String prefixUrl) {
        Map<String, String> map = new HashMap<>(3);
        Elements tds = element.getElementsByTag("td");
        Element element1 = tds.get(0);
        String nextUrl = element1.getElementsByTag("a").attr("href");
        if (StringUtils.isNoneBlank(nextUrl) && currntNum != 4) {
            String nextUrlSb = nextUrl.substring(0, nextUrl.indexOf("/"));
            prefixUrl = prefixUrl + "/" + nextUrlSb;
            switch (currntNum) {
                case 1:
                    map.put(CITY_PREFIX_URL, prefixUrl);
                    break;
                case 2:
                    map.put(COUNTY_PREFIX_URL, prefixUrl);
                    break;
                default:
                    map.put(TOWN_PREFIX_URL, prefixUrl);
                    break;

            }
            if (currntNum > 1) {
                String nextUrlSb2 = nextUrl.substring(nextUrl.indexOf("/"), nextUrl.length());
                nextUrl = prefixUrl + "/" + nextUrlSb2;
            }
        }
        String code = getTdText(element1, currntNum);
        String name = null;
        if (currntNum == 4) {
            name = getTdText(tds.get(2), currntNum);
            if(StringUtil.indexOf(name, SUFFIX_NAME_ARR)){
                name = StringUtil.replaceCustomBlank(name, SUFFIX_NAME_ARR, VILLAGE_NAME);
                if(StringUtil.indexOf(name, STREET_REPETITION_NAME_ARR)){
                    name = StringUtil.replaceCustomBlank(name, STREET_REPETITION_NAME_ARR, STREET_NAME);
                }else if(StringUtil.indexOf(name, VILLAGE_REPETITION_NAME_ARR)){
                    name = StringUtil.replaceCustomBlank(name, VILLAGE_REPETITION_NAME_ARR, VILLAGE_NAME);
                }
            }
        } else if(currntNum == 3){
            name = getTdText(tds.get(1), currntNum);
            if(StringUtil.indexOf(name, OFFICE_NAME_ARR)){
                name = StringUtil.replaceCustomBlank(name, OFFICE_NAME_ARR, "");
            }
        }else {
            name = getTdText(tds.get(1), currntNum);
        }
        AreaPo areaPo = areaDao.selectByPrimaryKey(code);
        //先删除，再新增
        if (null != areaPo) {
            areaDao.deleteByPrimaryKey(code);
        }
        areaPo = new AreaPo(code, parentCode, name);
        int num = areaDao.insertSelective(areaPo);
        System.out.println("保存返回影响行数：" + num + "，code：" + code + "，name:" + name + "，下一级URL:" + nextUrl);
        map.put(NEXT_URL, nextUrl);
        map.put(PARENT_CODE, code);
        return map;
    }

    /**
     * 获取td中的内容
     *
     * @param element
     * @param currntNum
     * @return
     */
    private String getTdText(Element element, int currntNum) {
        String text = null;
        if (currntNum == 4) {
            text = element.text();
        } else {
            Elements aElement = element.getElementsByTag("a");
            text = aElement.get(0).text();
        }
        return text;
    }

}
