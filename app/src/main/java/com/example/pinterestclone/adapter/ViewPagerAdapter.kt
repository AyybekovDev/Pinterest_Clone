package com.example.pinterestclone.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fragmentMangaer: FragmentManager): FragmentPagerAdapter(fragmentMangaer){
    private val fragments =ArrayList<Fragment>()
    private val titles = ArrayList<String>()
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    fun addFragment(title:String,fragment: Fragment){
        titles.add(title)
        fragments.add(fragment)
    }

}