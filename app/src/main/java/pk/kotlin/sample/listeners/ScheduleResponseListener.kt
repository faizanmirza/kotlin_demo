package pk.kotlin.sample.listeners

import pk.kotlin.sample.entities.Session

/**
 * Created on 02/04/2019.
 */
interface ScheduleResponseListener {

    fun onScheduleResponseSuccess(sessionList: ArrayList<Session>)
    fun onScheduleResponseFailure()
}