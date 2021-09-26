package com.example.hanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;

public class Fast_Food_Places extends AppCompatActivity {
     ImageView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food_places);

        map=findViewById(R.id.location);

       map.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              goToUrl("https://vymaps.com/XK/Burger-King-Kosova-102174294751246/");
           }
       });

    }
    private void goToUrl(String s)
    {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }



}


