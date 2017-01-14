package com.example.yhuan.heartdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yhuan.heartdemo.ColorTrack.ColorTrackView;
import com.example.yhuan.heartdemo.heart.HeartView;

public class MainActivity extends AppCompatActivity {

    ColorTrackView colorTrackView ;
    HeartView heartView;
    BeckoningUtil beckoningUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorTrackView = (ColorTrackView)findViewById(R.id.color_view);
        heartView = (HeartView)findViewById(R.id.heart_view);
        beckoningUtil = new BeckoningUtil(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        colorTrackView.setDirection(0);
        ObjectAnimator animator =  ObjectAnimator.ofFloat(colorTrackView, "progress", 0, 1).setDuration(3900);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                beckoningUtil.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        beckoningUtil.stop();
        heartView.stopDraw();
    }

}
