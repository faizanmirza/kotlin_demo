package pk.kotlin.sample.presenter

import pk.kotlin.sample.views.RegistrationView

/**
 * Created on 02/04/2019.
 */

class RegistrationPresenter(var registrationView: RegistrationView?) : BasePresenter() {

    override fun onDestory() {
        registrationView = null
    }

    fun onClose() {
        registrationView?.finishActivity()
    }
}