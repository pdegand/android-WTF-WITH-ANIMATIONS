package com.octo.pde.androidanimations.activity

import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import com.octo.pde.androidanimations.R
import com.octo.pde.androidanimations.view.SpringMove
import kotlinx.android.synthetic.main.activity_physics_transition.*
import java.util.*


class PhysicsTransitionActivity: AppCompatActivity() {

    private val width by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120f, resources.displayMetrics)
            .toInt()
    }

    private val minHeight by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, resources.displayMetrics)
            .toInt()
    }

    private val maxHeight by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120f, resources.displayMetrics)
            .toInt()
    }

    private val topMargin by lazy {
        resources.getDimensionPixelSize(R.dimen.dimen_8dp)
    }

    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_physics_transition)

        fab.setOnClickListener {
            val view = View(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    this@PhysicsTransitionActivity.width,
                    randHeight()
                ).apply {
                    topMargin = this@PhysicsTransitionActivity.topMargin
                }
                setBackgroundColor(ContextCompat.getColor(context, R.color.blue_octo))
            }

            TransitionManager.beginDelayedTransition(
                rootContainer,
                SpringMove().apply {
                    addTarget(imageView)
                }
            )
            containerView.addView(view)
        }
    }

    private fun randHeight() : Int {
        return random.nextInt(maxHeight - minHeight) + minHeight
    }
}