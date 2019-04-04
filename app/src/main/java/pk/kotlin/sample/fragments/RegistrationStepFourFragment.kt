package pk.kotlin.sample.fragments

import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.RegistrationActivity
import pk.kotlin.sample.utils.Utils

class RegistrationStepFourFragment : Fragment() {

    lateinit var btnDone: Button
    lateinit var btnBack: Button
    lateinit var imgLogo: ImageView
    lateinit var txtTitle: TextView
    lateinit var txtInputWorkPlace: TextInputLayout
    var isStudent = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_step_three, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {

        btnDone = view.findViewById(R.id.btnDone)
        btnBack = view.findViewById(R.id.btnBack)
        imgLogo = view.findViewById(R.id.imgLogo)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtInputWorkPlace = view.findViewById(R.id.txtInputWorkPlace)

        if (isStudent) {
            setUIForStudent()
        } else {
            setUIForProfessional()
        }

        btnDone.setOnClickListener {
            (activity as RegistrationActivity).switchToNextStep()
        }

        btnBack.setOnClickListener { (activity as RegistrationActivity).switchToPreviousStep() }
    }

    private fun setUIForProfessional() {

        txtTitle.text = Utils.getString(R.string.desc_work)
        imgLogo.setImageDrawable(Utils.getDrawable(R.drawable.ic_work))
        txtInputWorkPlace.hint = Utils.getString(R.string.workplace)
        btnDone.text = Utils.getString(R.string.done)
        btnDone.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            Utils.getDrawable(R.drawable.ic_check_circle),
            null
        )
    }

    private fun setUIForStudent() {

        txtTitle.text = Utils.getString(R.string.desc_study)
        imgLogo.setImageDrawable(Utils.getDrawable(R.drawable.ic_school))
        txtInputWorkPlace.hint = Utils.getString(R.string.institute)
        btnDone.text = Utils.getString(R.string.btn_next)
        btnDone.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            Utils.getDrawable(R.drawable.ic_arrow_forward),
            null
        )
    }
}