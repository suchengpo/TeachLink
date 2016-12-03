package com.example.a303.teachlink;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loging extends AppCompatActivity {
    private EditText ET_Username,ET_Password;
    private Button BT_Login;
    private User user;
    private String username,password;
    private int identity;//0:身分錯誤，1:教師，2:學生

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);

        findViews();
        setBTListener();
    }

    private void setBTListener() {
        BT_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=ET_Username.getText().toString();
                password=ET_Password.getText().toString();
                checkIdentity();
            }
        });
    }

    private void checkIdentity() {
        Context context=this;
        identity=1;//假資料1
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
