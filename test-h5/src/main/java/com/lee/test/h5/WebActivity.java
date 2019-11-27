package com.lee.test.h5;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.web_view);

        mWebView.loadUrl("file:///android_asset/test.html");
    }
}
