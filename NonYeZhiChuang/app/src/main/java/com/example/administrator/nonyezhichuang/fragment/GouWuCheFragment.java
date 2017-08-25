package com.example.administrator.nonyezhichuang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.activity.LoginActivity;
import com.example.administrator.nonyezhichuang.adapter.GouWuCheAdapter;
import com.example.administrator.nonyezhichuang.bean.RemindLogin;
import com.example.administrator.nonyezhichuang.model.IMainView;
import com.example.administrator.nonyezhichuang.model.Present;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.administrator.nonyezhichuang.R.layout.adapter;

/**
 * Created by Administrator on 2017/8/18.
 * 购物车列表
 */

public class GouWuCheFragment extends Fragment implements IMainView {

    @BindView(R.id.gouWuChe)
    XRecyclerView gouWuChe;
    Unbinder unbinder;
    private Present present;
    private String TAG = "dd";
    private List<String> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_gouwuche, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        present = new Present(this);
        present.getCar();


        mDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDatas.add("lll"+i);
        }

        GouWuCheAdapter adapter = new GouWuCheAdapter(mDatas,getActivity());

        gouWuChe.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        gouWuChe.setLayoutManager(manager);

    }

    @Override
    public void getCode(String s) {
        Log.i(TAG, "getCode: " + s);
        Gson gson = new Gson();
        RemindLogin remindLogin = gson.fromJson(s, RemindLogin.class);
        int code = remindLogin.getCode();
        if (code == 300) {
//            startActivity(new Intent(getActivity(), LoginActivity.class));
        } else {

        }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
