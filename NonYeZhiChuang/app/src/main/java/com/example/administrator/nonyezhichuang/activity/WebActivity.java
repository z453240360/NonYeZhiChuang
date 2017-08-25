package com.example.administrator.nonyezhichuang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.AndroidCharacter;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.administrator.nonyezhichuang.R;
import com.just.library.AgentWeb;
import com.just.library.AgentWebView;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;
import butterknife.ButterKnife;



public class WebActivity extends AppCompatActivity {

    @BindView(R.id.activity_web)
    LinearLayout ll;
    AgentWeb web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        web = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(ll, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback(new ChromeClientCallbackManager.ReceivedTitleCallback() {
                    @Override
                    public void onReceivedTitle(WebView view, String title) {

                    }
                }) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready()
                .go("http://www.baidu.com");


        web.getJsEntraceAccess().quickCallJs("");


        web.getJsInterfaceHolder().addJavaObject("android",new AndroidInterface(web,this));
    }


    private class AndroidInterface {
        public AndroidInterface(AgentWeb web, WebActivity webActivity) {

        }
    }
}
