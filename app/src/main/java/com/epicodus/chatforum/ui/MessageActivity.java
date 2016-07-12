package com.epicodus.chatforum.ui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.epicodus.chatforum.Constants;
import com.epicodus.chatforum.R;
import com.epicodus.chatforum.adapters.FirebaseAdapter2;
import com.epicodus.chatforum.models.Message;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference mCreateNewMessageReference;
    private FirebaseAdapter2 mFirebaseAdapter2;

    @Bind(R.id.bCreateNewMessage)
    Button mNewMessage;
    @Bind(R.id.listView)
    ListView mListView;
    @Bind(R.id.userMessageInput)
    EditText mUserMessageInput;

    ArrayList<String> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.activity_list_item, mMessages);
        mListView.setAdapter(adapter);

        mCreateNewMessageReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_NEW_MESSAGE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        mNewMessage.setOnClickListener(this);


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("test");

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mMessages.add(dataSnapshot.getValue(String.class));
                Log.d("Child Added!", dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String deletedString = dataSnapshot.getValue(String.class);
                Log.d("Child Deleted!", deletedString);
                mMessages.remove(deletedString);
                Log.d("Items", TextUtils.join(",", mMessages));
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        String message = mUserMessageInput.getText().toString();
        Message messageObject = new Message(message);
        saveMessageToFirebase(messageObject);
        Intent intent = new Intent(MessageActivity.this, MessageActivity.class);
        startActivity(intent);
    }
    public void saveMessageToFirebase(Message message) {
        mCreateNewMessageReference.push().setValue(message);
    }
}
