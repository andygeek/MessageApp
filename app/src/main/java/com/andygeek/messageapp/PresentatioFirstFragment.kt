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
import com.andygeek.messageapp.databinding.FragmentPresentatioFirstBinding


class PresentatioFirstFragment : Fragment() {

    lateinit var introDesign1 : Animation
    lateinit var introBack1 : Animation
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
        val binding= DataBindingUtil.inflate<FragmentPresentatioFirstBinding>(inflater, R.layout.fragment_presentatio_first, container, false)

        introDesign1 = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_design_1)
        introBack1 = AnimationUtils.loadAnimation(mContext, R.anim.anim_intro_back_1)


        binding.imgDesg1.animation = introDesign1
        binding.imgBack1.animation = introBack1
        binding.imgBack2.animation = introBack1
        binding.imgBack3.animation = introBack1
        binding.imgBack4.animation = introBack1
        binding.imgBack5.animation = introBack1

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PresentatioFirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}