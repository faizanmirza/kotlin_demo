package pk.kotlin.sample.presenter

import pk.kotlin.sample.entities.Speaker
import pk.kotlin.sample.listeners.SpeakerDetailsResponseListener
import pk.kotlin.sample.managers.FireStoreManager
import pk.kotlin.sample.views.ScheduleDetailView

/**
 * Created on 02/04/2019.
 */

class ScheduleDetailPresenter(var scheduleDetailView: ScheduleDetailView?) : BasePresenter(),
    SpeakerDetailsResponseListener {

    override fun onDestory() {
        scheduleDetailView = null
    }

    fun fetchSpeakerDetails(speakerName: String) {
        FireStoreManager.getSpeakerDetails(speakerName, this)
    }

    override fun onSpeakerResponseFailure() {

    }

    override fun onSpeakerResponseSuccess(speaker: Speaker?) {
        scheduleDetailView?.populateSpeakerData(speaker)
    }
}