package com.cn.philips.dao;

import com.cn.philips.pojo.CcdTestConfigT;
import com.cn.philips.pojo.CcdTestConfigTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcdTestConfigTMapper {
    int countByExample(CcdTestConfigTExample example);

    int deleteByExample(CcdTestConfigTExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CcdTestConfigT record);

    int insertSelective(CcdTestConfigT record);

    List<CcdTestConfigT> selectByExample(CcdTestConfigTExample example);

    CcdTestConfigT selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CcdTestConfigT record, @Param("example") CcdTestConfigTExample example);

    int updateByExample(@Param("record") CcdTestConfigT record, @Param("example") CcdTestConfigTExample example);

    int updateByPrimaryKeySelective(CcdTestConfigT record);

    int updateByPrimaryKey(CcdTestConfigT record);
}