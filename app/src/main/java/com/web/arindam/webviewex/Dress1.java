package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dress1 extends AppCompatActivity {

    WebView webview_dress1;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress1);

        webview_dress1=findViewById(R.id.webview_dress1);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        dialog.setCancelable(false);

        WebSettings webSettings=webview_dress1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview_dress1.loadUrl("https://www.amazon.in/ADYK-Cotton-Couple-Shirt-Women-M/dp/B07HQ4DJ8Y/ref=lp_1968445031_1_23?s=apparel&ie=UTF8&qid=1542546571&sr=1-23");
        webview_dress1.setWebViewClient(new MyClent());
    }

    private class MyClent extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
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
