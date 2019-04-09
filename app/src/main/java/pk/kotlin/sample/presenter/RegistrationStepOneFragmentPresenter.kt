package pk.kotlin.sample.presenter

import pk.kotlin.sample.utils.ValidationHelper
import pk.kotlin.sample.views.RegistrationStepOneFragmentView

/**
 * Created on 02/04/2019.
 */

class RegistrationStepOneFragmentPresenter(var registrationStepOneFragmentView: RegistrationStepOneFragmentView?) :
    BasePresenter() {

    override fun onDestory() {
        registrationStepOneFragmentView = null
    }

    fun validatePhoneNumber(phone: String) {
        var validationHelper = ValidationHelper
        if (validationHelper.isPhoneNumberValid(phone)) {
            registrationStepOneFragmentView?.switchToStepTwo()
        } else {
            registrationStepOneFragmentView?.showInvalidPhoneNumberError()
        }
    }
}