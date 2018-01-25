package com.octo.pde.androidanimations.activity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.octo.pde.androidanimations.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AnimatorBasicsActivity extends AppCompatActivity {

    private View rootView;
    private TextView paddingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_basics);
        rootView = findViewById(R.id.root_view);
        paddingTextView = findViewById(R.id.textview_padding);
    }

    public void doClick(View view) {
        Toast.makeText(this, R.string.octo_love, Toast.LENGTH_SHORT).show();
    }

    public void doTranslate(View view) {
        View octoLoveView = findViewById(R.id.layout_octo_love);
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(
                octoLoveView, "translationY", 0, octoLoveView.getMeasuredHeight());
        translationAnimator.setDuration(400);
        translationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        translationAnimator.start();
    }

    public void doBackgroundColorFade(View view) {
        int fromColor = Color.TRANSPARENT;
        Drawable rootBackground = rootView.getBackground();
        if (rootBackground instanceof ColorDrawable) {
            fromColor = ((ColorDrawable) rootBackground).getColor();
        }
        Integer toColor = getResources().getColor(R.color.blue_octo);

        ValueAnimator colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rootView.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());
            }
        });
        colorAnimator.setDuration(500);
        colorAnimator.start();
    }

    public void doProperty(View view) {
        ObjectAnimator paddingAnimator = ObjectAnimator.ofInt(this, "paddingLeftOnTextView", getResources().getDimensionPixelSize(R.dimen.dimen_standard_padding));
        paddingAnimator.setDuration(750);
        paddingAnimator.setInterpolator(new OvershootInterpolator());
        paddingAnimator.start();
    }

    @SuppressWarnings("unused")
    public void setPaddingLeftOnTextView(int padding) {
        paddingTextView.setPadding(padding,
                paddingTextView.getPaddingTop(),
                paddingTextView.getPaddingRight(),
                paddingTextView.getPaddingBottom());
    }

    @SuppressWarnings("unused")
    public int getPaddingLeftOnTextView() {
        return paddingTextView.getPaddingLeft();
    }
}
