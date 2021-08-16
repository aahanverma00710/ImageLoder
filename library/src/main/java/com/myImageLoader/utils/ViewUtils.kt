package com.myImageLoader.utils

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.setAlpha() {
    animate().alpha(1f)
}

fun View.removeAlpha() {
    animate().alpha(0f)
}
