package com.octo.pde.androidanimations.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.TransitionSet
import android.view.Window
import com.octo.pde.androidanimations.R
import kotlinx.android.synthetic.main.activity_activity_transition_source.*


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ActivityTransitionSourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.sharedElementExitTransition = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())
        window.sharedElementEnterTransition = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_activity_transition_source)

        betterWayImageView.setOnClickListener {
            val intent = Intent(this, ActivityTransitionTargetActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                betterWayImageView,
                ActivityTransitionTargetActivity.VIEW_NAME_BETTER_WAY
            )
            ActivityCompat.startActivity(this, intent, options.toBundle())
        }
    }
}