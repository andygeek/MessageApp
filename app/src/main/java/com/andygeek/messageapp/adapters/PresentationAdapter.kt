package com.andygeek.messageapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.andygeek.messageapp.PresentationFirstFragment
import com.andygeek.messageapp.PresentationSecondFragment
import com.andygeek.messageapp.PresentationThirdFragment

class PresentationAdapter(manager: FragmentManager) : FragmentPagerAdapter( manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val num_items = 3

    override fun getCount(): Int {
        return num_items
    }




    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return PresentationFirstFragment.newInstance()
            1 -> return PresentationSecondFragment.newInstance()
            2 -> return PresentationThirdFragment.newInstance()
            else -> return PresentationThirdFragment.newInstance()
        }
    }

}