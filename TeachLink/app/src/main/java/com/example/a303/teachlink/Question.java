package com.example.a303.teachlink;

import java.util.ArrayList;

/**
 * Created by 303 on 2016/12/18.
 */

public class Question {
    private String classname,title,std_ans;
    private ArrayList<String> ans=new ArrayList<String>();

    public Question(String classname, String title, String std_ans, ArrayList<String> ans) {
        this.classname = classname;
        this.title = title;
        this.std_ans = std_ans;
        this.ans = ans;
    }
}
