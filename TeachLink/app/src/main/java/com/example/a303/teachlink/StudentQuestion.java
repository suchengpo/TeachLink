package com.example.a303.teachlink;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class StudentQuestion extends AppCompatActivity {
    private User user;
    private Button BT_AnswerA,BT_AnswerB,BT_AnswerC,BT_AnswerD;
    private String myanswer,correctanswer;
    //*****juiz*******
    private static Handler mHandler;
    //***************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_question);

        findViews();
        Bundle bundle=getIntent().getExtras();
        user=(User) bundle.getSerializable("user");

        if (user !=null)
        {
            setListener();
            //*****juiz*******get
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    //What you want to do with these data? Just write here!
                    super.handleMessage(msg);
                    Bundle bundle = msg.getData();
                    int select = msg.what;
                /*num 1: login*/
                    String content = bundle.getString("content");//json
                    //#code......................................................

                    Toast.makeText(StudentQuestion.this,content,Toast.LENGTH_LONG).show();
                    //Toast.makeText(Loging.this, content, Toast.LENGTH_SHORT).show();
                    //#code............................................................
                }
        };
        }
    }

    private void setListener() {
        BT_AnswerA.setOnClickListener(listener);
        BT_AnswerB.setOnClickListener(listener);
        BT_AnswerC.setOnClickListener(listener);
        BT_AnswerD.setOnClickListener(listener);
    }

    View.OnClickListener listener=new View.OnClickListener() {
        Context context=StudentQuestion.this;
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.BT_AnswerA)
            {
                myanswer="a";

            }
            if (v.getId()==R.id.BT_AnswerB)
            {
                myanswer="b";

            }
            if (v.getId()==R.id.BT_AnswerC)
            {
                myanswer="c";

            }
            if (v.getId()==R.id.BT_AnswerD)
            {
                myanswer="d";

            }

            //********juiz*********send
            try {
                URL url = new URL("http://192.168.1.170");
                ArrayMap<String , String> reqData = new ArrayMap();
                reqData.put("select","stu_ans");
                reqData.put("stuAns",myanswer);
                WebData webData = new WebData(url,mHandler);
                webData.setReqData(reqData);
                webData.getData();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //*****************

        }
    };





    private void findViews() {
        BT_AnswerA=(Button)findViewById(R.id.BT_AnswerA);
        BT_AnswerB=(Button)findViewById(R.id.BT_AnswerB);
        BT_AnswerC=(Button)findViewById(R.id.BT_AnswerC);
        BT_AnswerD=(Button)findViewById(R.id.BT_AnswerD);
    }
}
