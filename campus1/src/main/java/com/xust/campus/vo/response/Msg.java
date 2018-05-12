package com.xust.campus.vo.response;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    public static final int SUCCESS_CODE=200;
    public static final int FAIL_CODE=202;
    public static final int AUTH_FAIL_CODE=202100;
    public static final int LOGIN_UNAVAILABLE_CODE=202200;
    public static final int LOGIN_ERROR_CODE=202204;

    public static final String SUCCESS_MSG="处理成功！";
    public static final String FAIL_MSG="处理失败！";
    public static final String AUTH_FAIL_MSG="权限不足！";
    public static final String LOGIN_UNAVAILABLE_MSG="登录信息不可用！";
    public static final String LOGIN_ERROR_MSG="用户名或者密码不正确";

    private int code;

    private String msg;
    private Map<String, Object> extend=new HashMap<String, Object>();
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend=extend;
    }

    public static Msg success() {
        return new Msg(SUCCESS_CODE, SUCCESS_MSG);
    }
    public static Msg success(int code,String msg){
        return new Msg(code,msg);
    }

    public static Msg fail() {
        return new Msg(FAIL_CODE, FAIL_MSG);
    }

    public static Msg fail(int code, String msg) {
        return new Msg(code, msg);
    }

    public static Msg loginUnavailable() {
        return new Msg(LOGIN_UNAVAILABLE_CODE, LOGIN_UNAVAILABLE_MSG);
    }

    public Msg add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }
    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Msg(int code, String msg, Map<String, Object> extend) {
        this.code=code;
        this.msg=msg;
        this.extend=extend;
    }

    @Override
    public String toString() {
        return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
    }
}
