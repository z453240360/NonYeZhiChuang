package com.example.administrator.nonyezhichuang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.wedget.Button_gouwuche;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/22.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyHoler> implements View.OnClickListener,View.OnLongClickListener{

    private List<String> mDates = new ArrayList<>();
    private Map<Integer,String> maps = new HashMap<>();
    private Context context;
    private int text=0;
    private Map<Integer,Boolean> map = new HashMap<>();

    //是否显示单选框
    private  boolean isshowBox = false;
    //接口实例
    private RecyclerViewOnItemClickListener onItemClickListener;

    public TestAdapter(List<String> mDates, Context context) {
        this.mDates = mDates;
        this.context = context;
        initMap();
        initTextMap();
    }

    //初始化map集合，默认不选中
    private void initMap() {
        for (int i = 0; i < mDates.size(); i++) {
            map.put(i,false);
        }
    }



    //初始化所有TetxtView集合，默认不选中
    private void initTextMap() {
        for (int i = 0; i < mDates.size(); i++) {
            maps.put(i,"0");
        }
    }




    @Override
    public MyHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.test_daihuishanchu, parent, false);
        MyHoler holer = new MyHoler(inflate);
        inflate.setOnClickListener(this);
        inflate.setOnLongClickListener(this);
        return holer;
    }

    @Override
    public void onBindViewHolder(final MyHoler holder, final int position) {
        if (isshowBox){
            holder.checkBox.setVisibility(View.VISIBLE);
        }else {
            holder.checkBox.setVisibility(View.INVISIBLE);
        }
        //设置TAG
        holder.root.setTag(position);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                map.put(position,b);
            }
        });

        if (map.get(position)==null){
            map.put(position,false);
        }
        holder.checkBox.setChecked(map.get(position));

        holder.textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                maps.put(position,charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (maps.get(position)==null){
            maps.put(position,"0");
        }


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text=Integer.valueOf(maps.get(position)) ;
                text++;
                holder.textView.setText(""+text);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListener!=null){
            onItemClickListener.onItemClickListener(view, (Integer) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        initMap();
        return onItemClickListener != null && onItemClickListener.onItemLongClickListener(view, (Integer) view.getTag());
    }

    //设置点击事件
    public void setRecyclerViewOnItemClickListener(RecyclerViewOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    //设置是否显示CheckBox
    public void setShowBox() {
        //取反
        isshowBox = !isshowBox;
    }

    public void getTextViewText(int position){

    }



    //点击item选中CheckBox
    public void setSelectItem(int position) {
        //对当前状态取反
        if (map.get(position)) {
            map.put(position, false);
        } else {
            map.put(position, true);
        }
        notifyItemChanged(position);
    }
    //返回集合给MainActivity
    public Map<Integer, Boolean> getMap() {
        return map;
    }



    class MyHoler extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;
        Button_gouwuche button;
        View root;
        public MyHoler(View itemView) {
            super(itemView);
            this.root=itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            button = (Button_gouwuche) itemView.findViewById(R.id.button);
        }
    }

    //接口回调设置点击事件
    public interface RecyclerViewOnItemClickListener {
        //点击事件
        void onItemClickListener(View view, int position);

        //长按事件
        boolean onItemLongClickListener(View view, int position);

        void onTextChangeListener(View view,int position);
    }
}
