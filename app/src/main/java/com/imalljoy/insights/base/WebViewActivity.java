package com.imalljoy.insights.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.github.barteksc.pdfviewer.PDFView;
import com.imalljoy.insights.R;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijilong on 04/09.
 */

public class WebViewActivity extends BaseActivity implements View.OnClickListener {

    private String TAG = this.getClass().getSimpleName();

    private String mTitle;
    private String mUrl;
    private WebView mWebView;
    private PDFView mPdfView;
    private TopBarCommon mTopBar;
    private boolean isPdf = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (isFinishing()) {
            return;
        }
        setContentView(R.layout.act_webview);

        this.mTopBar = (TopBarCommon) findViewById(R.id.top_bar);
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mPdfView = (PDFView) findViewById(R.id.pdfview);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mTitle = getIntent().getStringExtra("title");
        mUrl = getIntent().getStringExtra("url");
        if (mUrl != null && (mUrl.endsWith(".pdf") || mUrl.endsWith(".PDF"))) {
            isPdf = true;
        }
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.setTitle(mTitle);
        mTopBar.setRightView(null, 0);
        if (isPdf) {
            loadPDF();
        } else {
            loadWebView();
        }
    }

    private void loadWebView() {
        mWebView.setVisibility(View.VISIBLE);
        mPdfView.setVisibility(View.GONE);
        //启用支持Javascript
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
    /*    settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        mWebView.requestFocus();
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String data = "<iframe src='http://docs.google.com/gview?embedded=true&url="+mUrl+"'"+" width='100%' height='100%' style='border: none;'></iframe>";
        mWebView.loadData(data, "text/html", "UTF-8");*/
        //页面加载
        mWebView.setWebChromeClient(new WebChromeClient() {
        });
        mWebView.loadUrl(mUrl);
        //WebView加载页面优先使用缓存加载
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    private void loadPDF() {
        mWebView.setVisibility(View.GONE);
        mPdfView.setVisibility(View.VISIBLE);

    }

    //改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();   //返回上一页面
                return true;
            } else {
                finish();   //退出程序
            }

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }

    public static void toActivity(Context context, String title, String url) {
        if(TextUtils.isEmpty(url)){
            Toast.makeText(context, "url为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent it = new Intent(context, WebViewActivity.class);
        it.putExtra("title", title);
        it.putExtra("url", url);
        context.startActivity(it);
    }
}