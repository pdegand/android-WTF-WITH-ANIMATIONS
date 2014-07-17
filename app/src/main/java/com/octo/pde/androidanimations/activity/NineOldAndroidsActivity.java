package com.octo.pde.androidanimations.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.octo.pde.androidanimations.R;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class NineOldAndroidsActivity extends ActionBarActivity {

    private View imageViewOctoLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_old_androids);
        imageViewOctoLove = findViewById(R.id.imageview_octo_love);
        animate(imageViewOctoLove).setDuration(500);
    }

    public void doClick(View view) {
        Toast.makeText(this, "touché", Toast.LENGTH_SHORT).show();
    }

    public void doViewPropertyAnimator(View view) {
        ToggleButton button = (ToggleButton) view;
        if (button.isChecked()) {
            animate(imageViewOctoLove)
                    .translationY(500)
                    .rotation(360)
                    .rotationX(360)
                    .rotationY(360)
                    .scaleX(1.2f)
                    .scaleY(1.2f);
        } else {
            animate(imageViewOctoLove)
                    .translationY(0)
                    .rotation(360)
                    .rotationX(0)
                    .rotationY(0)
                    .scaleX(1)
                    .scaleY(1);
        }
    }
}
