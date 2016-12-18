package com.example.a303.teachlink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Loging extends AppCompatActivity {
    private EditText ET_Username,ET_Password;
    private Button BT_Login;
    private User user;
    private String username,password;
    private int identity;//0:身分錯誤，1:教師，2:學生
    //*****juiz*******
    private static Handler mHandler;
    //***************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);

        findViews();
        setBTListener();
        //*****juiz*******get
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //What you want to do with these data? Just write here!
                super.handleMessage(msg);
                Bundle bundle= msg.getData();
                int select=msg.what;
                /*num 1: login*/
                String content = bundle.getString("content");//json
                //#code......................................................
                try {
                    JSONObject obj = new JSONObject(content);
                    String job,accept;
                    int jobint,acceptint;
                    job=obj.getString("job");
                    accept=obj.getString("login");
                    jobint=Integer.valueOf(job);
                    acceptint=Integer.valueOf(accept);
                    if (acceptint==0){
                        jobint=0;
                    }
                    checkIdentity(jobint);
                } catch (JSONException e) {
                    e.printStackTrace();
                }




                //Toast.makeText(Loging.this, content, Toast.LENGTH_SHORT).show();
                //#code............................................................


            }
        };
        //*****juiz*******
    }


    private void setBTListener() {
        BT_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=ET_Username.getText().toString();
                password=ET_Password.getText().toString();
                //********juiz*********send
                try {
                    URL url = new URL("http://192.168.1.170");
                    ArrayMap<String , String> reqData = new ArrayMap();
                    reqData.put("select","login");
                    reqData.put("username",username);
                    reqData.put("password",password);
                    WebData webData = new WebData(url,mHandler);
                    webData.setReqData(reqData);
                    webData.getData();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                //*****************
            }
        });
    }

    private void checkIdentity(int idget) {
        Context context=this;
        this.identity=idget;
        user=new User(username,password,identity);
        if (identity==1)//師
        {
            Intent intent=new Intent(context,TeacherMain.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("user",user);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if (identity==2)//生
        {
            Intent intent=new Intent(context,StudentMain.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("user",user);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else//錯誤
        {
            Toast.makeText(context,R.string.ErrorMessage1,Toast.LENGTH_LONG).show();
        }
    }


    private void findViews() {
        ET_Username=(EditText)findViewById(R.id.ET_Username);
        ET_Password=(EditText)findViewById(R.id.ET_Password);
        BT_Login=(Button)findViewById(R.id.BT_Login);
    }
}
