package com.octo.pde.androidanimations.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.octo.pde.androidanimations.R;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TransitionBasicsActivity extends AppCompatActivity {

    private Scene scene;
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_basics);

        container = ((ViewGroup)findViewById(R.id.scene));
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void doSceneTransition(View view) {
        scene = Scene.getSceneForLayout(container, R.layout.activity_transition_basics_scene2, this);
        TransitionManager.go(scene, new AutoTransition());
    }

    public void revertSceneTransition(View view) {
        scene = Scene.getSceneForLayout(container, R.layout.activity_transition_basics, this);
        TransitionManager.go(scene);
    }
}
