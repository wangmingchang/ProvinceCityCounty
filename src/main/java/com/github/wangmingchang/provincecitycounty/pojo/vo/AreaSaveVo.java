package com.github.wangmingchang.provincecitycounty.pojo.vo;

import java.io.Serializable;

/**
 * 地区保存vo
 *
 * @auther wangmingchang
 * @date 2019/4/10 09:52
 */
public class AreaSaveVo implements Serializable {

    /**
     * 保存是否成功
     */
    private boolean flag;
    /**
     * 成功更新时间
     */
    private String updateTime;

    public AreaSaveVo(boolean flag, String updateTime) {
        this.flag = flag;
        this.updateTime = updateTime;
    }

    public AreaSaveVo() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AreaSaveVo{" +
                "flag=" + flag +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
