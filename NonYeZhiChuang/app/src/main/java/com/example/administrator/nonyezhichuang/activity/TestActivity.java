package com.example.administrator.nonyezhichuang.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.util.LocationUtil;
import com.example.administrator.nonyezhichuang.util.PermissionsUtil;
import com.example.administrator.nonyezhichuang.wedget.Button_gouwuche;

import org.greenrobot.eventbus.EventBus;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.may)
    Button_gouwuche may;
    @BindView(R.id.frame_test)
    FrameLayout frameTest;
    @BindView(R.id.button2)
    Button button2;
    private String TAG="dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        EventBus.getDefault().post("nihao");

    }

    @OnClick(R.id.button2)
    public void onViewClicked() {
        may.setTextView(5);
    }


    @Override
    protected void onStart() {
        super.onStart();


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }



}
