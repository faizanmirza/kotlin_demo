package pk.kotlin.sample.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created on 01/04/2019.
 */

public class RegistrationPageAdapter(manager: FragmentManager?) : FragmentPagerAdapter(manager) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

    fun removeFragment(position: Int) {
        mFragmentList.removeAt(position)
    }

    public override fun getCount(): Int {
        return mFragmentList.size
    }
}