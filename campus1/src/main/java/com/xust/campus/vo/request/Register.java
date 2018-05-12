package com.xust.campus.vo.request;

public class Register {
    private String userNumber;
    private String userpwd;
    private String target;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userNumber='" + userNumber + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", target=" + target +
                '}';
    }
}
