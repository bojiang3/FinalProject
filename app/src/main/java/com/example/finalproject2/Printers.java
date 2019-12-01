package com.example.finalproject2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Jenny 1127 start:
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.GoogleMap;
import java.util.Map;
import java.util.HashMap;
import com.google.android.gms.maps.model.LatLngBounds;
//Jenny 1127 end.

//1130;
import android.util.Pair;
//1130.

public class Printers {

    /**
     * Store all the printers' locations(LatLng) and Marker Options.
     * Example1: EH = the LatLng variable (location) of Engineering Hall; EHMarker = the Marker Option variable of Engineering Hall.
     * Example2: IlliniUnion = the LatLng variable (location) of Illini Union; IlliniUnionMarker = the Marker Option variable of Illini Union.
     * Finished by Bojiang Li on 11/27/2019.
     *
     */

    static final Map<String, Pair<LatLng, String>> printerLocationMap = new HashMap<>();


    static final LatLngBounds campusUIUC = new LatLngBounds(new LatLng(38.00, -80), new LatLng(42, -85));

    static final float defaultMarkerColor = BitmapDescriptorFactory.HUE_BLUE;

    static final float clickedMarkerColor = BitmapDescriptorFactory.HUE_RED;


    public static void addPrintersToList() {



        Pair<LatLng, String> ACES = new Pair<>(new LatLng(40.103039, -88.225101),
                " aces-print\\abe-220hp3015\n" +
                "ACES AESB - Rm 220\n" +
                " aces-print\\ACF-BW (virtual)\n" +
                "ACES Library - Lower Level - Academic Computing Facility\n" +
                " aces-print\\ACF-COLOR (virtual)\n" +
                "ACES Library - Lower Level - Academic Computing Facility\n" +
                "<a href=\"http://abcd.efg.com\" target=\"_blank\">http://abcd.efg.com</a>");
        printerLocationMap.put("ACES Library", ACES);

        Pair<LatLng, String> EB = new Pair<>(new LatLng(40.102113, -88.229611), "\n" +
                " ed-file\\ED-25-M506\n" +
                "Black and White | Education Building Room 25\n" +
                " ed-file\\ED-25-S5840\n" +
                "ED 25\n");
        printerLocationMap.put("Education Building", EB);

        Pair<LatLng, String> ECEB = new Pair<>(new LatLng(40.115144, -88.228017), "\n" +
                " engr-print-01\\eceb-C1060-printer\n" +
                " engr-print-02\\eceb-1001-bwd1\n" +
                " engr-print-02\\eceb-1016-bwd\n" +
                " engr-print-02\\eceb-2026-bwd1\n" +
                " engr-print-02\\eceb-2026-color1\n" +
                " engr-print-02\\eceb-2070-bwd1\n" +
                " engr-print-02\\eceb-2076-bwd1\n" +
                " engr-print-02\\eceb-3016-bwd1\n" +
                " engr-print-02\\eceb-3022-bwd1\n" +
                " engr-print-02\\eceb-3070-bwd1\n" +
                " engr-print-02\\eceb-3070-color1\n" +
                " engr-print-02\\eceb-4072-bwd1\n" +
                " engr-print-02\\eceb-4074-bwd1\n" +
                " engr-print-02\\eceb-5072-bwd\n" +
                " engr-print-02\\eceb-5074-bwd1\n" +
                " engr-print-02\\eceb-5076-bwd1\n");
        printerLocationMap.put("Electrical and Computer Engineering Building", ECEB);

        Pair<LatLng, String> EH = new Pair<>(new LatLng(40.111036, -88.226990), "\n" +
                " engr-print-02\\eh-406b1-color1\n" +
                " engr-print-02\\eh-406b1-pool (virtual)\n" +
                " engr-print-02\\eh-406b8-color1\n" +
                " engr-print-02\\eh-406b8-pool (virtual)\n");
        printerLocationMap.put("Engineering Hall", EH);

        Pair<LatLng, String> Everitt = new Pair<>(new LatLng(40.111165, -88.228348), "" +
                "\n" +
                " engr-print-01\\everitt-1126-printer\n" +
                " engr-print-01\\everitt-2201-bw\n" +
                " engr-print-01\\everitt-2240-color\n" +
                " engr-print-01\\everitt-receiving-copier(Everitt 0321)\n");
        printerLocationMap.put("Everitt Laboratory", Everitt);
    }
}
