package pk.kotlin.sample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pk.kotlin.sample.R

class MapFragment : Fragment(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.layoutMap) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        this.googleMap = googleMap
        onSetupMap(googleMap)

        val latLng = LatLng(24.8633741, 67.0747251)
        val markerOptions: MarkerOptions = MarkerOptions().position(latLng)
        val zoomLevel = 15.0f //This goes up to 21

        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }
    }

    private fun onSetupMap(googleMap: GoogleMap?) {

        googleMap?.uiSettings?.isZoomControlsEnabled = true
        googleMap?.uiSettings?.isCompassEnabled = true
        googleMap?.uiSettings?.isRotateGesturesEnabled = true
        googleMap?.uiSettings?.isScrollGesturesEnabled = true
    }
}