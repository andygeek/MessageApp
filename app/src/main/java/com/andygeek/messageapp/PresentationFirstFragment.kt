package com.andygeek.messageapp

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.andygeek.messageapp.databinding.FragmentPresentationFirstBinding


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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_presentation_first, container, false)

        introDesign = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_design)

        val nn = container as ViewPager
        nn.addOnPageChangeListener( object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        binding.imgIntroDesign1.startAnimation(introDesign)
                    }
                    1 -> {
                        binding.imgIntroDesign1.visibility = View.INVISIBLE
                    }
                }
            }
        })

        return binding.root
    }


    override fun onStart() {
        super.onStart()

    }

    public fun doSomething(){
        binding.imgIntroDesign1.animation = introDesign
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