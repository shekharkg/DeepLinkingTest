package com.shekharkg.deeplinking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);

    WebView webView = (WebView) findViewById(R.id.webView);
    WebSettings settings = webView.getSettings();
    settings.setJavaScriptEnabled(true);
    webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
    webView.setWebViewClient(new WebViewClient() {
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i("TAG", "Processing webView url click...");
        view.loadUrl(url);
        return true;
      }

      public void onPageFinished(WebView view, String url) {
        Log.i("TAG", "Finished loading URL: " + url);

      }

      @Override
      public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
      }
    });


    webView.loadUrl("http://www.google.com");
  }
}
