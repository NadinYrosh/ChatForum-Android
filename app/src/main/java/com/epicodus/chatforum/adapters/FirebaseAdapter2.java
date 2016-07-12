package com.epicodus.chatforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.chatforum.R;
import com.epicodus.chatforum.models.Message;
import com.epicodus.chatforum.ui.MessageActivity;


public class FirebaseAdapter2 extends MessageActivity {
    View mView;
    Context mContext;

    public FirebaseAdapter2(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindMessage(Message message) {
        ListView messagesTextView = (ListView) mView.findViewById(R.id.listView);

//        categoriesTextView.setText(categoryName.getCategoryName());
    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(mContext, MessageActivity.class);
//        //intent.putExtra("mContext", mContext);
//        mContext.startActivity(intent);

    }
}
