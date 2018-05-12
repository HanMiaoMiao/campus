package com.xust.campus.dao;

import com.xust.campus.entity.Consumer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerMapper {



    int deleteByPrimaryKey(Integer consumerId);








    Consumer selectByPrimaryKey(Integer consumerId);




    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKeyWithBLOBs(Consumer record);

    int updateByPrimaryKey(Consumer record);

    /**
     * 向数据库中插入一条用户信息
     * @param record
     * @return
     */
    int insert(Consumer record);
    boolean insertSelective(Consumer record);
}