package com.example.yhuan.heartdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.yhuan.heartdemo.ColorTrack.ColorTrackView;
import com.example.yhuan.heartdemo.heart.HeartView;

import static com.example.yhuan.heartdemo.R.id.red_heart;

public class MainActivity extends AppCompatActivity {

    ColorTrackView colorTrackView ;
    HeartView heartView;
    BeckoningUtil beckoningUtil;
    RedHeartView redHeart;
    ObjectAnimator animator;
    private boolean isVisible = false;
    private Animation heartAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorTrackView = (ColorTrackView)findViewById(R.id.color_view);
        heartView = (HeartView)findViewById(R.id.heart_view);
        redHeart = (RedHeartView)findViewById(red_heart);
        beckoningUtil = new BeckoningUtil(this);
        heartAnimation = AnimationUtils.loadAnimation(this,R.anim.heart_beat);
        animator =  ObjectAnimator.ofFloat(colorTrackView, "progress", 0, 1).setDuration(3900);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(isVisible){
                    redHeart.setVisibility(View.VISIBLE);
                    redHeart.startAnimation(heartAnimation);
                    beckoningUtil.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                beckoningUtil.stop();
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
        heartView.invalidate();
        colorTrackView.setDirection(0);

        animator.start();

    }

    @Override
    protected void onPause() {
        super.onStop();
        isVisible = false;
        redHeart.setVisibility(View.INVISIBLE);
        beckoningUtil.stop();
        heartView.stopDraw();
        animator.cancel();
        heartAnimation.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
