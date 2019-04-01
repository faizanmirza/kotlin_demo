package pk.kotlin.sample.activities

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.OnBoardingPageAdapter
import pk.kotlin.sample.fragments.OnBoardingStepOne
import pk.kotlin.sample.fragments.OnBoardingStepTwo

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        initUI()
    }

    private fun initUI() {

        val adapter = OnBoardingPageAdapter(supportFragmentManager)
        adapter.addFragment(OnBoardingStepOne())
        adapter.addFragment(OnBoardingStepTwo())
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.dotIndicator)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter
        wormDotsIndicator.setViewPager(viewPager)
    }
}
