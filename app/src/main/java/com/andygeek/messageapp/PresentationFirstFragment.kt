package com.andygeek.messageapp

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.andygeek.messageapp.databinding.FragmentPresentationFirstBinding
import com.andygeek.messageapp.databinding.FragmentPresentationSecondBinding


class PresentationFirstFragment : Fragment() {


    lateinit var binding : FragmentPresentationFirstBinding
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
        val binding = DataBindingUtil.inflate<FragmentPresentationFirstBinding>(inflater, R.layout.fragment_presentation_first, container, false)

        introDesign = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_design)

        val viewPager = container as ViewPager
        viewPager.addOnPageChangeListener( object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        binding.imgIntroDesign1.visibility = View.VISIBLE
                        binding.txtIntro1.visibility = View.VISIBLE
                        binding.txtIntro1.startAnimation(introDesign)
                        binding.imgIntroDesign1.startAnimation(introDesign)
                    }
                    1 -> {
                        binding.imgIntroDesign1.visibility = View.INVISIBLE
                        binding.txtIntro1.visibility = View.INVISIBLE
                    }
                }
            }
        })

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            PresentationFirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}