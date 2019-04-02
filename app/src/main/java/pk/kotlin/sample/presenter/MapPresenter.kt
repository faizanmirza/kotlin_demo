package pk.kotlin.sample.presenter

import pk.kotlin.sample.managers.FireStoreManager
import pk.kotlin.sample.views.MapView

/**
 * Created on 02/04/2019.
 */

class MapPresenter(var mapView: MapView?) : BasePresenter() {

    override fun onDestory() {
        mapView = null
    }

    fun fetchMapDetails() {
        mapView?.populateMap()
    }
}