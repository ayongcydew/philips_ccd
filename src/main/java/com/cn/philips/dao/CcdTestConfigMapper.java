package com.cn.philips.dao;

import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcdTestConfigMapper {
    int countByExample(CcdTestConfigExample example);

    int deleteByExample(CcdTestConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CcdTestConfig record);

    int insertSelective(CcdTestConfig record);

    List<CcdTestConfig> selectByExample(CcdTestConfigExample example);

    CcdTestConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CcdTestConfig record, @Param("example") CcdTestConfigExample example);

    int updateByExample(@Param("record") CcdTestConfig record, @Param("example") CcdTestConfigExample example);

    int updateByPrimaryKeySelective(CcdTestConfig record);

    int updateByPrimaryKey(CcdTestConfig record);
}