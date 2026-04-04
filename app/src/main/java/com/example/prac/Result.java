package com.example.prac;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends SelectionPage{


    TextView result;
    ImageView flavor, topping1, topping2, topping3, icing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        result = findViewById(R.id.result);
        flavor = findViewById(R.id.flavor);
        topping1 = findViewById(R.id.topping1);
        topping2 = findViewById(R.id.topping2);
        topping3 = findViewById(R.id.topping3);
        icing = findViewById(R.id.icing);




        Intent intent = getIntent();
        String sum = intent.getStringExtra("SUMMARY");
        int flavorr = intent.getIntExtra("FLAVOR", 0);
        int topping11 = intent.getIntExtra("TOPPING1", 0);
        int topping22 = intent.getIntExtra("TOPPING2", 0);
        int topping33 = intent.getIntExtra("TOPPING3", 0);
        int icingg = intent.getIntExtra("ICING", 0);

        result.setText(sum);
        flavor.setImageResource(flavorr);
        topping1.setImageResource(topping11);
        topping2.setImageResource(topping22);
        topping3.setImageResource(topping33);
        icing.setImageResource(icingg);


    }
}

