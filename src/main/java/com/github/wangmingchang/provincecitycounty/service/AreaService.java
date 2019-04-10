package com.github.wangmingchang.provincecitycounty.service;

import com.github.wangmingchang.provincecitycounty.pojo.vo.AreaSaveVo;
import com.github.wangmingchang.provincecitycounty.pojo.vo.AreaUpdateLogVo;

import java.util.List;

/**
 * 地区service
 * @auther wangmingchang
 * @date 2019/4/1 17:09
 */
public interface AreaService {

    /**
     * 保存地区数据
     * @param code
     * @param name
     */
    AreaSaveVo saveData(String code, String name);

    /**
     * 查询更新日志
     * @return
     */
    List<AreaUpdateLogVo> queryUpdateLog();
}
