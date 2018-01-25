package com.octo.pde.androidanimations.activity

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import android.view.Window
import com.octo.pde.androidanimations.R
import kotlinx.android.synthetic.main.activity_activity_transition_target.*


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ActivityTransitionTargetActivity : AppCompatActivity() {

    companion object {
        const val VIEW_NAME_BETTER_WAY = "betterWay"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // can be done in theme with <item name="android:windowActivityTransitions">true</item>
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.sharedElementExitTransition = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())
        window.sharedElementEnterTransition = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_activity_transition_target)

        window.enterTransition = Slide(Gravity.BOTTOM).apply {
            addTarget(titleTextView)
            addTarget(bodyTextView)
        }
    }
}