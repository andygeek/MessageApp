package com.andygeek.messageapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.andygeek.messageapp.databinding.FragmentPresentationThirdBinding

class PresentationThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_presentation_third, container, false)
        val binding = DataBindingUtil.inflate<FragmentPresentationThirdBinding>(inflater,R.layout.fragment_presentation_third,container,false)
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