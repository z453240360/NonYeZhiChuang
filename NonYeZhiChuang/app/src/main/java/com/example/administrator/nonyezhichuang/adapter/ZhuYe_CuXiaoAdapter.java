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
import com.example.administrator.nonyezhichuang.bean.ZhuYe_CuXiaoBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */

public class ZhuYe_CuXiaoAdapter extends RecyclerView.Adapter<ZhuYe_CuXiaoAdapter.MyHolder>{
    private List<ZhuYe_CuXiaoBean.DataBeanX.DataBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;


    public ZhuYe_CuXiaoAdapter(List<ZhuYe_CuXiaoBean.DataBeanX.DataBean> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_zhuyecuxiao, parent, false);
        MyHolder myViewHolder = new MyHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onItemClick(position,holder.itemView);
                }
            }
        });

        ZhuYe_CuXiaoBean.DataBeanX.DataBean dataRecommendBean = mDatas.get(position);
        //获取图片地址
        String goods_cover = dataRecommendBean.getGoods_cover();
        Picasso.with(mContext)
                .load(goods_cover)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.mImg);

        holder.title.setText(dataRecommendBean.getGoods_name());
        holder.danwei.setText("￥"+dataRecommendBean.getGoods_price());
        holder.danwei2.setText(dataRecommendBean.getRatio());

    }

    @Override
    public int getItemCount() {

        if (mDatas.size()==0){
            return 0;
        }
        if (mDatas.size()>4){
            return 4;
        }else{
            mDatas.size();
        }
        return 0;
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

    /**
     * 点击事件的接口回调
     *
     */

    public interface OnItemClickListener {
        void onItemClick(int pos, View view);
    }

    private ZhuYe_DongTaiAdapter.OnItemClickListener mListener;

    public void setOnItemClickListener(ZhuYe_DongTaiAdapter.OnItemClickListener listener) {
        this.mListener = listener;
    }
}
