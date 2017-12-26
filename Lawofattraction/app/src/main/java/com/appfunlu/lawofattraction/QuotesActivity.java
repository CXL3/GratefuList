package com.appfunlu.lawofattraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import static com.appfunlu.lawofattraction.R.id.webView;


public class QuotesActivity extends AppCompatActivity{

    private WebView webview;

    /** URL to query the quotes from my website appfunlu.com. I update the quote daily*/
    private static final String QUOTE_URL =
            "https://appfunlu.com/wp-json/wp/v2/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspirational_quotes);


        webview = (WebView) findViewById(webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setScrollbarFadingEnabled(true);
        webview.loadUrl("https://appfunlu.com/dq/");


    }

}