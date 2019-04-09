package pk.kotlin.sample.presenter

import pk.kotlin.sample.entities.Venue
import pk.kotlin.sample.listeners.VenueDetailsResponseListener
import pk.kotlin.sample.managers.FireStoreManager
import pk.kotlin.sample.views.MapView

/**
 * Created on 02/04/2019.
 */

class MapPresenter(var mapView: MapView?) : BasePresenter(), VenueDetailsResponseListener {

    override fun onDestory() {
        mapView = null
    }

    fun fetchMapDetails() {
        FireStoreManager.getVenueDetails(this)
    }

    override fun onVenueResponseFailure() {
        mapView?.populateMap(null)
    }

    override fun onVenueResponseSuccess(venue: Venue?) {
        mapView?.populateMap(venue)
    }
}