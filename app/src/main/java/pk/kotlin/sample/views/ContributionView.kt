package pk.kotlin.sample.views

/**
 * Created on 02/04/2019.
 */
interface ContributionView {

    fun populateContributorList(contributorType: ArrayList<String>)

    fun switchToDashboard()
    fun errorContribution()
}