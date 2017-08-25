package com.example.administrator.nonyezhichuang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.fragment.GouWuCheFragment;
import com.example.administrator.nonyezhichuang.fragment.ShangPinFragment;
import com.example.administrator.nonyezhichuang.fragment.WoDeFragment;
import com.example.administrator.nonyezhichuang.fragment.ZhuyeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShouyeActivity extends BaseActivity {


    @BindView(R.id.mRb_shouye)
    RadioButton mRbShouye;
    @BindView(R.id.mRb_shangpin)
    RadioButton mRbShangpin;
    @BindView(R.id.mRb_gouwuche)
    RadioButton mRbGouwuche;
    @BindView(R.id.mRb_wode)
    RadioButton mRbWode;
    @BindView(R.id.mRg_shouye)
    RadioGroup mRgShouye;
    @BindView(R.id.mTxt_xiangqing_Activity)
    TextView mTxtXiangqingActivity;
    @BindView(R.id.xiaoxi)
    Button xiaoxi;
    @BindView(R.id.sousuo)
    Button sousuo;
    @BindView(R.id.toolbars_shouye_activity)
    Toolbar toolbarsShouyeActivity;
    @BindView(R.id.frame_shouye)
    FrameLayout frameShouye;
    @BindView(R.id.activity_shouye)
    RelativeLayout activityShouye;
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initView() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shouye);
        ButterKnife.bind(this);


        /**
         * 初始化需要添加的Fragment
         */
        manager = getSupportFragmentManager();
        initFragment();
        manager.beginTransaction().add(R.id.frame_shouye, list.get(0)).commit();
        lastFragment = list.get(0);
        initRg();
    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {

    }

    private void initFragment() {

        GouWuCheFragment gouWuCheFragment = new GouWuCheFragment();
        ShangPinFragment shangPinFragment = new ShangPinFragment();
        WoDeFragment woDeFragment = new WoDeFragment();
        ZhuyeFragment zhuyeFragment = new ZhuyeFragment();

        list.add(zhuyeFragment);
        list.add(shangPinFragment);
        list.add(gouWuCheFragment);
        list.add(woDeFragment);
    }

    private void initRg() {
        mRgShouye.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton select = (RadioButton) findViewById(i);
                int index = Integer.parseInt(select.getTag().toString());
                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.frame_shouye, list.get(index)).commit();
                }
                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
