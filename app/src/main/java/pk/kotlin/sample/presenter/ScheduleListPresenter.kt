package pk.kotlin.sample.presenter

import pk.kotlin.sample.managers.FireStoreManager
import pk.kotlin.sample.views.OnBoardingStepTwoView
import pk.kotlin.sample.views.ScheduleListView

/**
 * Created on 02/04/2019.
 */

class ScheduleListPresenter(var scheduleListView: ScheduleListView?) : BasePresenter() {

    override fun onDestory() {
        scheduleListView = null
    }

    fun fetchScheduleList() {
        var sessionList = FireStoreManager.getSchedule()
        scheduleListView?.populateList(sessionList)
    }
}