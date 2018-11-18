package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dressoff extends AppCompatActivity {

    WebView wv_dressoff;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dressoff);

        wv_dressoff=findViewById(R.id.wv_dressoff);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();
        dialog.setCancelable(false);

        WebSettings webSettings=wv_dressoff.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv_dressoff.loadUrl("https://www.amazon.in/s/ref=s9_acss_bw_cg_dremin40_1a1_w?rh=i%3Aapparel%2Cn%3A1571271031%2Cn%3A%211571272031%2Cn%3A1953602031%2Cn%3A11400137031%2Cn%3A1968445031%2Cp_98%3A10440597031&bbn=1968445031&field-pct-off-with-tax=40-&ie=UTF8&lo=apparel&pf_rd_m=A1K21FY43GMZF8&pf_rd_s=merchandised-search-6&pf_rd_r=0FNM9HSWHKB7RM7AFPAB&pf_rd_t=101&pf_rd_p=0851b7f2-25a9-4a6b-bfaa-472340660ea2&pf_rd_i=1968445031");
        wv_dressoff.setWebViewClient(new MyClints());

    }


    private class MyClints extends WebViewClient {
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
