package com.andygeek.messageapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.andygeek.messageapp.adapters.PresentationAdapter
import com.andygeek.messageapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bindind : ActivityMainBinding
    lateinit var context : Context
    lateinit var animBounce : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        bindind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        animBounce = AnimationUtils.loadAnimation(context, R.anim.anim_bounce)

        // Forma de hacer translucida el status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val vPager = findViewById(R.id.myFragmentPresentations) as ViewPager
        val adapter = PresentationAdapter(supportFragmentManager)
        vPager.adapter = adapter



        bindind.pointPage0.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_true)

        vPager.addOnPageChangeListener( object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        bindind.pointPage0.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_true)
                        bindind.pointPage1.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage2.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage0.startAnimation(animBounce)


                    }
                    1 -> {
                        bindind.pointPage1.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_true)
                        bindind.pointPage0.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage2.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage1.startAnimation(animBounce)
                    }
                    2 -> {
                        bindind.pointPage2.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_true)
                        bindind.pointPage1.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage0.background = ContextCompat.getDrawable(context, R.drawable.shape_select_page_false)
                        bindind.pointPage2.startAnimation(animBounce)
                    }
                }
            }
        })
    }

}