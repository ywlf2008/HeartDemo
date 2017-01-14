package com.example.yhuan.heartdemo;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by yhuan on 2017/1/14.
 */

public class BeckoningUtil {

    Context mContext;
    Vibrator mVibrator;
    long[] pattern = {800, 50, 400, 30}; // OFF/ON/OFF/ON...

    public BeckoningUtil(Context mContext) {
        this.mContext = mContext;
        mVibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void start(){
        mVibrator.vibrate(pattern, 2);//-1不重复，非-1为从pattern的指定下标开始重复
    }

    public void stop(){
        mVibrator.cancel();
    }

}
