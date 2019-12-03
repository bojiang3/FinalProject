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
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

    /** A class variable to store current location. If GPS access is denied, this variable will keep null. */
    private Location currentLocation;
    //Bojiang 12/1 ends.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //Bojiang 12/1 starts: setup button
        final Button toPrint = findViewById(R.id.toPrint);
        toPrint.setOnClickListener(new View.OnClickListener() {
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

        final ImageButton infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setContentView(R.layout.authorinfo);
            }
        });




    }


    /**
     *
     * @param googleMap the map.
     * Initialize the map, set up the info-window, request the permission for GPS.
     * If GPS permission is not granted, the app will take a point at Illini Union as default center for the first time created.
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
        //Bojiang 11/30 ends. Multi-snippet info-window resolved.

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




        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);

            //Reference: StackOverFlow: https://stackoverflow.com/questions/14502102/zoom-on-current-user-location-displayed/14511032#14511032
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location setLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if (setLocation == null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_COARSE);

                String provider = lm.getBestProvider(criteria, true);

                setLocation = lm.getLastKnownLocation(provider);
            }
            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            currentLocation = setLocation;
        }


        if (currentLocation != null) {

            CameraPosition cameraPosition1 = new CameraPosition.Builder().target(
                    new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude())).zoom(16).build();

            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition1));


        } else {


            CameraPosition cameraPosition2 = new CameraPosition.Builder().target(
                    new LatLng(40.109464, -88.227180)).zoom(15).build();

            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition2));
        }

        //Bojiang 12/1 afternoon ends. Enable getting current location function.

        //Toast when open the app.
        CharSequence text = "Hello";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 1, 1);
        toast.show();

    }


    /**
     * Place the markers for all building with printers. Also add the markers to the list for further uses.
     */
    //Jenny 1127 22:00 start:
    public void placeMarker() { // Suppose position is a LatLng variable

        //Information about the list of printers is added to be stored in "printerLocationMap"
        Printers.addPrintersToList();

        for (Map.Entry<String, Pair<LatLng, String>> entry : Printers.printerLocationMap.entrySet()) {
            //iterate through each printer:

            String printerLocationName = entry.getKey(); //name of the building where the printer is
            LatLng printerLocation = entry.getValue().first; //location of the printer
            String printerInfo = entry.getValue().second;

            //Add a marker to the location of each printer, with title being the building name, and the snippets in info-windows.
            options = new MarkerOptions().position(printerLocation)
                    .title(printerLocationName)
                    .snippet(printerInfo).alpha(0.6f);
            marker = map.addMarker(options);

            //Set the default color of the marker to be blue.
            BitmapDescriptor defaultColor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
            marker.setIcon(defaultColor);

            //Add each marker to "markers", the list of markers.
            markers.add(marker);

        }
    }

    //Jenny 1127 22:00 end.


    /**
     * helper function to detect if GPS request is granted.
     * @param requestCode int 1.
     * @param permissions permission messages.
     * @param grantResults granted results integers.
     */
    //Bojiang: used the reference from Google Developer webpage: https://developers.google.com/maps/documentation/android-sdk/location
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
