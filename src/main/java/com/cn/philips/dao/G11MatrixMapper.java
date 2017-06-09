package com.cn.philips.dao;

import com.cn.philips.pojo.G11Matrix;
import com.cn.philips.pojo.G11MatrixExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface G11MatrixMapper {
    int countByExample(G11MatrixExample example);

    int deleteByExample(G11MatrixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(G11Matrix record);

    int insertSelective(G11Matrix record);

    ArrayList<G11Matrix> selectByExample(G11MatrixExample example);

    G11Matrix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") G11Matrix record, @Param("example") G11MatrixExample example);

    int updateByExample(@Param("record") G11Matrix record, @Param("example") G11MatrixExample example);

    int updateByPrimaryKeySelective(G11Matrix record);

    int updateByPrimaryKey(G11Matrix record);
}