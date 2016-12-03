package com.example.a303.teachlink;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 303 on 2016/12/2.
 */
//每一門課
public class Classes implements Serializable {
    private ArrayList<String> timeList=new ArrayList<String>();
    private String classname;

    public Classes( String classname) {
        this.classname = classname;
        updateTime();
    }

    private void updateTime() {//給classes名抓時間回來
        timeList.add(0,"01/01");
        timeList.add(1,"01/02");
    }

    public ArrayList<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(ArrayList<String> timeList) {
        this.timeList = timeList;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
