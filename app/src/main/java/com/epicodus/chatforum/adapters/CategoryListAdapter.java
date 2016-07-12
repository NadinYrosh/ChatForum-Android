package com.epicodus.chatforum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.epicodus.chatforum.R;
import com.epicodus.chatforum.models.Category;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/11/16.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    private ArrayList<Category> mCategories = new ArrayList<>();
    private Context mContext;

    public CategoryListAdapter(Context context, ArrayList<Category> categories) {
        mContext = context;
        mCategories = categories;
    }

    @Override
    public CategoryListAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryListAdapter.CategoryViewHolder holder, int position) {
        holder.bindCategory(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.titleTextView) TextView mTitleTextView;

        private Context mContext;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCategory (Category category) {
            mTitleTextView.setText(category.getCategoryName());
        }

        @Override
        public void onClick(View view) {
            //intent
                    //pass in the text name of the category
           //childEventListener
        }
    }
}
