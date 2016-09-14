package jp.yitt.viewpagertransformerexample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View

class SimpleViewPagerAdapter(fm: FragmentManager, val pageCount: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment
            = CardPagerItemFragment.newInstance(position)

    override fun getCount() = pageCount

    fun getViewAtPosition(pager: ViewPager, position: Int): View?
            = (instantiateItem(pager, position) as Fragment).view

}