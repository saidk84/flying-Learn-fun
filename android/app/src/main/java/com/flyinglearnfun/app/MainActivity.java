package com.flyinglearnfun.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.view.View;
public final class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle state){super.onCreate(state);web=new WebView(this);web.setOverScrollMode(View.OVER_SCROLL_NEVER);WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setAllowFileAccess(true);web.setWebViewClient(new WebViewClient());setContentView(web);web.loadUrl("file:///android_asset/index.html");}
 @Override public void onBackPressed(){if(web!=null)web.evaluateJavascript("window.gameBack?window.gameBack():false",handled->{if(!"true".equals(handled))super.onBackPressed();});else super.onBackPressed();}
 @Override protected void onPause(){if(web!=null)web.evaluateJavascript("window.pauseGame&&window.pauseGame()",null);super.onPause();}
 @Override protected void onDestroy(){if(web!=null)web.destroy();super.onDestroy();}
}