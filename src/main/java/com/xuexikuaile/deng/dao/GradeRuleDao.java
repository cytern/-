package com.xuexikuaile.deng.dao;

import com.xuexikuaile.deng.pojo.GradeRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GradeRuleDao {
    int deleteByPrimaryKey(Integer gradeRuleId);

    int insert(GradeRule record);

    int insertSelective(GradeRule record);

    GradeRule selectByPrimaryKey(Integer gradeRuleId);

    int updateByPrimaryKeySelective(GradeRule record);

    int updateByPrimaryKey(GradeRule record);

    List<GradeRule> getByTestId(Integer testId);
}