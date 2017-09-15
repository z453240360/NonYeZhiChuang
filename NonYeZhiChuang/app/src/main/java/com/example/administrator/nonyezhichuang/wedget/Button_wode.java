package com.example.administrator.nonyezhichuang.wedget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;

import org.w3c.dom.Text;

import static com.example.administrator.nonyezhichuang.R.id.txt;

/**
 * Created by Administrator on 2017/9/15.
 */

public class Button_wode extends FrameLayout {

    private Button wedget_btn;
    private ImageView mImg;
    private TextView txt1,txt2;

    public Button_wode(Context context) {
        this(context,null);
    }

    public Button_wode(Context context, AttributeSet attrs) {
        this(context,attrs,0);

    }

    public Button_wode(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.wode, null);
        addView(view);

        wedget_btn= (Button) view.findViewById(R.id.wedget_btn);
        mImg= (ImageView) view.findViewById(R.id.wedget_img1);
        txt1= (TextView) view.findViewById(R.id.wedget_text1);
        txt2= (TextView) view.findViewById(R.id.wedget_text2);

        txt1.setText("");
        txt2.setText("");
        mImg.setImageResource(R.mipmap.ic_launcher);
    }

    public void setWedget_btn(Button wedget_btn) {
        this.wedget_btn = wedget_btn;
    }

    public void setmImg(ImageView mImg) {
        this.mImg = mImg;
    }

    public void setTxt1(TextView txt1) {
        this.txt1 = txt1;
    }

    public void setTxt2(TextView txt2) {
        this.txt2 = txt2;
    }

    public TextView getTxt2() {
        return txt2;
    }

    public TextView getTxt1() {
        return txt1;
    }

    public ImageView getmImg() {
        return mImg;
    }

    public Button getWedget_btn() {
        return wedget_btn;
    }


}
