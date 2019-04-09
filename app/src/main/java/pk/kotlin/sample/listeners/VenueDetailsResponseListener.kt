package pk.kotlin.sample.listeners

import pk.kotlin.sample.entities.Venue

/**
 * Created on 02/04/2019.
 */
interface VenueDetailsResponseListener {

    fun onVenueResponseSuccess(venue: Venue?)
    fun onVenueResponseFailure()
}