package com.github.wangmingchang.provincecitycounty.pojo.po;

import java.util.Date;

/**
 * 地区更新日志
 * 
 * @author 王明昌
 * @since 2019-04-09
 */
public class AreaUpdateLogPo {

	private Integer id; // 主键
	private String code; // 行政编码
	private Date createTime; // 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "AreaUpdateLogPo [id=" + id + "code=" + code + "createTime=" + createTime + "]";
	}
}
