package com.xust.campus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Date;

public class Consumer {

    private Integer consumerId;
    private String consumerName;
    private String consumerSex;
    private String consumerNickname;
    private String  consumerNumber;
    private String consumerSchool;
    private String consumerInstitute;
    private String consumerMajor;
    private String consumerGrade;
    private String consumerIdentity;
    private Integer attention;
    private Integer fan;
    private Date createAt;
    private Date updateAt;

    @Override
    public String toString() {
        return "Comsumer{" +
                "consumerId=" + consumerId +
                ", consumerName='" + consumerName + '\'' +
                ", consumerSex='" + consumerSex + '\'' +
                ", consumerNickname='" + consumerNickname + '\'' +
                ", consumerNumber='" + consumerNumber + '\'' +
                ", consumerSchool='" + consumerSchool + '\'' +
                ", consumerInstitute='" + consumerInstitute + '\'' +
                ", consumerMajor='" + consumerMajor + '\'' +
                ", consumerGrade='" + consumerGrade + '\'' +
                ", consumerIdentity='" + consumerIdentity + '\'' +
                ", attention=" + attention +
                ", fan=" + fan +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted='" + deleted + '\'' +
                ", consumerHead=" + Arrays.toString(consumerHead) +
                '}';
    }

    public String getConsumerMajor() {
        return consumerMajor;
    }

    public void setConsumerMajor(String consumerMajor) {
        this.consumerMajor = consumerMajor;
    }

    public String getConsumerGrade() {
        return consumerGrade;
    }

    public void setConsumerGrade(String consumerGrade) {
        this.consumerGrade = consumerGrade;
    }

    public String getConsumerIdentity() {
        return consumerIdentity;
    }

    public void setConsumerIdentity(String consumerIdentity) {
        this.consumerIdentity = consumerIdentity;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getFan() {
        return fan;
    }

    public void setFan(Integer fan) {
        this.fan = fan;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public byte[] getConsumerHead() {
        return consumerHead;
    }

    public void setConsumerHead(byte[] consumerHead) {
        this.consumerHead = consumerHead;
    }

    private String deleted;

    private byte[] consumerHead;

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerSex() {
        return consumerSex;
    }

    public void setConsumerSex(String consumerSex) {
        this.consumerSex = consumerSex;
    }

    public String getConsumerNickname() {
        return consumerNickname;
    }

    public void setConsumerNickname(String consumerNickname) {
        this.consumerNickname = consumerNickname;
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getConsumerSchool() {
        return consumerSchool;
    }

    public void setConsumerSchool(String consumerSchool) {
        this.consumerSchool = consumerSchool;
    }

    public String getConsumerInstitute() {
        return consumerInstitute;
    }

    public void setConsumerInstitute(String consumerInstitute) {
        this.consumerInstitute = consumerInstitute;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}