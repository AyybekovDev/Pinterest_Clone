package com.example.pinterestclone.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.pinterestclone.R
import com.example.pinterestclone.adapter.ViewPagerAdapter

import com.google.android.material.tabs.TabLayout

class MessageFragment : Fragment(R.layout.fragment_message) {
    lateinit var viewPager:ViewPager
    lateinit var tabLayout :TabLayout
    lateinit var adapter:ViewPagerAdapter
    lateinit var updatesFragment:UpdatesFragment
    lateinit var messageInMessageFragment:MessageInMessageFragment
    var TAG="@@@"
    var isdestroy=true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        updatesFragment = UpdatesFragment()
        messageInMessageFragment = MessageInMessageFragment()
        adapter.addFragment("Обновления", updatesFragment)
        adapter.addFragment("Сообщение", messageInMessageFragment)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()
        if (isdestroy) initViews(view!!)
        isdestroy=false
    }
    override fun onDestroyView() {
        super.onDestroyView()
        isdestroy=true
    }

}
