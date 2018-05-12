package com.xust.campus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Component
public class Login {

    private Integer loginId;

    private String  loginNumber;


    private String loginPwd;


    private Date createAt;


    private Date updateAt;


    private String deleted;

    public Integer getLoginId() {
        return loginId;
    }

    public String  getLoginNumber() {
        return loginNumber;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public void setLoginNumber(String  loginNumber) {
        this.loginNumber = loginNumber;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", loginNumber=" + loginNumber +
                ", loginPwd='" + loginPwd + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}