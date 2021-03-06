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
import pk.kotlin.sample.entities.Registration
import pk.kotlin.sample.presenter.RegistrationStepThreeFragmentPresenter
import pk.kotlin.sample.utils.Utils
import pk.kotlin.sample.views.RegistrationStepThreeFragmentView

class RegistrationStepThreeFragment : Fragment(), RegistrationStepThreeFragmentView {

    lateinit var btnDone: Button
    lateinit var btnBack: Button
    lateinit var imgLogo: ImageView
    lateinit var txtTitle: TextView
    lateinit var txtInputWorkPlace: TextInputLayout
    var registrationStepThreeFragmentPresenter = RegistrationStepThreeFragmentPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_step_three, container, false)
        initUI(view)
        registrationStepThreeFragmentPresenter.setupUIForRole((activity as RegistrationActivity).registrationPresenter.isStudent)
        return view
    }

    private fun initUI(view: View) {

        btnDone = view.findViewById(R.id.btnDone)
        btnBack = view.findViewById(R.id.btnBack)
        imgLogo = view.findViewById(R.id.imgLogo)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtInputWorkPlace = view.findViewById(R.id.txtInputWorkPlace)

        btnDone.setOnClickListener {

            onDoneClick()
        }

        btnBack.setOnClickListener { (activity as RegistrationActivity).switchToPreviousStep() }
    }

    private fun onDoneClick() {
        registrationStepThreeFragmentPresenter.isWorkPlaceValid(txtInputWorkPlace.editText?.text.toString())
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isVisibleToUser && isResumed) {
            registrationStepThreeFragmentPresenter.setupUIForRole((activity as RegistrationActivity).registrationPresenter.isStudent)
        }
    }

    override fun setUIForProfessional() {

        txtInputWorkPlace.editText?.setText("")
        txtTitle.text = Utils.getString(R.string.desc_work)
        imgLogo.setImageDrawable(Utils.getDrawable(R.drawable.ic_work))
        txtInputWorkPlace.hint = Utils.getString(R.string.workplace)
        btnDone.text = Utils.getString(R.string.btn_next)
        btnDone.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            Utils.getDrawable(R.drawable.ic_arrow_forward),
            null
        )

    }

    override fun setUIForStudent() {

        txtInputWorkPlace.editText?.setText("")
        txtInputWorkPlace.error = ""
        txtTitle.text = Utils.getString(R.string.desc_study)
        imgLogo.setImageDrawable(Utils.getDrawable(R.drawable.ic_school))
        txtInputWorkPlace.hint = Utils.getString(R.string.institute)
        btnDone.text = Utils.getString(R.string.btn_next)
        btnDone.text = Utils.getString(R.string.done)
        btnDone.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            Utils.getDrawable(R.drawable.ic_check_circle),
            null
        )
    }

    override fun onWorkPlaceValidSuccess() {

        txtInputWorkPlace.error = ""

        if ((activity as RegistrationActivity).registrationPresenter.registration == null)
            (activity as RegistrationActivity).registrationPresenter.registration = Registration()

        (activity as RegistrationActivity).registrationPresenter.registration.workOrInstitute =
            txtInputWorkPlace.editText?.text.toString()
        (activity as RegistrationActivity).switchToNextStep()
    }

    override fun onWorkPlaceValidFailed() {

        txtInputWorkPlace.error =
            if ((activity as RegistrationActivity).registrationPresenter.isStudent) getString(R.string.institue_required) else getString(
                R.string.error_workplace
            )
    }
}