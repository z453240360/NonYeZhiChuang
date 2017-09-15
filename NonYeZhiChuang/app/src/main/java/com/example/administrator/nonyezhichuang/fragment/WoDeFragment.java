package com.example.administrator.nonyezhichuang.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.model.IMainView;
import com.example.administrator.nonyezhichuang.model.Present;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/18.
 */

public class WoDeFragment extends Fragment implements IMainView{

    @BindView(R.id.mBtn_xiaoxi)
    Button mBtnXiaoxi;
    @BindView(R.id.mBtn_shezhi)
    Button mBtnShezhi;
    @BindView(R.id.mImg_touxiang)
    ImageView mImgTouxiang;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.button16)
    Button button16;
    @BindView(R.id.mBtn_daifukuan)
    Button mBtnDaifukuan;
    @BindView(R.id.mBtn_daifahuo)
    Button mBtnDaifahuo;
    @BindView(R.id.mBtn_daishoukuan)
    Button mBtnDaishoukuan;
    @BindView(R.id.mBtn_daipingjia)
    Button mBtnDaipingjia;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.mBtn_shangpinshoucang)
    Button mBtnShangpinshoucang;
    @BindView(R.id.mBtn_guanzhu)
    Button mBtnGuanzhu;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;
    @BindView(R.id.mBtn_changjianwenti)
    Button mBtnChangjianwenti;
    @BindView(R.id.mBtn_kefudianhua)
    Button mBtnKefudianhua;
    @BindView(R.id.mBtn_jubao)
    Button mBtnJubao;
    @BindView(R.id.mBtn_null)
    Button mBtnNull;
    Unbinder unbinder;

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wode, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        present=new Present(this);
        sharedPreferences=getActivity().getSharedPreferences("youlai", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtn_xiaoxi, R.id.mBtn_shezhi, R.id.mImg_touxiang, R.id.textView4, R.id.button16, R.id.mBtn_daifukuan, R.id.mBtn_daifahuo, R.id.mBtn_daishoukuan, R.id.mBtn_daipingjia, R.id.textView3, R.id.mBtn_shangpinshoucang, R.id.mBtn_guanzhu, R.id.button11, R.id.button12, R.id.mBtn_changjianwenti, R.id.mBtn_kefudianhua, R.id.mBtn_jubao, R.id.mBtn_null})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //消息
            case R.id.mBtn_xiaoxi:
                break;
            //设置
            case R.id.mBtn_shezhi:
                break;
            //头像
            case R.id.mImg_touxiang:
                break;
            //我的订单
            case R.id.textView4:
                break;
            //查看更多订单
            case R.id.button16:
                break;
            //代付款
            case R.id.mBtn_daifukuan:
                break;
            //待发货
            case R.id.mBtn_daifahuo:
                break;
            //待收款
            case R.id.mBtn_daishoukuan:
                break;
            //待评价
            case R.id.mBtn_daipingjia:
                break;
            //常用工具
            case R.id.textView3:
                break;
            //商品收藏
            case R.id.mBtn_shangpinshoucang:
                break;
            //关注
            case R.id.mBtn_guanzhu:
                break;
            //购买商品
            case R.id.button11:
                break;
            //购买店铺
            case R.id.button12:
                break;
            //常见问题
            case R.id.mBtn_changjianwenti:
                break;
            //客服电话
            case R.id.mBtn_kefudianhua:
                break;
            //举报
            case R.id.mBtn_jubao:
                break;
            //智能采购
            case R.id.mBtn_null:
                break;
        }
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
}
