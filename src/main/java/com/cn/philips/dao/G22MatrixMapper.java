package com.cn.philips.dao;

import com.cn.philips.pojo.G22Matrix;
import com.cn.philips.pojo.G22MatrixExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface G22MatrixMapper {
    int countByExample(G22MatrixExample example);

    int deleteByExample(G22MatrixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(G22Matrix record);

    int insertSelective(G22Matrix record);

    ArrayList<G22Matrix> selectByExample(G22MatrixExample example);

    G22Matrix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") G22Matrix record, @Param("example") G22MatrixExample example);

    int updateByExample(@Param("record") G22Matrix record, @Param("example") G22MatrixExample example);

    int updateByPrimaryKeySelective(G22Matrix record);

    int updateByPrimaryKey(G22Matrix record);
}