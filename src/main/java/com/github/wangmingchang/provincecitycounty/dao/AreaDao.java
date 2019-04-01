package com.github.wangmingchang.provincecitycounty.dao;

import com.github.wangmingchang.provincecitycounty.pojo.po.AreaPo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 地区信息Dao类
 * @author 王明昌
 * @date 2019-04-01
 */
@Repository
public interface AreaDao {
	
	AreaPo selectByPrimaryKey(String code);

	List<AreaPo> selectBySelective(Map paramMap);

	int deleteByPrimaryKey(String code);
	
	int insert(AreaPo areaPo);
	
	int insertSelective(AreaPo areaPo);
	
	int updateByPrimaryKeySelective(AreaPo areaPo);
	
	int updateByPrimaryKey(AreaPo areaPo);
}
