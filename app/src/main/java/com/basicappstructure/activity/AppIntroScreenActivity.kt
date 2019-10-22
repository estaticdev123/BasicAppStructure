package com.basicappstructure.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.basicappstructure.R
import com.basicappstructure.adapter.MainPagerAdapter
import com.basicappstructure.utils.isColorLight
import com.basicappstructure.utils.onPageSelected
import kotlinx.android.synthetic.main.activity_app_intro.*

class AppIntroScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_intro)

        pager.adapter = MainPagerAdapter()
        pager.offscreenPageLimit = 3
        dots.attachViewPager(pager)

        pager.onPageSelected {
            val colorRes = when (it) {
                0 -> R.color.blue
                1 -> R.color.red
                2 -> R.color.white
                else -> R.color.green
            }
            val color = ContextCompat.getColor(this, colorRes)
            frame.setBackgroundColor(color)
            dots.setDotTintRes(if (color.isColorLight()) R.color.black else R.color.white)
        }


        /*val dots: DotsIndicator = // ...

// This lets you switch out the indicator drawables at runtime.
dots.setDotDrawable(
  indicatorRes = R.drawable.some_drawable,
  unselectedIndicatorRes = R.drawable.other_drawable // optional, defaults to above
)

// These two let you dynamically tint your indicators at runtime.
dots.setDotTint(Color.BLACK)
dots.setDotTintRes(R.color.black)*/


    }
}