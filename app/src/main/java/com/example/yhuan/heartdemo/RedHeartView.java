package com.example.yhuan.heartdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.yhuan.heartdemo.heart.MyUtil;
import com.example.yhuan.heartdemo.heart.Point;

/**
 * Created by yhuan on 2017/1/14.
 */

public class RedHeartView extends View {

    private float stretchA;//第一个控制点延长线倍数
    private float stretchB;//第二个控制点延长线倍数
    private float startAngle;//起始旋转角，用于确定第一个端点
    private float angle;//两条线之间夹角，由起始旋转角和夹角可以确定第二个端点
    private int radius = 2;//花芯的半径
    private float growFactor;//增长因子，花瓣是有开放的动画效果，这个参数决定花瓣展开速度
    private int color;//花瓣颜色
    private boolean isFinished = false;//花瓣是否绽放完成
    private Path path = new Path();//用于保存三次贝塞尔曲线
    private Paint paint = new Paint();//画笔
    int offsetX;
    int offsetY;

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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width,height);

        offsetX = getWidth() / 2;
        offsetY = getHeight() / 2 - 55;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float angle = 10;
        paint.setColor(0xffff0000);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        Point p = getHeartPoint(angle);
        path.moveTo(p.x,p.y);
        while (angle < 180) {
            p = getHeartPoint(angle);
//            canvas.drawPoint(p.x, p.y, paint);
            path.lineTo(p.x,p.y);
            angle = angle + 0.02f;
        }
        canvas.drawPath(path,paint);

    }

    public Point getHeartPoint(float angle) {
        float t = (float) (angle / Math.PI);
        float x = (float) (19.5 * (16 * Math.pow(Math.sin(t), 3)));
        float y = (float) (-20 * (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)));
        return new Point(offsetX + (int) x, offsetY + (int) y);
    }

}
