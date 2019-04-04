package pk.kotlin.sample.presenter

import android.text.TextUtils
import pk.kotlin.sample.views.RegistrationStepThreeFragmentView

/**
 * Created on 02/04/2019.
 */

class RegistrationStepThreeFragmentPresenter(var registrationStepThreeFragmentView: RegistrationStepThreeFragmentView?) :
    BasePresenter() {

    override fun onDestory() {
        registrationStepThreeFragmentView = null
    }

    fun setupUIForRole(isStudent: Boolean) {

        if (isStudent) {
            registrationStepThreeFragmentView?.setUIForStudent()
        } else {
            registrationStepThreeFragmentView?.setUIForProfessional()
        }
    }

    fun isWorkPlaceValid(designation: String) {

        if (TextUtils.isEmpty(designation)) {
            registrationStepThreeFragmentView?.onWorkPlaceValidFailed()
        } else {
            registrationStepThreeFragmentView?.onWorkPlaceValidSuccess()
        }
    }
}