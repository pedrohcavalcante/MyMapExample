package com.example.androidbti.mymapexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap map;
    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.texto);

        SupportMapFragment mapFragment= (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map2);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
/*        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        map.moveCamera(update);

        CameraPosition position = map.getCameraPosition();
        editText.setText(position.toString());*/

        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(latLng).zoom(8).bearing(180).tilt(30);

        CameraPosition pos = builder.build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);

        map.animateCamera(update);



    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        map.animateCamera(update);
    }
}
