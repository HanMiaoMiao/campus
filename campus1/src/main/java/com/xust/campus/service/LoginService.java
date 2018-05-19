package com.xust.campus.service;

import com.xust.campus.entity.Login;
import com.xust.campus.vo.response.Msg;

import javax.servlet.http.HttpSession;

/**
 * 提供登录相关接口
 * 由LoginServiceImpl提供相关实现
 * Created by hanmiaomiao on 2018/5/12
 */
public interface LoginService {
    /**
     *
     * @param userNumber
     * @param password
     * @return
     */
    Msg checkLogin(String userNumber,String password);
    boolean insert(Login login);
    Msg login(String userNumber, String password);

    /**
     * 查找是否有此用户
     * @param userNumber
     * @return
     */
    boolean selectUserByNumber(String userNumber);


}
