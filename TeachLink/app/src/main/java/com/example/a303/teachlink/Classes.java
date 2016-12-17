package com.example.a303.teachlink;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 303 on 2016/12/2.
 */
//每一門課
public class Classes implements Serializable {
    private ArrayList<User> userList=new ArrayList<User>();
    private RollCall classrollcall;
    private String classname;

    public Classes( String classname) {
        this.classname = classname;

    }





    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
