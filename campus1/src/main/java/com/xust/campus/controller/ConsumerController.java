package com.xust.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.xust.campus.entity.Consumer;
import com.xust.campus.service.ConsumerService;
import com.xust.campus.vo.request.Register;
import com.xust.campus.vo.response.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ConsumerController {
    private Logger logger= LoggerFactory.getLogger(ConsumerController.class);

    @Resource
    private ConsumerService consumerService;



    @RequestMapping(value="Consumer/register",method= RequestMethod.POST)
    @ResponseBody
    public Msg register(@RequestBody Register register, HttpServletResponse response){
       return consumerService.insertSelective(register);
    }
}
