package com.octo.pde.androidanimations.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.octo.pde.androidanimations.R;

public class ViewCompatAnimateActivity extends AppCompatActivity {

    private View imageViewOctoLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_old_androids);
        imageViewOctoLove = findViewById(R.id.imageview_octo_love);
        ViewCompat.animate(imageViewOctoLove).setDuration(500);
    }

    public void doClick(View view) {
        Toast.makeText(this, "touché", Toast.LENGTH_SHORT).show();
    }

    public void doViewPropertyAnimator(View view) {
        ToggleButton button = (ToggleButton) view;
        if (button.isChecked()) {
            ViewCompat.animate(imageViewOctoLove)
                    .translationY(500)
                    .rotation(360)
                    .rotationX(360)
                    .rotationY(360)
                    .scaleX(1.2f)
                    .scaleY(1.2f);
        } else {
            ViewCompat.animate(imageViewOctoLove)
                    .translationY(0)
                    .rotation(360)
                    .rotationX(0)
                    .rotationY(0)
                    .scaleX(1)
                    .scaleY(1);
        }
    }
}
