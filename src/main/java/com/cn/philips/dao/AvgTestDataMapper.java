package com.cn.philips.dao;

import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.AvgTestDataExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvgTestDataMapper {
    int countByExample(AvgTestDataExample example);

    int deleteByExample(AvgTestDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AvgTestData record);

    int insertSelective(AvgTestData record);

    ArrayList<AvgTestData> selectByExample(AvgTestDataExample example);

    AvgTestData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AvgTestData record, @Param("example") AvgTestDataExample example);

    int updateByExample(@Param("record") AvgTestData record, @Param("example") AvgTestDataExample example);

    int updateByPrimaryKeySelective(AvgTestData record);

    int updateByPrimaryKey(AvgTestData record);
}