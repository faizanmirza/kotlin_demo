package pk.kotlin.sample.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.DashboardActivity

class OnBoardingStepTwo : Fragment() {

    lateinit var btnGetStarted: Button

    private fun onClickListener() {
        btnGetStarted?.setOnClickListener {
            onGetStartedClicked()
        }
    }

    private fun onGetStartedClicked() {
        val intentActivity = Intent(activity, DashboardActivity::class.java)
        startActivity(intentActivity)
        activity?.finish()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_on_boarding_step_two, container, false)
        btnGetStarted = view.findViewById(R.id.btnGetStarted)
        onClickListener()
        return view
    }
}