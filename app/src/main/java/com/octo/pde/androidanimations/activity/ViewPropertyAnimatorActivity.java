package com.octo.pde.androidanimations.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.octo.pde.androidanimations.R;

public class ViewPropertyAnimatorActivity extends AppCompatActivity {

    private View imageViewOctoLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);
        imageViewOctoLove = findViewById(R.id.imageview_octo_love);
        imageViewOctoLove.animate().setDuration(500);

        imageViewOctoLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void doViewPropertyAnimator(View view) {
        ToggleButton button = (ToggleButton) view;
        if (button.isChecked()) {
            imageViewOctoLove.animate()
                             .translationY(500)
                             .rotation(360)
                             .rotationX(360)
                             .rotationY(360)
                             .scaleX(1.5f)
                             .scaleY(1.5f)
                             .setListener(new AnimatorListenerAdapter() {
                                 @Override
                                 public void onAnimationEnd(Animator animation) {
                                     super.onAnimationEnd(animation);
                                     Toast.makeText(ViewPropertyAnimatorActivity.this, "coucou",
                                                    Toast.LENGTH_SHORT).show();
                                 }
                             });
        } else {
            ViewCompat.animate(imageViewOctoLove)
                      .translationY(0)
                      .rotation(0)
                      .rotationX(0)
                      .rotationY(0)
                      .scaleX(1)
                      .setListener(null)
                      .scaleY(1);
        }
    }
}
