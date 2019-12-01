package com.example.finalproject2;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

//Jenny 1127 22:10 start:
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//Jenny 1127 22:10 end.

//Jenny 1128 start:
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//Jenny 1128 end.

//1130 21:00 start:
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;

import org.w3c.dom.Text;
//1130 21:00 end.

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;




public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {
    private GoogleMap map;

    //Jenny 1127 22:10 start:
    /** Create a MarkerOptions object to specify where we want the marker. */
    private MarkerOptions options;

    /** Add it to the map - Google Maps gives us the created Marker. */
    private Marker marker;

    /** The list of Markers that mark the printers. */
    private List<Marker> markers = new ArrayList();
    //Jenny 1127 22:10 end.

    private Location currentLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //Bojiang 12/1 starts: setup button
        final Button button = findViewById(R.id.toPrint);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "https://papercut.ics.illinois.edu:8443/user";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        final EditText inputLocation = findViewById(R.id.inputLocation);
        String input = inputLocation.getText().toString();

        //Bojiang 12/1 ends.





    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        //Jenny 1127 22:00 start:
        placeMarker();
        //Jenny 1127 22:00 end.


        //Bojiang 11/30 start:
        // Reference: Stackoverflow
        // https://stackoverflow.com/questions/13904651/android-google-maps-v2-how-to-add-marker-with-multiline-snippet
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(getApplicationContext());
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(getApplicationContext());
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(getApplicationContext());
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });
        //Bojiang 11/30 ends. Multi-snippet infowindow resolved.

        //Bojiang 12/1 2:23 am starts. Create button and set onclicklistener.
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setAllGesturesEnabled(true);
        map.getUiSettings().setCompassEnabled(true);

        //Bojiang 12/1 ends.

        //Bojiang 12/1 afternoon starts.
        boolean success = map.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json)));

        if (!success) {
            Log.e("1", "Style parsing failed.");
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            Toast.makeText(this, R.string.title_activity_maps, Toast.LENGTH_LONG).show();
        }

        map.moveCamera(CameraUpdateFactory.zoomTo(15));


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);

            //Reference: StackOverFlow: https://stackoverflow.com/questions/14502102/zoom-on-current-user-location-displayed/14511032#14511032
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);


            if (myLocation == null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_COARSE);

                String provider = lm.getBestProvider(criteria, true);

                myLocation = lm.getLastKnownLocation(provider);
            }
            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            currentLocation = myLocation;
        }



        if (currentLocation != null) {
            LatLng tmp = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

            map.moveCamera(CameraUpdateFactory.newLatLng(tmp));
        } else {
            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.103039, -88.225101)));
        }



        //Bojiang 12/1 afternoon ends. Enable getting current location function.

    }



    //Jenny 1127 22:00 start:
    public void placeMarker() { // Suppose position is a LatLng variable

        //Information about the list of printers is added to be stored in "printerLocationMap"
        Printers.addPrintersToList();

        for (Map.Entry<String, Pair<LatLng, String>> entry : Printers.printerLocationMap.entrySet()) {
            //iterate through each printer:

            String printerLocationName = entry.getKey(); //name of the building where the printer is
            LatLng printerLocation = entry.getValue().first; //location of the printer
            String printerInfo = entry.getValue().second;

            //Add a marker to the location of each printer, with title being the building name.
            options = new MarkerOptions().position(printerLocation)
                    .title(printerLocationName)
                    .snippet(printerInfo);
            marker = map.addMarker(options);

            //Set the default color of the marker to be blue.
            BitmapDescriptor defaultColor = BitmapDescriptorFactory.defaultMarker(Printers.defaultMarkerColor);
            marker.setIcon(defaultColor);

            //Add each marker to "markers", the list of markers.
            markers.add(marker);

        }
    }

    //Jenny 1127 22:00 end.




    //Bojiang used the reference from Google Developer webpage: https://developers.google.com/maps/documentation/android-sdk/location
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        if (requestCode == 1) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
        map.setMyLocationEnabled(true);
    }

}
