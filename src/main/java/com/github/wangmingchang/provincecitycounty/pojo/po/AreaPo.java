package com.github.wangmingchang.provincecitycounty.pojo.po;

import java.util.Date;

/**
 * 地区信息
 *
 * @author 王明昌
 * @since 2019-04-01
 */
public class AreaPo {

    private String code; // 行政代码
    private String parentCode; // 父行政代码
    private String name; // 行政名称
    private Date createTime; // 创建时间

    public AreaPo(String code, String parentCode, String name) {
        this.code = code;
        this.parentCode = parentCode;
        this.name = name;
    }

    public AreaPo() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AreaPo [code=" + code + "parentCode=" + parentCode + "name=" + name + "createTime=" + createTime + "]";
    }
}
