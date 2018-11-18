package com.web.arindam.webviewex;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////ppppp
        dialog1=new ProgressDialog(this);
        dialog1.show();
        dialog1.setContentView(R.layout.custom_progressdialog);
        ProgressBar progressbar=dialog1.findViewById(R.id.progressbar);
        progressbar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FF2DDC0A"), android.graphics.PorterDuff.Mode.SRC_IN);
        dialog1.setCancelable(false);

        webView=findViewById(R.id.webView);
       // dialog= new ProgressDialog(this);
//       dialog.setMessage("Loading..");
        //dialog.show();
       // dialog.setCancelable(false);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new MyviewClient());
    }

    public class MyviewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            if(dialog1!=null && dialog1.isShowing()){

                dialog1.dismiss();
            }
        }
    }
}
