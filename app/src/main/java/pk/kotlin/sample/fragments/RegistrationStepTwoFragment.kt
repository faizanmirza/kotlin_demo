package pk.kotlin.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.RegistrationActivity

class RegistrationStepTwoFragment : Fragment() {

    lateinit var btnBack: Button
    lateinit var btnStudent: Button
    lateinit var btnProfessional: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_step_two, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {

        btnBack = view.findViewById(R.id.btnBack)
        btnStudent = view.findViewById(R.id.btnStudent)
        btnProfessional = view.findViewById(R.id.btnProfessional)

        btnBack.setOnClickListener {
            (activity as RegistrationActivity).switchToPreviousStep()
        }

        btnStudent.setOnClickListener {
            (activity as RegistrationActivity).registrationPresenter.isStudent = true
            (activity as RegistrationActivity).switchToNextStep()
        }

        btnProfessional.setOnClickListener {
            (activity as RegistrationActivity).registrationPresenter.isStudent = false
            (activity as RegistrationActivity).switchToNextStep()
        }
    }
}