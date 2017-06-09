package com.cn.philips.dao;

import com.cn.philips.pojo.UserCCD;
import com.cn.philips.pojo.UserCCDExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCCDMapper {
    int countByExample(UserCCDExample example);

    int deleteByExample(UserCCDExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCCD record);

    int insertSelective(UserCCD record);

    ArrayList<UserCCD> selectByExample(UserCCDExample example);

    UserCCD selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCCD record, @Param("example") UserCCDExample example);

    int updateByExample(@Param("record") UserCCD record, @Param("example") UserCCDExample example);

    int updateByPrimaryKeySelective(UserCCD record);

    int updateByPrimaryKey(UserCCD record);
}