package com.example.xiaoming.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;


public class Music extends Activity {
    private Bundle bundle;
    private WebView webView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("ming","启动新页面1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        WebView wv = (WebView)findViewById(R.id.web_view);
        Log.i("ming","启动新页面");
        initView();
        WebView.setWebContentsDebuggingEnabled(true);
    }


    private void initView() {
        webView = (WebView)findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        //解决一些图片加载问题
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("webview","url: "+url);
                view.loadUrl(url);
                return true;
            }
        });
        String url = "http://lcoc.top/m666/";
        webView.loadUrl(url);
    }

    //监听BACK按键，有可以返回的页面时返回页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
