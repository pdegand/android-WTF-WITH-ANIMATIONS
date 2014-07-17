package com.octo.pde.androidanimations.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.octo.pde.androidanimations.R;

public class AnimationBasicsActivity extends ActionBarActivity {

    private View octo;
    private int mediumAnimTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_basics);
        octo = findViewById(R.id.imageview_octo);
        mediumAnimTime = getResources().getInteger(android.R.integer.config_mediumAnimTime);
    }

    // ----------------------------------
    // ANIMATIONS METHODS
    // ----------------------------------

    public void doTranslation(View view) {
        Animation translationAnimation = new TranslateAnimation(0, 0, 0, 400);
        translationAnimation.setDuration(mediumAnimTime);
        translationAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        octo.startAnimation(translationAnimation);
    }

    public void doRotation(View view) {
        Animation rotationAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        octo.startAnimation(rotationAnimation);
    }

    public void doScale(View view) {
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        octo.startAnimation(scaleAnimation);
    }

    public void doAlpha(View view) {
        Animation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setInterpolator(new BounceInterpolator());
        alphaAnimation.setFillAfter(true);
        octo.startAnimation(alphaAnimation);
    }

    public void doSet(View view) {
        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
        setAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // do nothing
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimationBasicsActivity.this, "END SET", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // do nothing
            }
        });
        octo.startAnimation(setAnimation);
    }
}
