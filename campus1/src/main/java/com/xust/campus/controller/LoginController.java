package com.xust.campus.controller;

import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.xust.campus.annotation.Authorization;
import com.xust.campus.annotation.CurrentUser;
import com.xust.campus.entity.Login;
import com.xust.campus.service.LoginService;
import com.xust.campus.util.TokenManager;
import com.xust.campus.vo.response.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private LoginService loginService;
    @Autowired
    private TokenManager tokenManager;


    @RequestMapping(value="/yu",method = RequestMethod.GET)

    @ResponseBody
    public String yu (){
        return "yu";
    }
    /**
     * 登录
     * @param userNumber
     * @param password
     * @return
     */
    @RequestMapping(value="/Login/login",method= RequestMethod.POST)
    @ResponseBody
    public Msg login(@RequestParam String userNumber, @RequestParam String password){
        logger.debug("进入login方法"+"  "+userNumber+"  "+password);
        Assert.notNull(userNumber,"userNumber can not be empty");
        Assert.notNull(password,"password can not be empty");
       // Msg msg=loginService.checkLogin(userNumber,password);
        return loginService.login(userNumber,password);
    }
    @RequestMapping(value = "/Login/logout",method=RequestMethod.DELETE)
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @Authorization
    public Msg logout( @CurrentUser Login login){
        System.out.println("8888888888888888888888888888888888888888888888888888/Login/logout");

       //tokenManager.deleteToken(login.getLoginNumber());
        return Msg.success();
    }

}
