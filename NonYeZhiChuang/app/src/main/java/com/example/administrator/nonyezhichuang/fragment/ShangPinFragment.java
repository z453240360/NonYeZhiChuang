package com.example.administrator.nonyezhichuang.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.bean.ShangPinListBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.badgeview.Badge;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

import static android.R.attr.fragment;
import static android.R.attr.icon;

/**
 * Created by Administrator on 2017/8/18.
 */

public class ShangPinFragment extends Fragment {

    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    Unbinder unbinder;
    @BindView(R.id.frame)
    FrameLayout frame;
    private Fragment lastFragment;
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<ListFragment> fragments = new ArrayList<>();
    private FragmentManager manager;



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




        list.add("电音");
        list.add("电视");
        list.add("影视");
        list.add("娱乐");
        list.add("视频");
        list.add("狗蛋");




        for (int i = 0; i < list.size(); i++) {
            ListFragment myFragment = new ListFragment();



            myFragment.setData(list.get(i));
            fragments.add(myFragment);
//            EventBus.getDefault().post(i);

            fragments.add(myFragment);
        }
        manager = getChildFragmentManager();
        manager.beginTransaction().add(R.id.frame, fragments.get(0)).commit();
        lastFragment = fragments.get(0);

        //添加标签
        tablayout.addTab(new QTabView(getActivity()));
        //添加监听事件
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                manager = getChildFragmentManager();
                ListFragment listFragment= fragments.get(position);
                manager.beginTransaction().hide(lastFragment).commit();
                manager = getChildFragmentManager();
                listFragment.setData(list.get(position));

                if (listFragment.isAdded()) {

                    manager.beginTransaction().show(listFragment).commit();
                } else {

                    manager.beginTransaction().add(R.id.frame, listFragment).commit();
                }

                lastFragment = listFragment;
                Log.i("dd",listFragment.getdata()+"||"+position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        //设置标签适配器
        tablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {

                /**setBadgeNumber(20)  表示提示信息的数量
                 * setBackgroundColor  数量提示器的背景色
                 *
                 *
                 */
                return new TabView.TabBadge.Builder().setBadgeNumber(20).setBackgroundColor(Color.rgb(80, 80, 80))
                        .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                            @Override
                            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                            }
                        }).build();
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new TabView.TabTitle.Builder()
                        .setContent(list.get(position))
                        //标签字体的颜色 （选中色，非选中色）
                        .setTextColor(0xFF1212EA, 0xFFE416E2)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return -1;
            }
        });

//        tablayout.setupWithFragment(manager, R.id.frame, fragments, new TabAdapter() {
//            @Override
//            public int getCount() {
//                return fragments.size();
//            }
//
//            @Override
//            public ITabView.TabBadge getBadge(int position) {
//                return null;
//            }
//
//            @Override
//            public ITabView.TabIcon getIcon(int position) {
//                return null;
//            }
//
//            @Override
//            public ITabView.TabTitle getTitle(int position) {
//                return new QTabView.TabTitle.Builder().setContent(String.valueOf(position)).build();
//            }
//
//            @Override
//            public int getBackground(int position) {
//                return 0;
//            }
//        });



    }


//    protected int dp2px(float dp) {
//        final float scale = this.getResources().getDisplayMetrics().density;
//        return (int) (dp * scale + 0.5f);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
