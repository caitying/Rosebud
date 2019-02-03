package com.example.rosebud;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class UserInformation extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private Button saveInformation;
    private FirebaseFirestore mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        name = (EditText) findViewById(R.id.editTextName);
        username = (EditText) findViewById(R.id.editTextusername);
        saveInformation = (Button) findViewById(R.id.buttonsaveInformation);
        mData = FirebaseFirestore.getInstance();

        saveInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = username.getText().toString();
                String n = name.getText().toString();

                Map<String, String> userMap = new HashMap<>();
                userMap.put("name", n);
                userMap.put("username", un);

                mData.collection("Users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(UserInformation.this, "Info added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(UserInformation.this, "Error: "+error, Toast.LENGTH_SHORT).show();
                    }
                });
                
            }
        });
    }
}
