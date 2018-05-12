package com.xust.campus.dao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.xust.campus.BaseTest;
import com.xust.campus.entity.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


public class testLoginDao extends BaseTest {
    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void testInsert(){
        Login login=new Login();
        login.setLoginNumber("1839262480");
        login.setLoginPwd("456789522");
        loginMapper.insert(login);
    }
}
