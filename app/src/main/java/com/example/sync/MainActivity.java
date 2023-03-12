package com.example.sync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LayoutInflater layoutInflater;

    // LINK LAYOUT
    View add_link;
    ScrollView scroll;
    GridLayout gridLayout;
    model_link model_link;
    public static ArrayList<model_link> model_linkArrayList=new ArrayList<>();
    ArrayList<model_link> model_linkArrayList_2=new ArrayList<>();
    //TAGS LAYOUT
    LinearLayout tagslayout;
    EditText tagEtTxt;
    View add_btn;
    // THEME CHANGE VIEWS
    View light_theme_btn,dark_theme_btn;
    ImageView light_theme_img,dark_theme_img;
    // COLOR CHANGING VIEWS
    View red,orange,green,blue,dblue,purple,black;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DECLARATIONS

         layoutInflater=LayoutInflater.from(getBaseContext());


        // FINDVIEW BY IDS

        // LINK LAYOUT
        add_link=findViewById(R.id.add_link);
        scroll=findViewById(R.id.scroll);
        scroll.requestFocus();

        scroll.smoothScrollTo(0,0);
        scroll.fullScroll(ScrollView.FOCUS_UP);

        gridLayout=findViewById(R.id.gridLayout);
        // TAGS LAYOUT

        tagEtTxt=findViewById(R.id.tagEtTxt);
        tagslayout=findViewById(R.id.tags_layout);
        add_btn=findViewById(R.id.add_btn);

        // THEME CHANGER

        light_theme_btn=findViewById(R.id.light_theme_btn);
        dark_theme_btn=findViewById(R.id.dark_theme_btn);
        light_theme_img=findViewById(R.id.light_theme_img);
        dark_theme_img=findViewById(R.id.dark_theme_img);

        //COLOR CHANGER
        red=findViewById(R.id.red);
        orange=findViewById(R.id.orange);
        green=findViewById(R.id.green);
        blue=findViewById(R.id.blue);
        dblue=findViewById(R.id.dblue);
        purple=findViewById(R.id.purple);
        black=findViewById(R.id.black);
        // CLICKLISTENERS


        //LINK LAYOUT
        add_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, com.example.sync.add_link.class);
                startActivity(intent);
//                View link_layout=layoutInflater.inflate(R.layout.link_layout,null,false);
//                gridLayout.addView(link_layout,0);
            }
        });
        // TAGS LAYOUT
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View tag_layout=layoutInflater.inflate(R.layout.tag_layout,null,false);
                TextView tag_txt=tag_layout.findViewById(R.id.tag_txt);
                ImageView tag_cross=tag_layout.findViewById(R.id.tag_cross);
                String tagtxt=tagEtTxt.getText().toString();
                tag_txt.setText(tagtxt);
                tagslayout.setTag(tagslayout.getChildCount());

                tag_cross.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View parent_1= (View) tag_cross.getParent();
                        View parent_2= (View) parent_1.getParent();
                        View parent_3= (View) parent_2.getParent();
                        tagslayout.removeView(parent_3);

                    }
                });
                tagslayout.addView(tag_layout);
            }
        });

        // THEME CHANGER
        light_theme_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_change_method(light_theme_img);
            }
        });
        dark_theme_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_change_method(dark_theme_img);
            }
        });
        //COLOR CHANGER


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(red,0);
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(orange,1);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(green,2);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(blue,3);
            }
        });
        dblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(dblue,4);
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(purple,5);
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color_changer(black,6);
            }
        });

    }
    //METHODS
    // THEME CHANGER
    public void theme_change_method(ImageView imageView){
        light_theme_img.setVisibility(View.INVISIBLE);
        dark_theme_img.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.VISIBLE);
    }
    // COLOR CHANGER
    public void color_changer(View view,int code){
        red.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.red_circle_bg) );
        orange.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.orange_circle_bg) );
        green.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.green_circle_bg) );
        blue.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.blue_circle_bg) );
        dblue.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.dblue_circle_bg) );
        purple.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.purple_circle_bg) );
        black.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.black_circle_bg) );
        switch (code){
            case 0:
                red.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.red_circle_outline_bg));
                break;
            case 1:
                orange.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.orange_circle_outline_bg));
                break;
            case 2:
                green.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.green_circle_outline_bg));
                break;
            case 3:
                blue.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.blue_circle_outline_bg));
                break;
            case 4:
                dblue.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.dblue_circle_outline_bg));
                break;
            case 5:
                purple.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.purple_circle_outline_bg));
                break;
            case 6:
                black.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.black_circle_outline_bg));
                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (model_linkArrayList!=null){




           gridLayout.removeAllViews();
            View add_layout=layoutInflater.inflate(R.layout.add_layout,null,false);
            add_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this, com.example.sync.add_link.class);
                    startActivity(intent);
                }
            });
           gridLayout.addView(add_layout);

            for (int i=0;i<model_linkArrayList.size();i++){
                Log.d("TAG", "XXX: size of arraylist"+String.valueOf(model_linkArrayList.size()));
                Toast.makeText(this, String.valueOf(model_linkArrayList.size()), Toast.LENGTH_SHORT).show();
                View link_layout=layoutInflater.inflate(R.layout.link_layout,null,false);
                TextView link_txt=link_layout.findViewById(R.id.link_txt);
                ImageView link_img=link_layout.findViewById(R.id.link_img);
               model_link=model_linkArrayList.get(i);
                switch (model_link.company){
                    case 0:
                        link_txt.setText("Facebook");
                        link_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.fb));
                        gridLayout.addView(link_layout,0);

                        break;
                    case 1:
                        link_txt.setText("LinkedIn");
                        link_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.linkedin));
                        gridLayout.addView(link_layout,0);

                        break;
                    case 2:
                        link_txt.setText("Instagram");
                        link_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.insta));
                        gridLayout.addView(link_layout,0);
                        break;
                    case 3:
                        link_txt.setText("Tiktok");
                        link_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.tiktok));
                        gridLayout.addView(link_layout,0);
                        break;
                    case 4:
                        link_txt.setText("Safari");
                        link_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.safari));
                        gridLayout.addView(link_layout,0);
                        break;

                }
            }

        }
    }
}