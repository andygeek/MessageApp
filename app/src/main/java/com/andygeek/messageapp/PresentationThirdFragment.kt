package com.andygeek.messageapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.andygeek.messageapp.databinding.FragmentPresentationThirdBinding

class PresentationThirdFragment : Fragment() {

    lateinit var animButtonIntro : Animation
    lateinit var introDesign : Animation
    lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPresentationThirdBinding>(inflater,R.layout.fragment_presentation_third,container,false)

        animButtonIntro = AnimationUtils.loadAnimation(mContext,R.anim.anim_button_intro)
        introDesign = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_design)

        binding.btnIntro.setOnClickListener {
            it.startAnimation(animButtonIntro)
        }

        val viewPager = container as ViewPager
        viewPager.addOnPageChangeListener( object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                when(position){
                    1 -> {
                        binding.imgIntroDesign4.visibility = View.INVISIBLE
                        binding.txtIntro3.visibility = View.INVISIBLE
                    }
                    2 -> {
                        binding.imgIntroDesign4.visibility = View.VISIBLE
                        binding.txtIntro3.visibility = View.VISIBLE
                        binding.imgIntroDesign4.startAnimation(introDesign)
                        binding.txtIntro3.startAnimation(introDesign)
                    }
                }
            }
        })

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PresentationThirdFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}