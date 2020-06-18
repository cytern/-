package com.xuexikuaile.deng.dao;

import com.xuexikuaile.deng.pojo.STitleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface STitleUserDao {
    int deleteByPrimaryKey(Integer titleUserId);

    int insert(STitleUser record);

    int insertSelective(STitleUser record);

    STitleUser selectByPrimaryKey(Integer titleUserId);

    int updateByPrimaryKeySelective(STitleUser record);

    int updateByPrimaryKey(STitleUser record);
}