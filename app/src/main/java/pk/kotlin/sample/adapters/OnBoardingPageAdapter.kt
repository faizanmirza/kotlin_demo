package pk.kotlin.sample.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

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