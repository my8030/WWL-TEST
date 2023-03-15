package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


public class WebViewApp  extends AppCompatActivity {
    private WebView mWebView;
    private Button BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://webqr.com/");

        BackButton = findViewById(R.id.backButton);
        BackButton.setOnClickListener(view -> {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
            } else {
                Toast.makeText(this, "Вы достигли конца!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            Toast.makeText(this, "Нажмите кнопку \"Назад\" еще раз, чтобы выйти", Toast.LENGTH_LONG).show();
        }
    }
}
