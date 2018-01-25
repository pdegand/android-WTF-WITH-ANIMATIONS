package com.octo.pde.androidanimations.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.octo.pde.androidanimations.R;


/**
 * Simple View with an Octo ImageView and a togglable text bellow.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class OctoView extends LinearLayout {

    private boolean isOpen = false;

    private View textView;

    public OctoView(Context context) {
        this(context, null);
    }

    public OctoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public void toggleText() {
        if (isOpen) {
            textView.animate().alpha(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    textView.setVisibility(GONE);
                }
            });
            isOpen = false;
        } else {
            textView.setVisibility(VISIBLE);
            textView.animate().alpha(1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    textView.setVisibility(VISIBLE);
                }
            });
            isOpen = true;
        }
    }

    private void initializeView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_octo, this);
        this.textView = findViewById(R.id.text_viewgroup);
        textView.setAlpha(0);
        textView.animate().setDuration(400);
    }
}
