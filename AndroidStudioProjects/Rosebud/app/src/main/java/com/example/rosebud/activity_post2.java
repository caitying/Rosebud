package com.example.rosebud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class activity_post2 extends AppCompatActivity {

    private Button button;
    private EditText rose;
    private EditText bud;
    private EditText thorn;

    private FirebaseFirestore mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);

        mData = FirebaseFirestore.getInstance();
        roseText=(EditText)findViewById(R.id.rose);
        budText=(EditText)findViewById(R.id.bud);
        thornText=(EditText)findViewById(R.id.thorn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rose = roseText.getText().toString();
                String bud = budText.getText().toString();
                String thorn= thornText.getText().toString();

                Map<String, String> answerMap = new HashMap<>();
                answerMap.put("rose",rose);
                answerMap.put("bud", bud);
                answerMap.put("thorn",thorn);

                mData.collection("answers").add(answerMap);








            }
        });
    }


}
