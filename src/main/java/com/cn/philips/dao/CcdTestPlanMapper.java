package com.cn.philips.dao;

import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcdTestPlanMapper {
    int countByExample(CcdTestPlanExample example);

    int deleteByExample(CcdTestPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CcdTestPlan record);

    int insertSelective(CcdTestPlan record);

    ArrayList<CcdTestPlan> selectByExample(CcdTestPlanExample example);

    CcdTestPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CcdTestPlan record, @Param("example") CcdTestPlanExample example);

    int updateByExample(@Param("record") CcdTestPlan record, @Param("example") CcdTestPlanExample example);

    int updateByPrimaryKeySelective(CcdTestPlan record);

    int updateByPrimaryKey(CcdTestPlan record);
}