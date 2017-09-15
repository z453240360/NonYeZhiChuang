package com.example.administrator.nonyezhichuang;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.nonyezhichuang.activity.LoginActivity;
import com.example.administrator.nonyezhichuang.activity.ShouyeActivity;
import com.example.administrator.nonyezhichuang.activity.TestActivity;
import com.example.administrator.nonyezhichuang.activity.TotalActivity;
import com.example.administrator.nonyezhichuang.activity.WebActivity;
import com.example.administrator.nonyezhichuang.bean.RegistBean;
import com.example.administrator.nonyezhichuang.model.ICallBack;
import com.example.administrator.nonyezhichuang.model.IMainView;
import com.example.administrator.nonyezhichuang.model.Present;
import com.example.administrator.nonyezhichuang.util.ConvertUnicode;
import com.example.administrator.nonyezhichuang.wedget.MyScrollView;
import com.example.administrator.nonyezhichuang.wedget.ScrollViewListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView ,ScrollViewListener{


    private Present present;
    private String TAG = "dd";
    private TextView txt;
    private MyScrollView activity_main;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.BLACK);
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main);


            present = new Present(this);
//        present.getLogin("18912367774", "0000000"); //登陆接口

            txt = (TextView) findViewById(R.id.txt);

            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);

            activity_main = (MyScrollView) findViewById(R.id.sc);
            activity_main.setScrollViewListener(new ScrollViewListener() {
                @Override
                public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
                    if (oldy > 250) {
                        toolbar.setBackgroundColor(Color.RED);
                    } else {
                        toolbar.setBackgroundColor(Color.BLUE);
                        getSupportActionBar().show();
                    }
                }
            });


        }
    }


    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_main1:
                startActivity(new Intent(this,ShouyeActivity.class));
//                present.getLogin("18912367774", "0000000");
                break;
            case R.id.activity_main2:
                present.getRegist("18912367774");
                break;
            case R.id.activity_main3:
                present.getBanner();
                break;
            case R.id.activity_main4:
                present.getCar();
                break;
            case R.id.activity_main5:

                break;
            case R.id.activity_main6:

                break;
            case R.id.activity_main7:

                break;

        }
    }

    @Override
    public void getCode(String s) {
        Log.i(TAG, "getCode: " + s);
//        Gson gson = new Gson();
//        RegistBean registBean = gson.fromJson(s, RegistBean.class);
//
//        String msg1 = registBean.getMsg();
////        String s1 = ConvertUnicode.convertUnicode(msg1);
//        txt.setText(msg1);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {
        Log.i(TAG, "showFaliure: " + s);

        Gson gson = new Gson();
        RegistBean registBean = gson.fromJson(s, RegistBean.class);

        String msg1 = registBean.getMsg();
        String s1 = ConvertUnicode.convertUnicode(msg1);
        txt.setText(s1);

    }

    @Override
    public void getLogin(String s) {
        Log.i(TAG, "showFaliure: " + s);
    }

    @Override
    public void getUpDate(String s) {

    }

    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {

        if (activity_main==scrollView) {
            Log.i(TAG, "onScrollChanged: " + x + "----" + y + "----" + oldx + "----" + oldy);

        }
    }
}
