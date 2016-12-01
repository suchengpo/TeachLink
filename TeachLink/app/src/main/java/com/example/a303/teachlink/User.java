package com.example.a303.teachlink;

import java.io.Serializable;

/**
 * Created by 303 on 2016/11/28.
 */
public class User implements Serializable {
    private String username,password;
    private int identity;//0:身分錯誤，1:教師，2:學生

    public User(String username, String password, int identity) {
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
