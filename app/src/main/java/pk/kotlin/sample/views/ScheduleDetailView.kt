package pk.kotlin.sample.views

import pk.kotlin.sample.entities.Speaker

/**
 * Created on 02/04/2019.
 */
interface ScheduleDetailView {

    fun populateSpeakerData(speaker: Speaker?)

}