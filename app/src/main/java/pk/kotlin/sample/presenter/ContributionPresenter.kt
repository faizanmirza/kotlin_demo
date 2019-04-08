package pk.kotlin.sample.presenter

import android.app.Activity
import pk.kotlin.sample.R
import pk.kotlin.sample.views.ContributionView

/**
 * Created on 02/04/2019.
 */

class ContributionPresenter(var contributionView: ContributionView?) : BasePresenter() {

    override fun onDestory() {
        contributionView = null
    }

    fun getContributionTypeList(activity: Activity) {

        var array = activity.resources.getStringArray(R.array.contributionTypes)
        var list = ArrayList<String>()
        array.toCollection(list)
        contributionView?.populateContributorList(list)
    }

    fun isContributionTypeSelected(itemCount: Int) {

        if (itemCount > 0)
            contributionView?.switchToDashboard()
        else
            contributionView?.errorContribution()
    }
}