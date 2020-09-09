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
import com.andygeek.messageapp.databinding.FragmentPresentationThirdBinding

class PresentationThirdFragment : Fragment() {

    lateinit var animButtonIntro : Animation
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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_presentation_third, container, false)
        val binding = DataBindingUtil.inflate<FragmentPresentationThirdBinding>(inflater,R.layout.fragment_presentation_third,container,false)

        animButtonIntro = AnimationUtils.loadAnimation(mContext,R.anim.anim_button_intro)

        binding.btnIntro.setOnClickListener {
            it.startAnimation(animButtonIntro)
        }

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