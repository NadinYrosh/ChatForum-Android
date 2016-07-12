package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.epicodus.chatforum.Constants;
import com.epicodus.chatforum.R;
import com.epicodus.chatforum.models.Category;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bCreateNew)
    Button mCreateNew;
    @Bind(R.id.userInput)
    EditText mUserInput;
    private DatabaseReference mCreateNewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mCreateNewCategory = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_NEW_CATEGORY);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        ButterKnife.bind(this);
        mCreateNew.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String categoryName = mUserInput.getText().toString();
        Category category = new Category(categoryName);
        saveCategoryToFirebase(category);
        Intent intent = new Intent(NewCategoryActivity.this, CategoriesActivity.class);
        startActivity(intent);

    }
    public void saveCategoryToFirebase(Category categoryName) {
        mCreateNewCategory.push().setValue(categoryName);
    }
}
