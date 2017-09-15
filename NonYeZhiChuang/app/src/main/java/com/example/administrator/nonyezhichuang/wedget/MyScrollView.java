package com.example.administrator.nonyezhichuang.wedget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import static android.R.attr.x;
import static android.R.attr.y;

/**
 * Created by Administrator on 2017/8/18.
 * 滚动监听
 */

public class MyScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener = null;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldx, int oldy) {
        super.onScrollChanged(l, t, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
}
