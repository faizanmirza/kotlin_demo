package pk.kotlin.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Venue
import pk.kotlin.sample.presenter.MapPresenter
import pk.kotlin.sample.views.MapView

class MapFragment : Fragment(), OnMapReadyCallback, MapView {

    private val mapPresenter = MapPresenter(this)
    private lateinit var imgLogo: AppCompatImageView
    private var googleMap: GoogleMap? = null
    private lateinit var txtAddress: AppCompatTextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.layoutMap) as SupportMapFragment?
        imgLogo = view.findViewById(R.id.imgLogo)
        txtAddress = view.findViewById(R.id.txtAddress)
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        this.googleMap = googleMap
        onSetupMap(googleMap)
        mapPresenter.fetchMapDetails()
    }

    private fun onSetupMap(googleMap: GoogleMap?) {

        googleMap?.uiSettings?.isZoomControlsEnabled = true
        googleMap?.uiSettings?.isCompassEnabled = true
        googleMap?.uiSettings?.isRotateGesturesEnabled = true
        googleMap?.uiSettings?.isScrollGesturesEnabled = true
    }

    override fun populateMap(venue: Venue?) {

        Picasso.get().load(venue?.imageUrl).into(imgLogo)
        txtAddress.text = venue?.address

        var latLng = LatLng(24.8633741, 67.0747251)
        val zoomLevel = 17.0f

        if (venue?.location != null) latLng =
            LatLng(venue.location.latitude, venue.location.longitude)

        val markerOptions: MarkerOptions = MarkerOptions().position(latLng)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title(venue?.title)

        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }
    }
}