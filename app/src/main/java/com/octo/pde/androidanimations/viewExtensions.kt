package com.octo.pde.androidanimations

import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver


fun ViewGroup.children() = object : Iterable<View> {
    override fun iterator() = object : Iterator<View> {
        var index = 0
        override fun hasNext() = index < childCount

        override fun next() = getChildAt(index++)
    }
}

inline fun View.doAfterLayout(crossinline action: View.() -> Unit) {
    this.viewTreeObserver.addOnPreDrawListener(
        object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                this@doAfterLayout.viewTreeObserver.removeOnPreDrawListener(this)
                action()
                return true
            }
        }
    )
}

fun ViewGroup.childrenVisibility(visibility: Int) {
    this.children().forEach { it.visibility = visibility }
}