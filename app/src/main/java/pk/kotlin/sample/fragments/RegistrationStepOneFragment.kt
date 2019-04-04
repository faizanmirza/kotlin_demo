package pk.kotlin.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.RegistrationActivity
import pk.kotlin.sample.entities.Registration
import pk.kotlin.sample.presenter.RegistrationStepOneFragmentPresenter
import pk.kotlin.sample.views.RegistrationStepOneFragmentView

class RegistrationStepOneFragment : Fragment(), RegistrationStepOneFragmentView {

    var registrationStepOneFragmentPresenter = RegistrationStepOneFragmentPresenter(this)
    lateinit var btnNext: Button
    lateinit var txtInputPhoneNumber: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_step_one, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {

        btnNext = view.findViewById(R.id.btnNext)
        txtInputPhoneNumber = view.findViewById(R.id.txtInputPhoneNumber)
        btnNext.setOnClickListener { registrationStepOneFragmentPresenter.validatePhoneNumber(txtInputPhoneNumber.editText?.text.toString()) }
    }

    override fun showInvaildPhoneNumberError() {

        txtInputPhoneNumber.setErrorTextColor(activity?.resources?.getColorStateList(R.color.red))
        txtInputPhoneNumber.error =
            "You wouldn't want to miss any important update!\nPlease enter a valid mobile number"
    }

    override fun switchToStepTwo() {

        txtInputPhoneNumber.error = ""
        (activity as RegistrationActivity).registrationPresenter.registration = Registration()
        (activity as RegistrationActivity).registrationPresenter.registration.phone =
            txtInputPhoneNumber.editText?.text.toString()
        (activity as RegistrationActivity).switchToNextStep()
    }
}