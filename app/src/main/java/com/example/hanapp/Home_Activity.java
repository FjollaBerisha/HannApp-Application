package com.example.hanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Activity extends AppCompatActivity {

    ImageView fastfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

       fastfood=findViewById(R.id.fastfood);
        fastfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FastFoodPlaces=new Intent(Home_Activity.this,Fast_Food_Places.class);
                startActivity(FastFoodPlaces);
            }
        });
    }
}