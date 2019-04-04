package pk.kotlin.sample.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.RegistrationActivity
import pk.kotlin.sample.presenter.OnBoardingStepTwoPresenter
import pk.kotlin.sample.views.OnBoardingStepTwoView

class OnBoardingStepTwo : Fragment(), OnBoardingStepTwoView {

    private var onBoardingStepTwoPresenter: OnBoardingStepTwoPresenter? = OnBoardingStepTwoPresenter(this)
    lateinit var btnGetStarted: Button

    override fun setActionListener() {
        btnGetStarted.setOnClickListener {
            onBoardingStepTwoPresenter?.switchToLoginActivity()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_on_boarding_step_two, container, false)
        btnGetStarted = view.findViewById(R.id.btnGetStarted)
        onBoardingStepTwoPresenter?.setActionListener()
        return view
    }

    override fun startActivity() {
        val intentActivity = Intent(activity, RegistrationActivity::class.java)
        startActivity(intentActivity)
        activity?.finish()
    }
}