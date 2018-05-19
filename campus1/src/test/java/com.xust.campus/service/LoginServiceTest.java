package com.xust.campus.service;

import com.xust.campus.BaseTest;
import com.xust.campus.util.MD5Util;
import com.xust.campus.vo.response.Msg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LoginServiceTest extends BaseTest {
    @Autowired
    private LoginService loginService;
    @Test
    public void checkLogin() throws Exception {
        System.out.println("00000000000000000000+------》"+loginService.checkLogin("18392624808", MD5Util.generate("zgsxh15319246936","18392624808")));

    }
    @Test
    public void loginTest(){

        Msg msg=loginService.login("18392624808","zgsxh15319246936");

        System.out.println("========================================>>>"+msg);
    }

}