package com.example.gpproject_member1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class CommunityTipsActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText tipInput;
    private Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tips);

        // "tips" is the name of your folder in the database
        mDatabase = FirebaseDatabase.getInstance().getReference("tips");

        tipInput = findViewById(R.id.tipInput);
        postBtn = findViewById(R.id.postBtn);

        postBtn.setOnClickListener(v -> {
            String tipText = tipInput.getText().toString();
            if(!tipText.isEmpty()){
                // Push creates a unique ID for each tip
                mDatabase.push().setValue(tipText);
                Toast.makeText(this, "Tip Shared with Community!", Toast.LENGTH_SHORT).show();
                tipInput.setText("");
            }
        });
    }
}