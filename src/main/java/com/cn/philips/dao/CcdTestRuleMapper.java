package com.cn.philips.dao;

import com.cn.philips.pojo.CcdTestRule;
import com.cn.philips.pojo.CcdTestRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcdTestRuleMapper {
    int countByExample(CcdTestRuleExample example);

    int deleteByExample(CcdTestRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CcdTestRule record);

    int insertSelective(CcdTestRule record);

    List<CcdTestRule> selectByExample(CcdTestRuleExample example);

    CcdTestRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CcdTestRule record, @Param("example") CcdTestRuleExample example);

    int updateByExample(@Param("record") CcdTestRule record, @Param("example") CcdTestRuleExample example);

    int updateByPrimaryKeySelective(CcdTestRule record);

    int updateByPrimaryKey(CcdTestRule record);
}