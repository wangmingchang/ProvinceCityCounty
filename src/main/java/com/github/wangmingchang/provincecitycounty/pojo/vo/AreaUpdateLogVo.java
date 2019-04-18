package com.github.wangmingchang.provincecitycounty.pojo.vo;

import java.io.Serializable;

/**
 * 地区更新时间vo
 *
 * @auther wangmingchang
 * @date 2019/4/10 09:24
 */
public class AreaUpdateLogVo implements Serializable {

    /**
     * 编码
     */
    private String code;
    /**
     * 更新时间
     */
    private String updateTime;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AreaUpdateLogVo{" +
                "code='" + code + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
