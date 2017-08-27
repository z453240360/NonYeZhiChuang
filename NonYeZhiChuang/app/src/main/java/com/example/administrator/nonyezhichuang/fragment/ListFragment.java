package com.example.administrator.nonyezhichuang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.bean.ShangPinListBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/8/22.
 */

public class ListFragment extends Fragment {

    @BindView(R.id.list_fragment)
    ListView listFragment;
    Unbinder unbinder;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> myadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myadapter  = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
        listFragment.setAdapter(myadapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Subscribe
    public void onEvent(ShangPinListBean bean){
        String dianshi = bean.getDianshi();

    }

    private String data;
    public void setData (String data) {
        this.data=data;

//        list.clear();
        for (int i = 0; i < 50; i++) {
            list.add(""+i+data);
        }
        Log.i("dd", "setData: "+data);


        if (myadapter!=null){
            myadapter.notifyDataSetChanged();
        }

    }
    public String  getdata()
    {
        return data;
    }


}
