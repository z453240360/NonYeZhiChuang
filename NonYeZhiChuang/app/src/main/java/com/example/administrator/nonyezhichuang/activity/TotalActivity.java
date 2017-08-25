package com.example.administrator.nonyezhichuang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.adapter.TestAdapter;
import com.example.administrator.nonyezhichuang.util.PermissionsUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Manifest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TotalActivity extends AppCompatActivity implements PermissionsUtil.IPermissionsCallback {

    @BindView(R.id.btn_quanxuan)
    Button btnQuanxuan;
    @BindView(R.id.btn_quanxuan2)
    Button btnQuanxuan2;
    @BindView(R.id.mRecyclerView_presell)
    XRecyclerView mRecyclerViewPresell;
    @BindView(R.id.btn_quanxuan3)
    Button btnQuanxuan3;
    private List<String> mDates = new ArrayList<>();
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        ButterKnife.bind(this);


        for (int i = 0; i < 50; i++) {
            mDates.add("我的全选事件" + i);
        }


        LinearLayoutManager manager = new LinearLayoutManager(this);

        adapter = new TestAdapter(mDates, this);

        adapter.setRecyclerViewOnItemClickListener(new TestAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                adapter.setSelectItem(position);
            }

            @Override
            public boolean onItemLongClickListener(View view, int position) {
                adapter.setShowBox();
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public void onTextChangeListener(View view, int position) {
                adapter.notifyDataSetChanged();
            }
        });

        mRecyclerViewPresell.setAdapter(adapter);
        mRecyclerViewPresell.setLayoutManager(manager);

    }

    @OnClick({R.id.btn_quanxuan, R.id.btn_quanxuan2,R.id.btn_quanxuan3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_quanxuan:
                Map<Integer, Boolean> map = adapter.getMap();
                for (int i = 0; i < map.size(); i++) {
                    map.put(i, true);
                    adapter.notifyDataSetChanged();
                }


                break;
            case R.id.btn_quanxuan2:
                Map<Integer, Boolean> map1 = adapter.getMap();
                for (int i = 0; i < map1.size(); i++) {
                    map1.put(i, false);
                    adapter.notifyDataSetChanged();
                }

                break;
            case R.id.btn_quanxuan3:

                Map<Integer, Boolean> map2 = adapter.getMap();
                for (int i = 0; i < map2.size(); i++) {
                    if (map2.get(i)){
                        Log.i("dd", "onViewClicked: "+i);
                    }
                }

                break;


        }
    }


    //权限获取回调
    @Override
    public void onPermissionsGranted(int requestCode, String... permission) {

    }

    //权限被拒绝回调
    @Override
    public void onPermissionsDenied(int requestCode, String... permission) {

    }
}
