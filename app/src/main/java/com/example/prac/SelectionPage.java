package com.example.prac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionPage extends MainActivity{

 final int chocolate = 120;
 final int vanilla = 100;
 final int straw = 150;

 Button btnConfirm;

 TextView totalView;

 RadioGroup sizesOption, icingOption;
 CheckBox Fruits, Sprinkles, ChocoChips;
 ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, btnVanilla, btnChoco, btnStraw;

 EditText addMess;

 String summary = "";

 int base = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_page);

    btnConfirm = findViewById(R.id.btnConfirm);
    btnVanilla = findViewById(R.id.btnVanilla);
    btnChoco = findViewById(R.id.btnChoco);
    btnStraw = findViewById(R.id.btnStraw);
    sizesOption = findViewById(R.id.sizesOption);
    icingOption = findViewById(R.id.icingOptions);
    Fruits = findViewById(R.id.Fruits);
    Sprinkles = findViewById(R.id.Sprinkles);
    ChocoChips = findViewById(R.id.ChocoChips);
    totalView = findViewById(R.id.totalView);
    addMess = findViewById(R.id.addMess);
    imageView = findViewById(R.id.imageView);
    imageView2 = findViewById(R.id.imageView2);
    imageView3 = findViewById(R.id.imageView3);
    imageView4 = findViewById(R.id.imageView4);
    imageView5 = findViewById(R.id.imageView5);
    imageView6 = findViewById(R.id.imageView6);
    imageView7 = findViewById(R.id.imageView7);
    imageView8 = findViewById(R.id.imageView8);
    imageView9 = findViewById(R.id.imageView9);








        btnVanilla.setOnClickListener(view -> {
            base = vanilla;
            summary += "Flavor: Vanilla \n";

            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
            imageView3.setVisibility(View.GONE);
            totalUpdater();

    });
    btnChoco.setOnClickListener(view -> {
        base = chocolate;
        summary += "Flavor: Chocolate \n";
        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.VISIBLE);
        totalUpdater();
    });

    btnStraw.setOnClickListener(view -> {
        base = straw;

        summary += "Flavor: Strawberry \n";
        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.GONE);
        totalUpdater();

    });


    sizesOption.setOnCheckedChangeListener((radioGroup, i) -> totalUpdater());
    icingOption.setOnCheckedChangeListener((radioGroup, i) -> totalUpdater());


    Fruits.setOnClickListener(view -> {
        totalUpdater();
    });

    Sprinkles.setOnClickListener(view -> {
        totalUpdater();
    });

    ChocoChips.setOnClickListener(view -> {
        totalUpdater();
    });


    btnConfirm.setOnClickListener(view -> {
        Intent intent = new Intent(SelectionPage.this, Result.class);
        intent.putExtra("SUMMARY", summary);
        startActivity(intent);
    });

    }

    public void totalUpdater(){
        summary = "";
        int total = base;



        int sizes = sizesOption.getCheckedRadioButtonId();

        if(sizes == R.id.sizeS){
            total += 500;
            summary += "Size: Small \n";
        } else if(sizes == R.id.sizeM){
            total += 750;
            summary += "Size: Medium \n";
        } else if (sizes == R.id.sizeL) {
            total += 1000;
            summary += "Size: Large \n";

        }

        int icings = icingOption.getCheckedRadioButtonId();

        if(icings == R.id.butterCream){
            total += 80;
            summary += "Icing: ButterCream \n";
            imageView4.setVisibility(View.VISIBLE);
            imageView6.setVisibility(View.GONE);
            imageView5.setVisibility(View.GONE);


        } else if(icings == R.id.chocoGanache){
            total += 120;
            summary += "Icing: Chocolate Ganache \n";
            imageView6.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.GONE);
            imageView5.setVisibility(View.GONE);

        } else if (icings == R.id.creamC) {
            total += 100;
            summary += "Icing: Cream Cheese \n";
            imageView5.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.GONE);
            imageView6.setVisibility(View.GONE);

        }

        if(Fruits.isChecked()){
            total +=120;
            summary += "ADD-0N: Fruits \n";
            imageView7.setVisibility(View.VISIBLE);
        } else if(!Fruits.isChecked()){
            imageView7.setVisibility(View.GONE);
        }

        if(ChocoChips.isChecked()){
            total +=70;
            summary += "ADD-0N: Chocolate Chips \n";
            imageView8.setVisibility(View.VISIBLE);
        } else if(!ChocoChips.isChecked()){
            imageView8.setVisibility(View.GONE);
        }

        if(Sprinkles.isChecked()){
            total +=50;
            summary += "ADD-0N: Sprinkles \n";
            imageView9.setVisibility(View.VISIBLE);
        } else if(!Sprinkles.isChecked()){
            imageView9.setVisibility(View.GONE);
        }

        String mess = addMess.getText().toString();
        if(!mess.isEmpty()) {
            summary += "Message " + mess + "\n";
        }

        totalView.setText("TOTAL: " + total);

    }

}
