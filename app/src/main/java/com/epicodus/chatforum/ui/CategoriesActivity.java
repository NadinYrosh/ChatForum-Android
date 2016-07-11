package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epicodus.chatforum.Constants;
import com.epicodus.chatforum.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference mCreateNewCategoryReference;
    private ValueEventListener mCreateNewCategoryReferenceListener;
    @Bind(R.id.lCategories)
    ListView mLCategories;
    @Bind(R.id.bNewCategory)
    Button mNewCategory;

    private String[] categories = new String[] {"What's the deal with airline food?", "What is the meaning of life?", "Crazy cat photo", "Look at these puppies", "Organic or not Organic", "Bike lock security"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mCreateNewCategoryReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_NEW_CATEGORY);

        mCreateNewCategoryReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot: dataSnapshot.getChildren()) {
                    String category = categorySnapshot.getValue().toString();
                    Log.d("categories updated", "category" + category);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mLCategories = (ListView) findViewById(R.id.lCategories);
        ButterKnife.bind(this);
        mNewCategory.setOnClickListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categories);
        mLCategories.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CategoriesActivity.this, NewCategoryActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCreateNewCategoryReference.removeEventListener(mCreateNewCategoryReferenceListener);
    }
}

