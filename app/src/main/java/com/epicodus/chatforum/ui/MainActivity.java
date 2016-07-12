package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epicodus.chatforum.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bStart)
    Button mStart;


    ArrayList<String> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mStart.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
        startActivity(intent);
    }
}
