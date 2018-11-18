package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AmazonSite extends AppCompatActivity {

    WebView webview_amazon;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon_site);

        webview_amazon = findViewById(R.id.webview_amazon);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();
        dialog.setCancelable(false);

        Bundle b=getIntent().getExtras();
        if(b!=null){
            String a=b.getString("a");

        }
        WebSettings webSettings=webview_amazon.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview_amazon.loadUrl("http://www.amazon.in");
        webview_amazon.setWebViewClient(new MyClient1());
    }

    private class MyClient1 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,  String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if(dialog!=null && dialog.isShowing()){

                dialog.dismiss();
            }
        }
    }
}
