package pk.kotlin.sample.presenter

import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.listeners.ScheduleResponseListener
import pk.kotlin.sample.managers.FireStoreManager
import pk.kotlin.sample.views.ScheduleListView

/**
 * Created on 02/04/2019.
 */

class ScheduleListPresenter(var scheduleListView: ScheduleListView?) : BasePresenter(), ScheduleResponseListener {

    override fun onDestory() {
        scheduleListView = null
    }

    fun fetchScheduleList() {
        FireStoreManager.getSchedule(this)
    }

    override fun onScheduleResponseSuccess(sessionList: ArrayList<Session>) {
        if (sessionList.size > 0)
            scheduleListView?.populateList(sessionList)
        else
            scheduleListView?.showNoScheduleMessage()
    }

    override fun onScheduleResponseFailure() {
        scheduleListView?.showNoScheduleMessage()
    }
}