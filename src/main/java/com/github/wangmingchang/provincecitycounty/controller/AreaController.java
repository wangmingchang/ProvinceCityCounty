package com.github.wangmingchang.provincecitycounty.controller;

import com.github.wangmingchang.provincecitycounty.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveData(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        boolean flag = false;
        try {
            flag = areaService.saveData(code, name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
