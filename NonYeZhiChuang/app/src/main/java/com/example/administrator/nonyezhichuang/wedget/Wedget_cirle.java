package com.example.administrator.nonyezhichuang.wedget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/15.
 */

public class Wedget_cirle extends TextView {

    private int radios=100;
    private Paint paint;

    public Wedget_cirle(Context context) {
        super(context);
    }

    public Wedget_cirle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Wedget_cirle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawCircle(0,0,radios, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
