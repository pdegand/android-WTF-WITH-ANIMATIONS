package com.octo.pde.androidanimations.activity;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.octo.pde.androidanimations.view.OctoView;
import com.octo.pde.androidanimations.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LayoutTransitionActivity extends ActionBarActivity {

    private ViewGroup containerViewgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);

        containerViewgroup = (ViewGroup) findViewById(R.id.layout_container);

        LayoutTransition transition = new LayoutTransition();

        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
        Animator scaleUpAnimator = ObjectAnimator.ofPropertyValuesHolder((Object)null, scaleX, scaleY);
        transition.setAnimator(LayoutTransition.APPEARING, scaleUpAnimator);
        transition.setDuration(LayoutTransition.APPEARING, 300);
        transition.setInterpolator(LayoutTransition.APPEARING, new OvershootInterpolator());
        containerViewgroup.setLayoutTransition(transition);
    }

    public void doAdd(View view) {
        OctoView octoView = new OctoView(this);
        octoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OctoView octoView = (OctoView) v;
                octoView.toggleText();
            }
        });

        switch (containerViewgroup.getChildCount()) {
            case 0:
                containerViewgroup.addView(octoView);
                break;
            case 1:
                containerViewgroup.addView(octoView);
                break;
            default:
                containerViewgroup.addView(octoView, 1);
                break;
        }
    }

    public void doRemove(View view) {
        switch (containerViewgroup.getChildCount()) {
            case 0:
                // do nothing
                break;
            case 1:
                containerViewgroup.removeViewAt(0);
                break;
            default:
                containerViewgroup.removeViewAt(1);
                break;
        }
    }
}
