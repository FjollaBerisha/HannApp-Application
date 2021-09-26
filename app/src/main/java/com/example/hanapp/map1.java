package com.example.hanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class map1 extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);
        web.findViewById(R.id.map1);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://vymaps.com/XK/Burger-King-Kosova-102174294751246/");
    }
}