package com.xust.campus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class Hobby {

    private Integer hobbyId;


    private String hobbyContent;


    private Integer consumerNumber;


    private Date createAt;


    private Date updateAt;

    private String deleted;


}