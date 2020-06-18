package com.xuexikuaile.deng.service;

import com.xuexikuaile.deng.dao.*;
import com.xuexikuaile.deng.plugin.Response;
import com.xuexikuaile.deng.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: cytern
 * @Date: 2020/6/12 13:56
 */
@Component
public class StudentConf {
    @Autowired
    private STokenDao sTokenDao;
    @Autowired
    private SUserDao sUserDao;
    @Autowired
    private SStudentDao sStudentDao;
    @Autowired
    private SGradeDao sGradeDao;
    @Autowired
    Response response =new Response();
    @Autowired
    private STestDao sTestDao;

    public Map<String,Object> getConfByToken(String token){
        SToken sToken = sTokenDao.getTokenByToken(token);
        try {
            if (sToken.getUserId() == null){
                  return  response.responseError("登录验证失效");
            }
        } catch (Exception e) {
            return  response.responseError("登录验证失效");
        }
       SStudent sStudent = sStudentDao.getStudentByUserId(sToken.getUserId());
        try {
            if (sStudent.getUserId() == null){
                return  response.responseError("无效用户");
            }
        } catch (Exception e) {
            return  response.responseError("无效用户");
        }

  return null;

    }

    public Map<String,Object> getGradeLike(Integer studentId){
        List<SGrade> gradeList = sGradeDao.getAllGrade(studentId);
        List<STest> tests = new ArrayList<>();
        for (SGrade sGrade:gradeList){
            STest sTest = sTestDao.selectByPrimaryKey(sGrade.getTestId());
            tests.add(sTest);
        }
        return null;
    }
}
