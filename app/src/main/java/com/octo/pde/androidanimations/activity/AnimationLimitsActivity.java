package com.octo.pde.androidanimations.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.octo.pde.androidanimations.R;

public class AnimationLimitsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_limits);
    }

    public void doClick(View view) {
        Toast.makeText(this, R.string.octo_love, Toast.LENGTH_SHORT).show();
    }

    public void doTranslate(View view) {
        View octoLoveView = findViewById(R.id.layout_octo_love);
        Animation translateAnimation = new TranslateAnimation(0, 0, 0, octoLoveView.getMeasuredHeight());
        translateAnimation.setDuration(400);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        octoLoveView.startAnimation(translateAnimation);
    }
}
