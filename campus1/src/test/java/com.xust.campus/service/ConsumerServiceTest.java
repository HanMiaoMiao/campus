package com.xust.campus.service;

import com.xust.campus.vo.request.Register;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xust.campus.service.ConsumerService;
import com.xust.campus.vo.request.Register;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ConsumerServiceTest {
    @Autowired
    ConsumerService consumerService;
    @Test
    public void insertSelective() throws Exception {
        Register register=new Register();
        register.setUserNumber("18392624809");
        register.setUserpwd("zgsxh15319246936");
        register.setTarget("0");
        System.out.println( consumerService.insertSelective(register));
    }

}
