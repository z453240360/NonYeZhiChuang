package com.example.administrator.nonyezhichuang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.adapter.FenLeiAdapter;
import com.example.administrator.nonyezhichuang.adapter.ZhuYe_DongTaiAdapter;
import com.example.administrator.nonyezhichuang.bean.ProductKingBean;
import com.example.administrator.nonyezhichuang.model.IMainView;
import com.example.administrator.nonyezhichuang.model.Present;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/18.
 */

public class ShangPinFragment extends Fragment implements IMainView {

    @BindView(R.id.tablayout)
    RecyclerView tablayout;
    Unbinder unbinder;
    @BindView(R.id.frame)
    XRecyclerView frame;
    @BindView(R.id.mBtn_shucaishuiguo)
    Button mBtnShucaishuiguo;
    @BindView(R.id.mBtn_rouqindanlei)
    Button mBtnRouqindanlei;
    @BindView(R.id.mBtn_liangyoufushi)
    Button mBtnLiangyoufushi;
    @BindView(R.id.mBtn_shuichanhaixian)
    Button mBtnShuichanhaixian;
    @BindView(R.id.mBtn_jiushuiyinliao)
    Button mBtnJiushuiyinliao;
    @BindView(R.id.mBtn_tiaoweipin)
    Button mBtnTiaoweipin;
    @BindView(R.id.mBtn_lengdonglengcang)
    Button mBtnLengdonglengcang;
    @BindView(R.id.mBtn_tingchuyongpin)
    Button mBtnTingchuyongpin;
    @BindView(R.id.mBtn_jingkoushangpin)
    Button mBtnJingkoushangpin;

    private Fragment lastFragment;
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<ListFragment> fragments = new ArrayList<>();
    private FragmentManager manager;
    private Present present;
    private String TAG = "dd";

    private Map<String, Integer> map = new HashMap<>();
    private List<Map<String, Integer>> listMap = new ArrayList<>();
    private String classOneId="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shangpin, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        present = new Present(this);
        present.product_kind(""); // 获取商品分类，传入的值为空，显示全部二级分类

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
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

    //没有传值的所有二级商品分类
    @Override
    public void getUpDate(String s) {
        Log.i(TAG, "getUpDate: " + s);
        Gson gson = new Gson();
        ProductKingBean productKingBean = gson.fromJson(s, ProductKingBean.class);
        int code = productKingBean.getCode();
        if (code != 200) {
            return;
        }
        List<ProductKingBean.DataBean> data = productKingBean.getData();
        for (int i = 0; i < data.size(); i++) {
            ProductKingBean.DataBean dataBean = data.get(i);
            String gc_name = dataBean.getGc_name();
            int gc_id = dataBean.getGc_id();
            map.put(gc_name, gc_id);
            listMap.add(map);
            list.add(gc_name);
        }

        FenLeiAdapter fenLeiAdapter = new FenLeiAdapter(list, getActivity());
        tablayout.setAdapter(fenLeiAdapter);
        tablayout.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        fenLeiAdapter.setOnItemClickListener(new ZhuYe_DongTaiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                Integer integer = map.get(list.get(pos));
            }
        });

//        present.product_list(classOneId,map.get(list.get(0)),"1","1","1","1","7");


    }

    @OnClick({R.id.mBtn_shucaishuiguo, R.id.mBtn_rouqindanlei, R.id.mBtn_liangyoufushi, R.id.mBtn_shuichanhaixian, R.id.mBtn_jiushuiyinliao, R.id.mBtn_tiaoweipin, R.id.mBtn_lengdonglengcang, R.id.mBtn_tingchuyongpin, R.id.mBtn_jingkoushangpin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_shucaishuiguo:
                list.clear();
                classOneId = "1";
                present.product_kind("1");
                break;
            case R.id.mBtn_rouqindanlei:
                list.clear();
                classOneId ="2";
                present.product_kind("2");
                break;
            case R.id.mBtn_liangyoufushi:
                list.clear();
                classOneId = "3";
                present.product_kind("3");
                break;
            case R.id.mBtn_shuichanhaixian:
                list.clear();
                classOneId = "4";
                present.product_kind("4");
                break;
            case R.id.mBtn_jiushuiyinliao:
                list.clear();
                classOneId = "5";
                present.product_kind("5");
                break;
            case R.id.mBtn_tiaoweipin:
                list.clear();
                classOneId = "6";
                present.product_kind("6");
                break;
            case R.id.mBtn_lengdonglengcang:
                list.clear();
                classOneId = "7";
                present.product_kind("7");
                break;
            case R.id.mBtn_tingchuyongpin:
                list.clear();
                classOneId = "8";
                present.product_kind("8");
                break;
            case R.id.mBtn_jingkoushangpin:
                list.clear();
                classOneId = "9";
                present.product_kind("9");
                break;
        }
    }
}
