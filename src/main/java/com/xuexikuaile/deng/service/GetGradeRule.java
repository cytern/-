package com.xuexikuaile.deng.service;

import com.xuexikuaile.deng.dao.*;
import com.xuexikuaile.deng.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: cytern
 * @Date: 2020/6/12 15:46
 */
@Service
public class GetGradeRule {
    @Autowired
    private SGradeDao sGradeDao;
    @Autowired
    private STestDao sTestDao;
    @Autowired
    private STestClassDao sTestClassDao;
    @Autowired
    private SStudentDao sStudentDao;
    @Autowired
    private GradeRuleDao gradeRuleDao;

    @Autowired
    private SClassDao sClassDao;


    public List<STest>  getNoRuleTest(){
        List<STest> sTests = sTestDao.getAllTest();
        List<STest> sTests1 = new ArrayList<>();
        for (STest sTest:sTests){
            try {
                List<GradeRule> gradeRules = gradeRuleDao.getByTestId(sTest.getSTestId());
                boolean ave = false;
                boolean max = false;
                for (GradeRule gradeRule:gradeRules){
                    if (gradeRule.getGradeType().contains("ave")){
                        ave = true;
                    }
                    if (gradeRule.getGradeType().contains("max")){
                        max = true;
                    }
                }
                if (ave == true && max ==true){

                }else {
                    sTests1.add(sTest);
                }
            } catch (Exception e) {
                sTests1.add(sTest);
            }
        }
        return sTests1;
    }

    public void addGradeRuleClass() {
       List<STestClass> sTestClasses = sTestClassDao.getAll();
       for (STestClass sTestClass:sTestClasses){
           STest sTest = sTestDao.selectByPrimaryKey(sTestClass.getTestId());
           List<SGrade> sGrades = sGradeDao.getByTestClassId(sTest.getSTestId(),sTestClass.getClassId());

       }
    }

    public Map<String,Object> getRule(List<SGrade> sGrades){
        BigDecimal maxMath,totalMath,maxChinese,totalChinese,maxEng,totalEng,totalBio,maxBio,maxPhy,totalPhy,totalChe,maxChe = new BigDecimal(0);
        BigDecimal maxHis,maxGeo,maxPol,totalHis,totalGeo,totalPol = new BigDecimal(0);
        BigDecimal manxScience,maxArts,totalSci,totalArts = new BigDecimal(0);
    maxChinese = sGrades.stream().sorted(Comparator.comparing(SGrade::getGChinese)).collect(Collectors.toList()).get(0).getGChinese();
     maxEng= sGrades.stream().sorted(Comparator.comparing(SGrade::getGEnglish)).collect(Collectors.toList()).get(9).getGEnglish();
        maxMath= sGrades.stream().sorted(Comparator.comparing(SGrade::getGMath)).collect(Collectors.toList()).get(0).getGMath();
     return null;
    }




}
