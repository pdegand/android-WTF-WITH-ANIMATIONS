package com.octo.pde.androidanimations.activity;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.octo.pde.androidanimations.R;
import com.octo.pde.androidanimations.view.OctoView;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class LayoutTransitionChangingActivity extends AppCompatActivity {

    private ViewGroup containerViewgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);

        containerViewgroup = (ViewGroup) findViewById(R.id.layout_container);

        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);

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
