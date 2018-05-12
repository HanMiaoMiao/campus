package com.xust.campus.service.impl;


import com.xust.campus.dao.LoginMapper;
import com.xust.campus.entity.Login;
import com.xust.campus.service.LoginService;
import com.xust.campus.util.MD5Util;
import com.xust.campus.vo.response.Msg;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
/**
 * @Author hanmiaomiao
 * @Date 2018/5/12
 * 实现LoginService 接口
 */


@Service
public class LoginServiceImpl implements LoginService{
    private final LoginMapper loginMapper;

    private Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Msg checkLogin(String userNumber, String password) {
        Integer check=loginMapper.checkLogin(userNumber,password);
        if(check==1){
            return Msg.success(200102,"用户信息正确！");
        }else{
            return Msg.fail(202102,"账号或者密码输入错误,请重新输入!");
        }
    }

    /**
     * 向数据库login表中插入一个用户，由ConsumerService/insert()调用
     * @param login
     * @return
     */
    @Override
    public boolean insert(Login login) {
        return loginMapper.insert(login);
    }

    @Override
    public Msg login(String userNumber, String password, HttpSession session) {
        //判断段用户信息是否正确
        String code= MD5Util.generate(password,userNumber);
        Msg msg=checkLogin(userNumber, password);
        return null;
    }
}
