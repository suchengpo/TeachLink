package com.example.a303.teachlink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TeacherHistoryShow extends AppCompatActivity {
    private RecyclerView rvClass;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_history_show);

        List<Classes> classesList=getClassList();
        rvClass=(RecyclerView) findViewById(R.id.RV_Class);
        rvClass.setLayoutManager(new LinearLayoutManager(this));
        rvClass.setAdapter(new ClassAdapter(this,classesList));
        Bundle bundle=getIntent().getExtras();
        user=(User) bundle.getSerializable("user");
    }

    private List<Classes> getClassList() {
        List<Classes> classesList=new ArrayList<>();
        //讀資料
        classesList.add(new Classes("Math",5));
        classesList.add(new Classes("English",10));
        classesList.add(new Classes("Chinese",7));
        return classesList;
    }

    public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder>{
        Context context;
        List<Classes> classesList;
        public ClassAdapter(Context context, List<Classes> classesList) {
            this.context=context;
            this.classesList=classesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.item_view,parent,false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final Classes classes =classesList.get(position);
            holder.TV_ClassName.setText(classes.getClassname());
            holder.TV_Accuracy.setText(Integer.toString(classes.getAccuracy()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,spot.getName(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,Detail.class);
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("Classes",classes);
//                    bundle.putInt("ImageID",spot.getImageId());
//                    bundle.putString("name",spot.getName());
//                    bundle.putString("phone",spot.getPhone());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return classesList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView TV_ClassName,TV_Accuracy;
            public MyViewHolder(View itemView) {
                super(itemView);
                TV_ClassName=(TextView) itemView.findViewById(R.id.TV_ClassName);
                TV_Accuracy=(TextView) itemView.findViewById(R.id.TV_Accuracy);
            }
        }
    }


}
