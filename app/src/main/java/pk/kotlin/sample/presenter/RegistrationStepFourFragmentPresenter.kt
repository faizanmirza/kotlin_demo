package pk.kotlin.sample.presenter

import android.text.TextUtils
import pk.kotlin.sample.views.RegistrationStepFourFragmentView

/**
 * Created on 02/04/2019.
 */

class RegistrationStepFourFragmentPresenter(var registrationStepFourFragmentView: RegistrationStepFourFragmentView?) :

    BasePresenter() {

    override fun onDestory() {
        registrationStepFourFragmentView = null
    }

    fun isDesignationValid(designation: String) {

        if (TextUtils.isEmpty(designation)) {
            registrationStepFourFragmentView?.onDesignationValidFailed()
        } else {
            registrationStepFourFragmentView?.onDesignationValidSuccess()

        }
    }
}