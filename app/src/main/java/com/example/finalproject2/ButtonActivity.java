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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;



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

import com.google.maps.android.SphericalUtil;

public class ButtonActivity extends MapsActivity {

    private static Location tmpLocation = MapsActivity.currentLocation;


    public static String getNearestPrinter() {
        double minDistance = 1000.00;
        String tmpPrinter = "";
        for (Map.Entry<String, Pair<LatLng, String>> entry : Printers.printerLocationMap.entrySet()) {
            //iterate through each printer:

            String printerLocationName = entry.getKey();
            LatLng printerLocation = entry.getValue().first;

            double tmpDistance = com.google.maps.android.SphericalUtil.computeDistanceBetween(new
                            LatLng(tmpLocation.getLatitude(), tmpLocation.getLongitude()),
                    printerLocation);
            if (tmpDistance < minDistance) {
                minDistance = tmpDistance;
                tmpPrinter = printerLocationName;
            }
        }
        return tmpPrinter;
    }



}
