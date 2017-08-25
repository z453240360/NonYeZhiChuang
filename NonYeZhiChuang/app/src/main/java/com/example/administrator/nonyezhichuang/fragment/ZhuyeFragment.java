package com.example.administrator.nonyezhichuang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.adapter.ZhuYeAdapter;
import com.example.administrator.nonyezhichuang.adapter.ZhuYe_CuXiaoAdapter;
import com.example.administrator.nonyezhichuang.adapter.ZhuYe_DongTaiAdapter;
import com.example.administrator.nonyezhichuang.bean.ShouYe_BannerBean;
import com.example.administrator.nonyezhichuang.bean.ZhuYe_CuXiaoBean;
import com.example.administrator.nonyezhichuang.bean.ZuiXinDongTaiBean;
import com.example.administrator.nonyezhichuang.model.IMainView;
import com.example.administrator.nonyezhichuang.model.Present;
import com.example.administrator.nonyezhichuang.util.JsonUtils;
import com.example.administrator.nonyezhichuang.util.PicLoader;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.nonyezhichuang.R.id.mRecyclerView_presell;


/**
 * Created by Administrator on 2017/8/18.
 */

public class ZhuyeFragment extends Fragment implements IMainView {

    @BindView(R.id.banner_total)
    Banner bannerTotal;
    @BindView(R.id.mBtn_castomlist)
    Button mBtnCastomlist;
    @BindView(R.id.mBtn_buyRecordlist)
    Button mBtnBuyRecordlist;
    @BindView(R.id.mBtn_coupon)
    Button mBtnCoupon;
    @BindView(R.id.mBtn_buyByPhone)
    Button mBtnBuyByPhone;
    @BindView(R.id.ll_total)
    LinearLayout llTotal;

    @BindView(R.id.presell)
    TextView presell;
    @BindView(R.id.mRecyclerView_presell)
    RecyclerView mRecyclerViewPresell;
    @BindView(R.id.bestsell)
    TextView bestsell;
    @BindView(R.id.mBtn_more_bestsell)
    Button mBtnMoreBestsell;
    @BindView(R.id.mRecyclerView_bestsell)
    XRecyclerView mRecyclerViewBestsell; // 最新动态新闻
    @BindView(R.id.newProdect)
    TextView newProdect;
    @BindView(R.id.mBtn_more_newProdect)
    Button mBtnMoreNewProdect;
    @BindView(R.id.mRecyclerView_newProdect)
    XRecyclerView mRecyclerViewNewProdect;
    @BindView(R.id.specailSale)
    TextView specailSale;
    @BindView(R.id.mRecyclerView_specailSale)
    XRecyclerView mRecyclerViewSpecailSale;
    Unbinder unbinder;
    @BindView(R.id.banner_total2)
    RecyclerView bannerTotal2;

    private boolean isAll = true;
    private int page=1;
    private String classID = "1";
    private Present present;
    private String TAG = "dd";
    private List<String> imgUrl = new ArrayList<>();
    private List<String> secondImgUrl = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<ShouYe_BannerBean.DataBean.DataRecommendBean> dataRecommend;
    private ZhuYeAdapter adapters;
    private GridLayoutManager manager;
    private ZhuYe_CuXiaoAdapter cuXiaoAdapter;
    private List<ZhuYe_CuXiaoBean.DataBeanX.DataBean> cuXiaoList;
    private List<ZhuYe_CuXiaoBean.DataBeanX.DataBean> allCuXiaoList=new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    private List<ZuiXinDongTaiBean.DataBeanX.DataBean> DongTaiList = new ArrayList<>();
    private List<ZuiXinDongTaiBean.DataBeanX.DataBean> DongTaiList2 = new ArrayList<>();
    private ZhuYe_DongTaiAdapter adapter_dongtai;
    private LinearLayoutManager manager_dongtai;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zhuye, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(getActivity());

        present = new Present(this);
        present.getBanner();//首页轮播
        present.getPromo();//促销商品信息
        present.counselMinute(page+"",classID);// 新闻列表

        /**
         *
         * 主页动态显示页面
         */
        adapter_dongtai = new ZhuYe_DongTaiAdapter(DongTaiList2,getActivity());
        manager_dongtai = new LinearLayoutManager(getActivity());
        mRecyclerViewBestsell.setLayoutManager(manager_dongtai);
        mRecyclerViewBestsell.setAdapter(adapter_dongtai);
        mRecyclerViewBestsell.setRefreshProgressStyle(ProgressStyle.BallBeat);
        mRecyclerViewBestsell.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);

        //新闻公告，下拉刷新，上拉加载
        mRecyclerViewBestsell.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                DongTaiList2.clear();
                present.counselMinute(page+"",classID);
                mRecyclerViewBestsell.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                present.counselMinute(page+"",classID);
                mRecyclerViewBestsell.smoothScrollToPosition(DongTaiList2.size()-1);
                mRecyclerViewBestsell.loadMoreComplete();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtn_castomlist, R.id.mBtn_buyRecordlist, R.id.mBtn_coupon, R.id.mBtn_buyByPhone, R.id.mBtn_more_bestsell, R.id.mBtn_more_newProdect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //常用清单
            case R.id.mBtn_castomlist:
                break;
            //购买记录
            case R.id.mBtn_buyRecordlist:
                break;
            //优惠券
            case R.id.mBtn_coupon:
                break;
            //电话订购
            case R.id.mBtn_buyByPhone:
                break;
            //更多--畅销品
            case R.id.mBtn_more_bestsell:
                break;
            //新品推荐--更多
            case R.id.mBtn_more_newProdect:
                break;
        }
    }

    @Override
    public void getCode(String s) {
        Log.i(TAG, "getCode: 首页轮播" + s);

        ShouYe_BannerBean bean = (ShouYe_BannerBean) JsonUtils.getBean(s, ShouYe_BannerBean.class);
        ShouYe_BannerBean.DataBean data = bean.getData();

        dataRecommend = data.getDataRecommend();
        adapters = new ZhuYeAdapter(dataRecommend, getActivity());
        manager = new GridLayoutManager(getActivity(), 2, GridLayout.HORIZONTAL, false);
        bannerTotal2.setLayoutManager(manager);
        bannerTotal2.setAdapter(adapters);

        //首页轮播图片，只有一张
        List<ShouYe_BannerBean.DataBean.BannerBean> firstBanner = data.getBanner();
        for (int i = 0; i < firstBanner.size(); i++) {
            ShouYe_BannerBean.DataBean.BannerBean bannerBean = firstBanner.get(i);
            String banner_cover = bannerBean.getBanner_cover();
            imgUrl.add(banner_cover);
        }

        bannerTotal.setImageLoader(new PicLoader());
        bannerTotal.setImages(imgUrl);
        //设置指示标的样式:
        bannerTotal.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置Banner动画效果
        bannerTotal.setBannerAnimation(Transformer.FlipHorizontal);
        //设置轮播时常
        bannerTotal.setDelayTime(2000);
        bannerTotal.start();

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
        Log.i(TAG, "getLogin: "+s);
        Gson g = new Gson();
        ZuiXinDongTaiBean zuiXinDongTaiBean = g.fromJson(s, ZuiXinDongTaiBean.class);
        ZuiXinDongTaiBean.DataBeanX data = zuiXinDongTaiBean.getData();
        DongTaiList= data.getData();
        if (DongTaiList.size()==0){
            if (isAll){
                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                isAll = false;
            }

            return;
        }

        DongTaiList2.addAll(DongTaiList);
        adapter_dongtai.notifyDataSetChanged();
    }

    @Override
    public void getUpDate(String s) {
        Log.i(TAG, "getUpDate: " + s);
        Gson gson = new Gson();
        ZhuYe_CuXiaoBean zhuYe_cuXiaoBean = gson.fromJson(s, ZhuYe_CuXiaoBean.class);
        ZhuYe_CuXiaoBean.DataBeanX data = zhuYe_cuXiaoBean.getData();
        int current_page = data.getCurrent_page();
        int total = data.getTotal();

        cuXiaoList = data.getData();
        cuXiaoAdapter = new ZhuYe_CuXiaoAdapter(cuXiaoList, getActivity());
        mRecyclerViewPresell.setAdapter(cuXiaoAdapter);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayout.VERTICAL, false);
        mRecyclerViewPresell.setLayoutManager(gridLayoutManager);

    }

    @OnClick(R.id.banner_total2)
    public void onViewClicked() {

    }
}
