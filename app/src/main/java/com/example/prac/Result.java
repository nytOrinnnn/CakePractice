package com.example.prac;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends SelectionPage{


    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        result = findViewById(R.id.result);

        Intent intent = getIntent();
        String sum = intent.getStringExtra("SUMMARY");
        result.setText(sum);


    }
}

