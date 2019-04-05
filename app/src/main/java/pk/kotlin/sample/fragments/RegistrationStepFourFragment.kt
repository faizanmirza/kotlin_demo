package pk.kotlin.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.RegistrationActivity
import pk.kotlin.sample.presenter.RegistrationStepFourFragmentPresenter
import pk.kotlin.sample.utils.Utils
import pk.kotlin.sample.views.RegistrationStepFourFragmentView

class RegistrationStepFourFragment : Fragment(), RegistrationStepFourFragmentView {

    var registrationStepFourFragmentPresenter = RegistrationStepFourFragmentPresenter(this)
    lateinit var btnDone: Button
    lateinit var btnBack: Button
    lateinit var imgLogo: ImageView
    lateinit var txtTitle: TextView
    lateinit var txtInputDesignation: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_step_four, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {

        btnDone = view.findViewById(R.id.btnDone)
        btnBack = view.findViewById(R.id.btnBack)
        imgLogo = view.findViewById(R.id.imgLogo)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtInputDesignation = view.findViewById(R.id.txtInputDesignation)

        setUI()

        btnDone.setOnClickListener {
            registrationStepFourFragmentPresenter.isDesignationValid(txtInputDesignation.editText?.text.toString())
        }

        btnBack.setOnClickListener { (activity as RegistrationActivity).switchToSelectProfession() }
    }

    private fun setUI() {
        txtInputDesignation.error = ""
        txtInputDesignation.editText?.setText("")
        txtTitle.text =
            Utils.getString(R.string.msg_desgination) + " " + (activity as RegistrationActivity).registrationPresenter.registration.workOrInstitute + "?"
    }

    override fun onDesignationValidSuccess() {
        txtInputDesignation.error = ""
        (activity as RegistrationActivity).registrationPresenter.registration.designation =
            txtInputDesignation.editText?.text.toString()
        (activity as RegistrationActivity).onRegistrationComplete()

    }

    override fun onDesignationValidFailed() {
        txtInputDesignation.error = getString(R.string.error_desgination_required)
    }
}