package com.example.a303.teachlink;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    private TextView TV_ClassName,TV_Accuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViews();
        Bundle bundle=getIntent().getExtras();
        Classes classes=(Classes) bundle.getSerializable("Classes");

        if (classes!=null)
        {
            TV_ClassName.setText(classes.getClassname());
            TV_Accuracy.setText(Integer.toString(classes.getAccuracy()));
        }
    }

    private void findViews() {
        TV_ClassName=(TextView) findViewById(R.id.TV_ClassName);
        TV_Accuracy=(TextView) findViewById(R.id.TV_Accuracy);
    }
}
