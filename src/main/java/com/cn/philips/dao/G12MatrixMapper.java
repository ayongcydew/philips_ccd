package com.cn.philips.dao;

import com.cn.philips.pojo.G12Matrix;
import com.cn.philips.pojo.G12MatrixExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface G12MatrixMapper {
    int countByExample(G12MatrixExample example);

    int deleteByExample(G12MatrixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(G12Matrix record);

    int insertSelective(G12Matrix record);

    ArrayList<G12Matrix> selectByExample(G12MatrixExample example);

    G12Matrix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") G12Matrix record, @Param("example") G12MatrixExample example);

    int updateByExample(@Param("record") G12Matrix record, @Param("example") G12MatrixExample example);

    int updateByPrimaryKeySelective(G12Matrix record);

    int updateByPrimaryKey(G12Matrix record);
}