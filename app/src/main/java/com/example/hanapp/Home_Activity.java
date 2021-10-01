package com.example.hanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Activity extends AppCompatActivity {

    ImageView fastfood;
    ImageView Sushi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

       fastfood=findViewById(R.id.fastfood);
       Sushi=findViewById(R.id.sushi);

        fastfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FastFoodPlaces=new Intent(Home_Activity.this,Fast_Food_Places.class);
                startActivity(FastFoodPlaces);
            }
        });

        Sushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SushiPlaces=new Intent(Home_Activity.this, com.example.hanapp.SushiPlaces.class);
                startActivity(SushiPlaces);
            }
        });
    }
}