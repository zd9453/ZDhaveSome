package com.example.zhangdong.zdhavesome.webview.webClient;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * use to do something want to do.
 * Created by zhangdong on 2017/6/7.
 *
 * @version 1.0
 */

public class MyWebClient extends WebViewClient {

    private static final String TAG = "MY_INFO";

    public MyWebClient() {
        super();
    }

    /**
     * 网页开始加载的时候
     *
     * @param view    web
     * @param url     网址
     * @param favicon 。
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Log.d(TAG, "onPageStarted: ========================================" + System.currentTimeMillis());
        super.onPageStarted(view, url, favicon);
    }

    /**
     * 网页加载完成的时候
     *
     * @param view web
     * @param url  网址
     */
    @Override
    public void onPageFinished(WebView view, String url) {
//        Log.d(TAG, "onPageFinished: =============" + view + "===============" + url);
//        boolean b = view.canGoBack();//是否有返回页面
//        Bitmap favicon = view.getFavicon();
//        Log.d(TAG, "onPageFinished: ======="+b+"=========="+favicon);
        Log.d(TAG, "onPageFinished: =========================================" + System.currentTimeMillis());

        view.loadUrl("javascript:window.addBody.show('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");

        super.onPageFinished(view, url);
    }

    /**
     * 正在加载时，可拿到加载进度
     *
     * @param view v
     * @param url  u
     */
    @Override
    public void onLoadResource(WebView view, String url) {
        int progress = view.getProgress();//获取到加载的进度
//        if (progress != 100) {
//            Log.d(TAG, "onLoadResource: ======================" + progress);
//        }
        super.onLoadResource(view, url);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
//        Log.d(TAG, "onPageCommitVisible: ============="+url);
        super.onPageCommitVisible(view, url);
    }

    /**
     * 可拦截网络信息
     *
     * @param view    v
     * @param request 网络信息
     * @return .
     */
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
//        Log.d(TAG, "shouldInterceptRequest: ================="+request.toString());
        Uri url = request.getUrl();//网址
        String method = request.getMethod();//网络请求方式
//        Log.d(TAG, "shouldInterceptRequest: ===========url  :"+url.toString());
        return super.shouldInterceptRequest(view, request);
    }

    /**
     * 放大缩小
     *
     * @param view     .
     * @param oldScale .
     * @param newScale .
     */
    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
    }

}
