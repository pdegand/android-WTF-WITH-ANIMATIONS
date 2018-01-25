package com.octo.pde.androidanimations.view

import android.animation.Animator
import android.graphics.Rect
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.transition.ChangeBounds
import android.support.transition.TransitionValues
import android.view.ViewGroup


class SpringMove: ChangeBounds() {

    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        if (startValues == null || endValues == null) return null

        val startRect = startValues.values["android:changeBounds:bounds"] as Rect
        val endRect = endValues.values["android:changeBounds:bounds"] as Rect
        val view =  endValues.view

        view.translationY = (startRect.top - endRect.top).toFloat()

        SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0f)
            .start()
        return null
    }
}