package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epicodus.chatforum.R;

import butterknife.Bind;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.lCategories)
    ListView mLCategories;
    @Bind(R.id.bNewCategory)
    Button mNewCategory;

    private String[] categories = new String[] {"What's the deal with airline food?", "What is the meaning of life?", "Crazy cat photo", "Look at these puppies", "Organic or not Organic", "Bike lock security"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mLCategories = (ListView) findViewById(R.id.lCategories);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categories);
        mLCategories.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(CategoriesActivity.this, NewCategoryActivity.class);
        startActivity(intent);
    }
}
