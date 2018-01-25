package com.octo.pde.androidanimations.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v4.widget.ImageViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import com.octo.pde.androidanimations.R
import com.octo.pde.androidanimations.doAfterLayout
import kotlinx.android.synthetic.main.activity_circular_reveal.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CircularRevealActivity : AppCompatActivity() {

    private var isOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_circular_reveal)

        fab.setOnClickListener {
            if (isOpened) closeView()
            else openView()
        }
    }

    private fun openView() {
        fab.setImageResource(R.drawable.ic_done_black_24dp)
        fab.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, android.R.color.white)
        )
        ImageViewCompat.setImageTintList(
            fab,
            ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.blue_octo)
            )
        )

        octoView.visibility = View.VISIBLE
        octoView.doAfterLayout {
            val cx = fab.left + (fab.width / 2)
            val cy = fab.top + (fab.height / 2)
            val finalRadius = Math.hypot(
                cx.toDouble(),
                cy.toDouble()
            ).toFloat()

            val anim = ViewAnimationUtils.createCircularReveal(
                this,
                cx,
                cy,
                0f,
                finalRadius
            )
            anim.start()
        }

        isOpened = true
    }

    private fun closeView() {
        val cx = fab.left + (fab.width / 2)
        val cy = fab.top + (fab.height / 2)
        val initialRadius = Math.hypot(
            cx.toDouble(),
            cy.toDouble()
        ).toFloat()

        val anim = ViewAnimationUtils.createCircularReveal(
            octoView,
            cx,
            cy,
            initialRadius,
            0f
        )
        anim.addListener(object: AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                octoView.visibility = View.GONE

                fab.setImageResource(R.drawable.ic_android_black_24dp)
                fab.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this@CircularRevealActivity, R.color.blue_octo)
                )
                ImageViewCompat.setImageTintList(
                    fab,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(this@CircularRevealActivity, android.R.color.white)
                    )
                )
            }
        })
        anim.start()

        isOpened = false
    }
}