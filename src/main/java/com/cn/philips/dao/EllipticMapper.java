package com.cn.philips.dao;

import com.cn.philips.pojo.Elliptic;
import com.cn.philips.pojo.EllipticExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EllipticMapper {
    int countByExample(EllipticExample example);

    int deleteByExample(EllipticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Elliptic record);

    int insertSelective(Elliptic record);

    ArrayList<Elliptic> selectByExample(EllipticExample example);

    Elliptic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Elliptic record, @Param("example") EllipticExample example);

    int updateByExample(@Param("record") Elliptic record, @Param("example") EllipticExample example);

    int updateByPrimaryKeySelective(Elliptic record);

    int updateByPrimaryKey(Elliptic record);
}