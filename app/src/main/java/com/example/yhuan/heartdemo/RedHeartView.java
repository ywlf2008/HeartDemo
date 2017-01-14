package com.example.yhuan.heartdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yhuan on 2017/1/14.
 */

public class RedHeartView extends View {
    public RedHeartView(Context context) {
        this(context, null);
    }

    public RedHeartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RedHeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }
}
