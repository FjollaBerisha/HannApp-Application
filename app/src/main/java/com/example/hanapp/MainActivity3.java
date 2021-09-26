package com.example.hanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity3 extends AppCompatActivity {
     WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        web.findViewById(R.id.webi);
         WebSettings webSettings=web.getSettings();
         webSettings.setJavaScriptEnabled(true);
         web.setWebViewClient(new Callback());
         web.loadUrl("https://vymaps.com/XK/Burger-King-Kosova-102174294751246/");

    }


    private class Callback extends WebViewClient
    {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return  false;
        }
    }
}