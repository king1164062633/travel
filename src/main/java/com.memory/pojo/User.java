package com.memory.pojo;

/**
 * Created by Administrator on 2017/9/13.
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private Integer state;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getState() {
        return state;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
