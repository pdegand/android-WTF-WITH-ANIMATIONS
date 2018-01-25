package com.octo.pde.androidanimations.activity

import android.graphics.Rect
import android.os.Bundle
import android.support.transition.*
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.octo.pde.androidanimations.R
import kotlinx.android.synthetic.main.layout_activity_transition_manager.*


class TransitionManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_activity_transition_manager)

        loginButton.setOnClickListener {
            TransitionManager.beginDelayedTransition(rootContainer)
            signupButton.visibility = View.GONE

            emailView.visibility = View.VISIBLE
            passwordView.visibility = View.VISIBLE

            cancelTextView.visibility = View.VISIBLE
        }

        signupButton.setOnClickListener {
            val fadeInterpolator = LinearOutSlowInInterpolator()
            val transition = TransitionSet().apply {
                ordering = TransitionSet.ORDERING_SEQUENTIAL
                addTransition(Fade(Fade.OUT))
                addTransition(ChangeBounds())
                addTransition(Fade(Fade.IN).apply {
                    propagation = CircularPropagation()
                    epicenterCallback = object : Transition.EpicenterCallback() {
                        override fun onGetEpicenter(transition: Transition): Rect {
                            val rect = Rect()
                            logoView.getGlobalVisibleRect(rect)
                            return rect
                        }
                    }
                    interpolator = fadeInterpolator
                    duration = 2000
                })
            }
            TransitionManager.beginDelayedTransition(rootContainer, transition)

            loginButton.visibility = View.GONE

            emailView.visibility = View.VISIBLE
            passwordView.visibility = View.VISIBLE
            verificationView.visibility = View.VISIBLE
            checkboxView.visibility = View.VISIBLE

            cancelTextView.visibility = View.VISIBLE
        }

        cancelTextView.setOnClickListener {
            TransitionManager.beginDelayedTransition(rootContainer)

            loginButton.visibility = View.VISIBLE
            signupButton.visibility = View.VISIBLE

            emailView.visibility = View.GONE
            passwordView.visibility = View.GONE
            verificationView.visibility = View.GONE
            checkboxView.visibility = View.GONE

            cancelTextView.visibility = View.GONE
        }
    }
}
