package com.example.administrator.nonyezhichuang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.bean.ShouYe_BannerBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/8/18.
 */

public class ZhuYeAdapter extends RecyclerView.Adapter<ZhuYeAdapter.MyHolder>{
    private List<ShouYe_BannerBean.DataBean.DataRecommendBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;


    public ZhuYeAdapter(List<ShouYe_BannerBean.DataBean.DataRecommendBean> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_zhuye, parent, false);
        MyHolder myViewHolder = new MyHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        ShouYe_BannerBean.DataBean.DataRecommendBean dataRecommendBean = mDatas.get(position);
        //获取图片地址
        String goods_cover = dataRecommendBean.getGoods_cover();
        Picasso.with(mContext)
                .load(goods_cover)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.mImg);

        holder.title.setText(dataRecommendBean.getGoods_name());
        holder.danwei.setText("￥ "+dataRecommendBean.getGoods_price());
        holder.danwei2.setText(dataRecommendBean.getRatio());

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyHolder extends XRecyclerView.ViewHolder{

        ImageView mImg;
        TextView title,danwei,danwei2;
        public MyHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.mImg_zhuye);
            title = (TextView) itemView.findViewById(R.id.mTxt_name);
            danwei = (TextView) itemView.findViewById(R.id.mTxt_danwei);
            danwei2 = (TextView) itemView.findViewById(R.id.mTxt_danwei2);
        }
    }

}
