package com.basicappstructure.utils

import android.graphics.Color
import androidx.viewpager.widget.ViewPager

internal fun ViewPager.onPageSelected(selection: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) = selection(position)

        override fun onPageScrollStateChanged(state: Int) = Unit

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) = Unit
    })
}

internal fun Int.isColorLight(): Boolean {
    if (this == Color.BLACK) {
        return false
    } else if (this == Color.WHITE || this == Color.TRANSPARENT) {
        return true
    }
    val darkness =
        1 - (0.299 * Color.red(this) +
                0.587 * Color.green(this) +
                0.114 * Color.blue(this)) / 255
    return darkness < 0.4
}
