package pk.kotlin.sample.presenter

import pk.kotlin.sample.views.OnBoardingStepTwoView

/**
 * Created on 02/04/2019.
 */

class OnBoardingStepTwoPresenter(var onBoardingStepTwoView: OnBoardingStepTwoView?) : BasePresenter() {

    override fun onDestory() {
        onBoardingStepTwoView = null
    }

    fun switchToLoginActivity() {
        onBoardingStepTwoView?.startActivity()
    }

    fun setActionListener() {
        onBoardingStepTwoView?.setActionListener()
    }
}
