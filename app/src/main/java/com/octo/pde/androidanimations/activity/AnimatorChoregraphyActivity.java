package com.octo.pde.androidanimations.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.octo.pde.androidanimations.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AnimatorChoregraphyActivity extends AppCompatActivity {

    private View octoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_choregraphy);
        octoImageView = findViewById(R.id.imageview_octo);

    }

    public void doChoregraphy(View view) {
        octoImageView.setPivotX(0);
        octoImageView.setPivotY(octoImageView.getMeasuredHeight() * 0.2f);

        // RESET ALL PROPERTIES
        octoImageView.setScaleX(1);
        octoImageView.setScaleY(1);
        octoImageView.setRotation(0);
        octoImageView.setAlpha(1);
        octoImageView.setTranslationX(0);
        octoImageView.setTranslationY(0);

        AnimatorSet breakAnimator = new AnimatorSet();

        // SCALE DOWN ANIMATOR
        PropertyValuesHolder scaleXValueHolder = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.8f);
        PropertyValuesHolder scaleYValueHolder = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.8f);
        Animator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(
                octoImageView,
                scaleXValueHolder,
                scaleYValueHolder
        );
        scaleAnimator.setDuration(400);

        // ROTATE AND CENTER ANIMATOR SET
        AnimatorSet rotateAndCenterAnimatorSet = new AnimatorSet();
        rotateAndCenterAnimatorSet.setDuration(500);

        // ROTATE ANIMATOR
        Animator rotateAnimator = ObjectAnimator.ofFloat(
                octoImageView,
                "rotation",
                0f,
                75f
        );
        rotateAnimator.setInterpolator(new OvershootInterpolator());

        // CENTER ANIMATOR
        Animator centerAnimator = ObjectAnimator.ofFloat(
                octoImageView,
                "translationX",
                0,
                octoImageView.getMeasuredWidth() / 2
        );

        rotateAndCenterAnimatorSet.playTogether(rotateAnimator, centerAnimator);

        // FALL AND FADE ANIMATOR SET
        AnimatorSet fallAndFadeAnimator = new AnimatorSet();
        fallAndFadeAnimator.setDuration(400);

        // FALL DOWN ANIMATOR
        Animator fallDownAnimator = ObjectAnimator.ofFloat(
                octoImageView,
                "translationY",
                octoImageView.getRootView().getHeight() - octoImageView.getTop()
        );
        fallDownAnimator.setInterpolator(new AccelerateInterpolator());

        // FADE OUT ANIMATOR
        Animator fadeOutAnimator = ObjectAnimator.ofFloat(
                octoImageView,
                "alpha",
                0f
        );
        fadeOutAnimator.setInterpolator(new LinearInterpolator());

        fallAndFadeAnimator.playTogether(fallDownAnimator, fadeOutAnimator);

        breakAnimator.playSequentially(scaleAnimator, rotateAndCenterAnimatorSet, fallAndFadeAnimator);
        breakAnimator.start();
    }
}
