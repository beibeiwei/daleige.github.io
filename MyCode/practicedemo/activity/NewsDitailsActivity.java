package net.cyq.italker.practicedemo.activity;

import android.content.Intent;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.cyq.italker.practicedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDitailsActivity extends AppCompatActivity {
    String url;

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.web_container)
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_ditails);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        initWebView();
    }

    private void initWebView() {
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);// 支持JS
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        container.removeView(webView);
        webView.destroy();
    }
}
