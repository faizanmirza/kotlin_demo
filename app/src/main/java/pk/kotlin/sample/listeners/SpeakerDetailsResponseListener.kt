package pk.kotlin.sample.listeners

import pk.kotlin.sample.entities.Speaker

/**
 * Created on 02/04/2019.
 */
interface SpeakerDetailsResponseListener {

    fun onSpeakerResponseSuccess(speaker: Speaker?)
    fun onSpeakerResponseFailure()
}