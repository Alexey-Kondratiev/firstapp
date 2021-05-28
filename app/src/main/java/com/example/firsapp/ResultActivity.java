package com.example.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class ResultActivity extends Activity {

//    boolean[] results=new boolean[6];
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_result);
       
    Intent intent=getIntent();
    String results= intent.getStringExtra("results");

    }
}
