package com.github.wangmingchang.provincecitycounty.dao;

import com.github.wangmingchang.provincecitycounty.pojo.po.AreaUpdateLogPo;
import com.github.wangmingchang.provincecitycounty.pojo.vo.AreaUpdateLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 地区更新日志Dao类
 *
 * @author 王明昌
 * @date 2019-04-09
 */
@Repository
public interface AreaUpdateLogDao {

    AreaUpdateLogPo selectByPrimaryKey(Integer id);

    List<AreaUpdateLogPo> selectBySelective(Map paramMap);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaUpdateLogPo areaUpdateLogPo);

    int insertSelective(AreaUpdateLogPo areaUpdateLogPo);

    int updateByPrimaryKeySelective(AreaUpdateLogPo areaUpdateLogPo);

    int updateByPrimaryKey(AreaUpdateLogPo areaUpdateLogPo);

    List<AreaUpdateLogVo> queryUpdateLog();
}
