package com.xust.campus.controller;

import com.xust.campus.service.LoginService;
import com.xust.campus.vo.response.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private LoginService loginService;


//    @RequestMapping(value="/Login/login",method= RequestMethod.POST)
//    @ResponseBody
//    public Msg login(String userNumber, String password, HttpSession session){
//        logger.debug("进入login方法"+"  "+userNumber+"  "+password);
//        return loginService.login(userNumber,password,session);
//    }
}
