package com.epicodus.chatforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.chatforum.Constants;
import com.epicodus.chatforum.R;
import com.epicodus.chatforum.models.Category;
import com.epicodus.chatforum.ui.CategoriesActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FirebaseCategoryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseCategoryViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCategory(Category categoryName) {
        TextView categoriesTextView = (TextView) mView.findViewById(R.id.titleTextView);

        categoriesTextView.setText(categoryName.getCategoryName());
    }

    @Override
    public void onClick(View view) {
    }
}
