package com.xust.campus.service.impl;

import com.xust.campus.dao.ConsumerMapper;
import com.xust.campus.dao.LoginMapper;
import com.xust.campus.entity.Consumer;
import com.xust.campus.entity.Login;
import com.xust.campus.service.ConsumerService;
import com.xust.campus.util.MD5Util;
import com.xust.campus.vo.request.Register;
import com.xust.campus.vo.response.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService{

    private ConsumerMapper consumerMapper;
    private LoginMapper loginMapper;

    @Autowired
    public ConsumerServiceImpl(ConsumerMapper consumerMapper, LoginMapper loginMapper) {
        this.consumerMapper = consumerMapper;
        this.loginMapper = loginMapper;
    }


    /**
     * 向login表和consumer表插入一条用户信息
     */
    public Msg insertSelective(Register register) {
        //原始密码
        String userpwd=register.getUserpwd();
        String userNumber=register.getUserNumber();
        String target=register.getTarget();

        //MD５加密后
        String md5Pwd=MD5Util.generate(userpwd,userNumber);

        //login 表
        Login login=new Login();
        login.setLoginPwd(md5Pwd);
        login.setLoginNumber(userNumber);
        login.setDeleted("0");

        //consumer表
        Consumer consumer=new Consumer();
        consumer.setConsumerNumber(userNumber);
        consumer.setConsumerIdentity(target);
        consumer.setDeleted("0");

        if( loginMapper.insert(login)&&consumerMapper.insertSelective(consumer)){
            return Msg.success(200101,"注册成功");
        }
        return Msg.fail(202101,"注册失败！");
    }
}
