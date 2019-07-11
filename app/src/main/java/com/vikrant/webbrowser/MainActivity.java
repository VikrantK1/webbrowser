package com.vikrant.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.webView);
    }
    public void Button1(View v){
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());

        web.loadUrl("https://www.google.com/");
    }
    public void Button2(View v){
//     String data="<html><body> <h1>Hello World</h1></body></html";
//     web.loadData(data,"text/html","UTF-8");
        Intent intent=new Intent(MainActivity.this,Activity2.class);
        startActivity(intent);
    }
}
