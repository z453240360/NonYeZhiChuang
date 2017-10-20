package com.example.administrator.nonyezhichuang.wedget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;

/**
 * Created by Administrator on 2017/8/22.
 */

public class Button_gouwuche extends FrameLayout {

    private Button jia,jian;
    private TextView textView;
    private int num=0;
    public Button_gouwuche(Context context) {
        super(context);
        initView(context);
    }

    public Button_gouwuche(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Button_gouwuche(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    public void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.wedget_gouwuche, null);
        addView(view);
        jian= (Button) view.findViewById(R.id.wedget_jian);
        jia= (Button) view.findViewById(R.id.jia);
        textView = (TextView) view.findViewById(R.id.wedget_showNumber);

        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(jia()+"");
            }
        });

        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(jian()+"");
            }
        });

    }

    private int jia(){
        num++;
        return num;
    }

    private int jian(){
        if (num<=0){
            return 0;
        }
        num--;
        return num;
    }

    public void setTextView(int s){
        textView.setText(s+"");
    }

}
