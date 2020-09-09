package com.andygeek.messageapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.andygeek.messageapp.databinding.FragmentPresentationSecondBinding

class PresentationSecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        //return inflater.inflate(R.layout.fragment_presentation_second, container, false)
        val binding = DataBindingUtil.inflate<FragmentPresentationSecondBinding>(inflater,R.layout.fragment_presentation_second,container, false)
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