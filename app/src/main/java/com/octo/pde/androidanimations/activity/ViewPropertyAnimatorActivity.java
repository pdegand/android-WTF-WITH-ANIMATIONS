package com.octo.pde.androidanimations.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;

import com.octo.pde.androidanimations.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class ViewPropertyAnimatorActivity extends AppCompatActivity {

    private View imageViewOctoLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);
        imageViewOctoLove = findViewById(R.id.imageview_octo_love);
        imageViewOctoLove.animate().setDuration(500);
    }

    public void doViewPropertyAnimator(View view) {
        ToggleButton button = (ToggleButton) view;
        if (button.isChecked()) {
            imageViewOctoLove.animate()
                    .translationY(500)
                    .rotation(360)
                    .rotationX(360)
                    .rotationY(360)
                    .scaleX(1.2f)
                    .scaleY(1.2f);
        } else {
            imageViewOctoLove.animate()
                    .translationY(0)
                    .rotation(360)
                    .rotationX(0)
                    .rotationY(0)
                    .scaleX(1)
                    .scaleY(1);
        }
    }
}
