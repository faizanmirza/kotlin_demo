package pk.kotlin.sample.activities

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageButton

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_onboarding.*
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.RegistrationPageAdapter
import pk.kotlin.sample.fragments.RegistrationStepOneFragment
import pk.kotlin.sample.fragments.RegistrationStepThreeFragment
import pk.kotlin.sample.fragments.RegistrationStepTwoFragment
import pk.kotlin.sample.presenter.RegistrationPresenter
import pk.kotlin.sample.views.RegistrationView

class RegistrationActivity : AppCompatActivity(), RegistrationView {

    var registrationPresenter = RegistrationPresenter(this)
    lateinit var registrationPageAdapter: RegistrationPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_registration)
        initUI()
    }


    private fun initUI() {

        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {

        var toolbar = findViewById<Toolbar>(R.id.layoutToolbar)
        var closeButton = toolbar.findViewById<ImageButton>(R.id.toolbarCloseButton)
        setSupportActionBar(toolbar)
        closeButton.setOnClickListener {
            registrationPresenter.onClose()
        }
    }

    private fun setupViewPager() {

        viewPager.beginFakeDrag()

        registrationPageAdapter = RegistrationPageAdapter(supportFragmentManager)
        registrationPageAdapter.addFragment(RegistrationStepOneFragment())
        registrationPageAdapter.addFragment(RegistrationStepTwoFragment())
        registrationPageAdapter.addFragment(RegistrationStepThreeFragment())
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.dotIndicator)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = registrationPageAdapter
        wormDotsIndicator.setViewPager(viewPager)
    }

    fun switchToNextStep() {

        var position = viewPager.currentItem;

        if (registrationPageAdapter.count == position) {

        } else {
            viewPager.setCurrentItem(position + 1, true)
        }
    }

    fun switchToPreviousStep() {

        var position = viewPager.currentItem;

        if (position == 0) {

        } else {
            viewPager.setCurrentItem(position - 1, true)
        }
    }

    override fun finishActivity() {
        this.finish()
    }
}
