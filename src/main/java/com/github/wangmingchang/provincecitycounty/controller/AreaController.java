package com.github.wangmingchang.provincecitycounty.controller;

import com.github.wangmingchang.provincecitycounty.pojo.vo.AreaSaveVo;
import com.github.wangmingchang.provincecitycounty.pojo.vo.AreaUpdateLogVo;
import com.github.wangmingchang.provincecitycounty.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 地区-controller
 * @auther wangmingchang
 * @date 2019/4/1 15:51
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<AreaUpdateLogVo> areaUpdateLogVos = areaService.queryUpdateLog();
        modelAndView.addObject("areaUpdateLogVos",areaUpdateLogVos);
        return modelAndView;
    }

    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    @ResponseBody
    public AreaSaveVo saveData(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        AreaSaveVo areaSaveVo = new AreaSaveVo();
        areaSaveVo.setFlag(true);
        String updateTime = "更新时间为：";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        updateTime = updateTime + format;
        areaSaveVo.setUpdateTime(updateTime);
//        try {
//            areaSaveVo = areaService.saveData(code, name);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return areaSaveVo;
    }

}
