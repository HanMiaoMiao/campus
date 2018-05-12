package com.xust.campus.dao;

import com.xust.campus.entity.Login;
import com.xust.campus.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;
    @Test
    public void checkLogin() throws Exception {
        System.out.println("00000000000000000000+------》"+loginMapper.checkLogin("18392624802",MD5Util.generate("zgsxh15319246936","18392624809")));
    }

}