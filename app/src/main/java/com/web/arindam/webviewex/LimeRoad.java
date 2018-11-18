package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LimeRoad extends AppCompatActivity {

    WebView webview_limeroad;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lime_road);

        webview_limeroad=findViewById(R.id.webview_limeroad);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        dialog.setCancelable(false);

        WebSettings webSettings=webview_limeroad.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview_limeroad.loadUrl("http://www.limeroad.com");
        webview_limeroad.setWebViewClient(new MyClient4());



    }

    private class MyClient4 extends WebViewClient {
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
