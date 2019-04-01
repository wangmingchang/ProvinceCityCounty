package com.github.wangmingchang.provincecitycounty.service.impl;

import com.github.wangmingchang.provincecitycounty.common.HttpUtil;
import com.github.wangmingchang.provincecitycounty.service.AreaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @auther wangmingchang
 * @date 2019/4/1 17:11
 */
@Service
public class AreaServiceImpl implements AreaService {

    private static String URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";

    /**
     * 保存地区数据
     *
     * @param code
     */
    @Override
    public void saveData(String code) {
        String rUrl = URL  + code + ".html";
        String html = HttpUtil.doGet(rUrl);
        Document doc = Jsoup.parse(html);
        Elements citytr = doc.getElementsByClass("citytr");
        Iterator<Element> iterator = citytr.iterator();
        while (iterator.hasNext()){
            //市-信息
            Element element = iterator.next();
            Elements tds = element.getElementsByTag("td");
            Iterator<Element> cityIterator = tds.iterator();
            while (cityIterator.hasNext()){
                Element city = cityIterator.next();
                Elements aElement = city.getElementsByTag("a");
                String text = aElement.get(0).text();
                String url = aElement.get(0).attr("href");
                System.out.println(text);

            }

            System.out.println(element);

        }

        System.out.println(doc);
    }
}
