package com.andygeek.messageapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.andygeek.messageapp.databinding.FragmentPresentationSecondBinding

class PresentationSecondFragment : Fragment() {

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

        val binding = DataBindingUtil.inflate<FragmentPresentationSecondBinding>(inflater,R.layout.fragment_presentation_second,container, false)

        introDesign = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_design)


        val viewPager = container as ViewPager
        viewPager.addOnPageChangeListener( object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        binding.imgIntroDesign2.visibility = View.INVISIBLE
                        binding.imgIntroDesign3.visibility = View.INVISIBLE
                        binding.txtIntro2.visibility = View.INVISIBLE
                    }
                    1 -> {
                        binding.txtIntro2.visibility = View.VISIBLE
                        binding.imgIntroDesign2.visibility = View.VISIBLE
                        binding.imgIntroDesign3.visibility = View.VISIBLE
                        binding.imgIntroDesign2.startAnimation(introDesign)
                        binding.imgIntroDesign3.startAnimation(introDesign)
                        binding.txtIntro2.startAnimation(introDesign)
                    }
                    2 -> {
                        binding.txtIntro2.visibility = View.INVISIBLE
                        binding.imgIntroDesign2.visibility = View.INVISIBLE
                        binding.imgIntroDesign3.visibility = View.INVISIBLE
                    }
                }
            }
        })


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PresentationSecondFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}