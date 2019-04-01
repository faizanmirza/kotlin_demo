package pk.kotlin.sample.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created on 01/04/2019.
 */

public class OnBoardingPageAdapter(manager: FragmentManager?) : FragmentPagerAdapter(manager) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

    public override fun getCount(): Int {
        return mFragmentList.size;
    }
}