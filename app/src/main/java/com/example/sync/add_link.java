package com.example.sync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class add_link extends AppCompatActivity {


    View save,back;
    EditText username;
    View add_link;
    boolean flag=true;
    int check_mark;
    ArrayList<model_link> model_linkArrayList=MainActivity.model_linkArrayList;
    View fb_layout,linked_layout,insta_layout,tiktok_layout,safari_layout;
    View fb_comp,linked_comp,insta_comp,tiktok_comp,safari_comp;
    model_link model_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_link);

        // FVI
        save=findViewById(R.id.save);
        back=findViewById(R.id.back);
        username=findViewById(R.id.username);

        add_link=findViewById(R.id.add_link);

        fb_comp=findViewById(R.id.fb_comp);
        linked_comp=findViewById(R.id.linked_comp);
        insta_comp=findViewById(R.id.insta_comp);
        tiktok_comp=findViewById(R.id.tiktok_comp);
        safari_comp=findViewById(R.id.safari_comp);

        fb_layout=findViewById(R.id.fb_layout);
        linked_layout=findViewById(R.id.linked_layout);
        insta_layout=findViewById(R.id.insta_layout);
        tiktok_layout=findViewById(R.id.tiktok_layout);
        safari_layout=findViewById(R.id.safari_layout);
        //

        fb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_link.setVisibility(View.VISIBLE);
                check_mark=0;
            }
        });
        linked_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_link.setVisibility(View.VISIBLE);
                check_mark=1;
            }
        });
        insta_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_link.setVisibility(View.VISIBLE);
                check_mark=2;
            }
        });
        tiktok_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_link.setVisibility(View.VISIBLE);
                check_mark=3;
            }
        });
        safari_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_link.setVisibility(View.VISIBLE);
                check_mark=4;

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(add_link.this, String.valueOf(model_linkArrayList.size()), Toast.LENGTH_SHORT).show();
                if (!model_linkArrayList.isEmpty()){

                    for (int i=0;i<model_linkArrayList.size();i++){
                        model_link=model_linkArrayList.get(i);
                        if (model_link.getCompany()==check_mark){
                            Log.d("TAG", "XXX: "+"check");
                            Toast.makeText(add_link.this, "check", Toast.LENGTH_SHORT).show();
                            flag=false;}
                    }
                    if (flag){
                        Log.d("TAG", "XXX: "+"added");
                        Toast.makeText(add_link.this, "added 2", Toast.LENGTH_SHORT).show();
                        model_link=new model_link(check_mark,username.getText().toString(),true);
                        model_linkArrayList.add(model_link);
                        Log.d("TAG", "XXX: size of arraylist"+String.valueOf(model_linkArrayList.size()));
                        finish();
                    }
                }else{
                    Log.d("TAG", "XXX: "+"first added");
                    Toast.makeText(add_link.this, "added 2", Toast.LENGTH_SHORT).show();
                    model_link=new model_link(check_mark,username.getText().toString(),true);
                    model_linkArrayList.add(model_link);
                    Log.d("TAG", "XXX: size of arraylist"+String.valueOf(model_linkArrayList.size()));
                    finish();
                }



             
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (model_linkArrayList==null){
            fb_comp.setVisibility(View.GONE);
            linked_comp.setVisibility(View.GONE);
            insta_comp.setVisibility(View.GONE);
            tiktok_comp.setVisibility(View.GONE);
            safari_comp.setVisibility(View.GONE);
        }else{
            for (int i=0;i<model_linkArrayList.size();i++){

                model_link=model_linkArrayList.get(i);
                switch (model_link.company){
                    case 0:
                        fb_comp.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        linked_comp.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        insta_comp.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        tiktok_comp.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        safari_comp.setVisibility(View.VISIBLE);
                        break;

                }
            }
        }



    }
}