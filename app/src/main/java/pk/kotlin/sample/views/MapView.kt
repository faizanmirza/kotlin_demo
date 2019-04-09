package pk.kotlin.sample.views

import pk.kotlin.sample.entities.Venue

/**
 * Created on 02/04/2019.
 */
interface MapView {

    fun populateMap(venue: Venue?)
}