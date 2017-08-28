package com.example.administrator.nonyezhichuang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.bean.ShouYe_BannerBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/21.
 */

public class GouWuCheAdapter extends RecyclerView.Adapter<GouWuCheAdapter.MyHolder> {

    private List<String> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    private int num=10;

    public GouWuCheAdapter(List<String> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_gouwuche, parent, false);
        GouWuCheAdapter.MyHolder myViewHolder = new GouWuCheAdapter.MyHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        holder.mTxt_shuliang.setText(""+num);

        holder.mBtn_jia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                num++;
                holder.mTxt_shuliang.setText("加"+num);
                notifyDataSetChanged();
            }
        });

        holder.mBtn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num--;
                holder.mTxt_shuliang.setText("减"+num);
                notifyDataSetChanged();
            }
        });

//        holder.checkbox.setChecked(true);

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyHolder extends XRecyclerView.ViewHolder {

        CheckBox checkbox;
        ImageView mImg_gouwuche;
        Button mBtn_jia, mBtn_jian;
        TextView mTxt_shuliang;

        public MyHolder(View itemView) {
            super(itemView);
            mImg_gouwuche = (ImageView) itemView.findViewById(R.id.mImg_gouwuche);
            mBtn_jia = (Button) itemView.findViewById(R.id.mBtn_jia);
            mBtn_jian = (Button) itemView.findViewById(R.id.mBtn_jian);
            mTxt_shuliang = (TextView) itemView.findViewById(R.id.mTxt_shuliang);

        }
    }

    private interface OnSetLinster {
        void isChecked(int pos, View view);

        void onClickJia(int pos, View view);

        void onClickJian(int pos, View view);

        void onSelected(int pos, View view);
    }

    private OnSetLinster linster;

    public void setOnClickListener(OnSetLinster listener) {
        this.linster = linster;
    }


    public void jia(int pos, View view) {

        notifyDataSetChanged();
    }


    /**
     * 点击事件的接口回调
     *
     */
    public interface OnItemClickListener {
        void onItemClick(int pos, View view);
        void onBtn_jia(int pos,View view);
    }

    private ZhuYe_DongTaiAdapter.OnItemClickListener mListener;

    public void setOnItemClickListener(ZhuYe_DongTaiAdapter.OnItemClickListener listener) {
        this.mListener = listener;
    }

}
