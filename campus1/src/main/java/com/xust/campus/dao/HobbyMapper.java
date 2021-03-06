package com.xust.campus.dao;

import com.xust.campus.entity.Hobby;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyMapper {




    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    int deleteByPrimaryKey(Integer hobbyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    int insert(Hobby record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    int insertSelective(Hobby record);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    Hobby selectByPrimaryKey(Integer hobbyId);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    int updateByPrimaryKeySelective(Hobby record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hobby
     *
     * @mbg.generated Sat Apr 21 22:40:36 CST 2018
     */
    int updateByPrimaryKey(Hobby record);
}