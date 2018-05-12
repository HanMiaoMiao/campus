package com.xust.campus.dao;

import com.xust.campus.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {



    int deleteByPrimaryKey(Integer loginId);



    boolean insertSelective(Login record);


    Login selectByPrimaryKey(Integer loginId);



    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    /**
     * 检查用户账号和密码是否匹配
     * @param userNumber
     * @param password
     * @return
     */
    Integer checkLogin(@Param("userNumber")String userNumber,
                       @Param("password")String password);
    boolean insert(Login record);
}