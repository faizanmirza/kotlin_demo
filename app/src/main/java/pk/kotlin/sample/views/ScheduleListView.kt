package pk.kotlin.sample.views

import pk.kotlin.sample.entities.Session

/**
 * Created on 02/04/2019.
 */
interface ScheduleListView {

    fun populateList(sessionList: ArrayList<Session>)

    fun showNoScheduleMessage()
}