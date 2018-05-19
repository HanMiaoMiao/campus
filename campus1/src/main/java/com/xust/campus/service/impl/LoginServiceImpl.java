package com.xust.campus.service.impl;


import com.xust.campus.dao.LoginMapper;
import com.xust.campus.entity.Login;
import com.xust.campus.service.LoginService;
import com.xust.campus.util.MD5Util;
import com.xust.campus.util.TokenManager;
import com.xust.campus.vo.TokenModel;
import com.xust.campus.vo.response.Msg;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    private TokenManager tokenManager;
    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    /**
     * 检查是否有次用户
     */
    public Msg checkLogin(String userNumber, String password) {
        Integer check=loginMapper.checkLogin(userNumber,password);
        boolean cb=loginMapper.checkUserByNumber(userNumber);
        if(check==1&&cb==true){
            return Msg.success(Msg.INFORMATING_MATCHING_CODE,"用户信息正确！");
        }else if(cb==false){
            return Msg.fail(Msg.USER_NOT_EXIST_CODE,"用户不存在!");
        }else{
            return Msg.fail(Msg.INPUT_ERROR_CODE,"账号或者密码输入错误,请重新输入!");
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
    public Msg login(String userNumber, String password) {
        //判断用户信息是否正确
        String code= MD5Util.generate(password,userNumber);
        Msg msg=checkLogin(userNumber, code);
        if(msg.getCode()!=Msg.INFORMATING_MATCHING_CODE){
            return msg;
        }
        TokenModel tokenModel=tokenManager.createToken(userNumber);
        System.out.println("11111111111111111111111111111111111111111111------------tokenModel"+tokenModel);
        Map data=new HashMap();
        String token=userNumber+"_"+tokenModel.getToken();
        data.put("token",token);
        msg.setData(data);
        System.out.println("9999999999999999999999999999999999999999999999---------msgtoken"+msg);
        return msg;
    }

    @Override
    public boolean selectUserByNumber(String userNumber) {
        return loginMapper.checkUserByNumber(userNumber);
    }
}
