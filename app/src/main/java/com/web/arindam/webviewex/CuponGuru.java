package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CuponGuru extends AppCompatActivity {

    WebView webview_coupon;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupon_guru);

        webview_coupon=findViewById(R.id.webview_coupon);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        dialog.setCancelable(false);

        WebSettings webSettings=webview_coupon.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview_coupon.loadUrl("http://www.couponzguru.com");
        webview_coupon.setWebViewClient(new MyClient8());



    }

    private class MyClient8 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
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
