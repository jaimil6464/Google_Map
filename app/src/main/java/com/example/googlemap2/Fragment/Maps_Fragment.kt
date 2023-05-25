package com.example.googlemap2.Fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.googlemap2.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Maps_Fragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val india = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(india).title("Marker in india"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india,16f))
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_maps_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}