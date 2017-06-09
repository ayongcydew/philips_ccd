package com.cn.philips.dao;

import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestDataExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcdTestDataMapper {
    int countByExample(CcdTestDataExample example);

    int deleteByExample(CcdTestDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CcdTestData record);

    int insertSelective(CcdTestData record);

    ArrayList<CcdTestData> selectByExample(CcdTestDataExample example);

    CcdTestData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CcdTestData record, @Param("example") CcdTestDataExample example);

    int updateByExample(@Param("record") CcdTestData record, @Param("example") CcdTestDataExample example);

    int updateByPrimaryKeySelective(CcdTestData record);

    int updateByPrimaryKey(CcdTestData record);
}