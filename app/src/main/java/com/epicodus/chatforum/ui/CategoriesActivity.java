package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.epicodus.chatforum.Constants;
import com.epicodus.chatforum.R;
import com.epicodus.chatforum.adapters.FirebaseCategoryViewHolder;
import com.epicodus.chatforum.models.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference mCreateNewCategoryReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.bNewCategory)
    Button mNewCategory;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


//    private String[] categories = new String[] {"What's the deal with airline food?", "What is the meaning of life?", "Crazy cat photo", "Look at these puppies", "Organic or not Organic", "Bike lock security"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        mCreateNewCategoryReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_NEW_CATEGORY);
        setUpFirebaseAdapter();

        mNewCategory.setOnClickListener(this);

    }

    private void setUpFirebaseAdapter() {
            mFirebaseAdapter = new FirebaseRecyclerAdapter<Category, FirebaseCategoryViewHolder>
                    (Category.class, R.layout.category_list_item, FirebaseCategoryViewHolder.class,
                            mCreateNewCategoryReference) {

                @Override
                protected void populateViewHolder(FirebaseCategoryViewHolder viewHolder,
                                                  Category model, int position) {
                    viewHolder.bindCategory(model);
                }
            };

            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mFirebaseAdapter);
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CategoriesActivity.this, NewCategoryActivity.class);
        startActivity(intent);
    }


}

