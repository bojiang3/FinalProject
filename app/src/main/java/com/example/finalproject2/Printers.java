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
     * Updated by 12/2/2019.
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
                "ACES Library - Lower Level - Academic Computing Facility\n");
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

        Pair<LatLng, String> Loomis = new Pair<>(new LatLng(40.111223, -88.223324), "\n" +
                " engr-print-02\\lms-271-bwd1\n" +
                " engr-print-02\\lms-279-bwd\n" +
                " engr-print-01\\lms-328-mfp\n" +
                " engr-print-01\\lms320-mfc-printer\n");
        printerLocationMap.put("Loomis Laboratory Of Physics", Loomis);

        Pair<LatLng, String> Siebel = new Pair<>(new LatLng(40.114041, -88.224894), "\n" +
                " engr-print-01\\engrit-siebl-printer (ENGRIT)\n" +
                " engr-print-02\\siebl-0200-pool (virtual)\n" +
                " engr-print-01\\Siebl-2203-printer\n" +
                " engr-print-01\\Siebl-3203-printer\n" +
                " engr-print-01\\siebl-3323-printer\n" +
                " engr-print-01\\siebl-4203-printer\n" +
                " engr-print-01\\Siebl-4323-printer\n");
        printerLocationMap.put("Thomas M. Siebel Center for Computer Science", Siebel);

        Pair<LatLng, String> DCL = new Pair<>(new LatLng(40.113410, -88.226610), "\n" +
                " engr-print-02\\dcl-l426-color1\n" +
                " engr-print-02\\dcl-l426-pool (virtual)\n" +
                " ics-print1\\dcl-atrium-bw\n" +
                " ics-print1\\dcl-atrium-color\n");
        printerLocationMap.put("Digital Computer Laboratory", DCL);

        Pair<LatLng, String> Grainger = new Pair<>(new LatLng(40.112746, -88.226864), "\n" +
                " engr-print-02\\gelib-4c-bwd (virtual)\n" +
                " engr-print-02\\gelib-4c-bwd2\n" +
                " engr-print-02\\gelib-4e-bwd1\n" +
                " engr-print-02\\gelib-4th-color1\n");
        printerLocationMap.put("Grainger Engineering Library", Grainger);

        Pair<LatLng, String> MEL = new Pair<>(new LatLng(40.112004, -88.226157), "\n" +
                " engr-print-02\\mel-1001-bwd1\n" +
                " engr-print-02\\mel-1009-bwd1\n" +
                " engr-print-02\\mel-1009-color1\n");
        printerLocationMap.put("Mechanical Engineering Laboratory", MEL);

        Pair<LatLng, String> NCEB = new Pair<>(new LatLng(40.114272, -88.226003), "\n" +
                " engr-print-02\\nceb-2nd-bwd1 (Yeh Center)\n");
        printerLocationMap.put("Nathan Newmark Civil Engineering Laboratory Yeh Center", NCEB);

        Pair<LatLng, String> Talbot = new Pair<>(new LatLng(40.112041, -88.228316), "\n" +
                " engr-print-02\\tl-131-bwd1\n" +
                " engr-print-02\\tl-131-bwd2\n" +
                " engr-print-02\\tl-321d-bwd1\n" +
                " engr-print-02\\tl-321d-color1\n");
        printerLocationMap.put("Talbot Laboratory", Talbot);

        Pair<LatLng, String> BNAACC = new Pair<>(new LatLng(40.106446, -88.224761), "\n" +
                " ics-print1\\bnaacc-123-bw\n" +
                " ics-print1\\bnaacc-123-color\n");
        printerLocationMap.put("Bruce D. Nesbitt African American Cultural Center", BNAACC);

        Pair<LatLng, String> English = new Pair<>(new LatLng(40.107831, -88.228184), "\n" +
                " ics-print1\\eng-8-bw (virtual)\n" +
                " ics-print1\\eng-8-color (virtual)\n" +
                " Post Printer Available");
        printerLocationMap.put("English Building", English);

        Pair<LatLng, String> LER = new Pair<>(new LatLng(40.105870, -88.231575), "\n" +
                " ics-print1\\ler-6-bw (basement)\n" +
                " ics-print1\\ler-6-color (basement)\n");
        printerLocationMap.put("School of Labor & Employment Relations", LER);

        Pair<LatLng, String> IlliniHall = new Pair<>(new LatLng(40.109768, -88.229276), "\n" +
                " ics-print1\\ih-23-bw\n" +
                " ics-print1\\ih-23-color\n");
        printerLocationMap.put("Illini Hall", IlliniHall);

        Pair<LatLng, String> Nevada = new Pair<>(new LatLng(40.105668, -88.224465), "\n" +
                " ics-print1\\nev-121-bw\n" +
                " ics-print1\\nev-121-color\n");
        printerLocationMap.put("Nevada Building Computer Lab", Nevada);

        Pair<LatLng, String> Oregon = new Pair<>(new LatLng(40.106999, -88.219508), "\n" +
                " ics-print1\\or-104-bw\n" +
                " ics-print1\\or-104-color\n");
        printerLocationMap.put("Oregon Building Computer Lab", Oregon);

        Pair<LatLng, String> UniversityHighSchool = new Pair<>(new LatLng(40.113393, -88.225205), "\n" +
                " ics-print1\\uhs-116\n" +
                " ics-print1\\uhs-201-bw\n" +
                "ics-print1\\uhs-stairwell");
        printerLocationMap.put("University Laboratory High School",UniversityHighSchool);

        Pair<LatLng, String> IlliniUnion = new Pair<>(new LatLng(40.109464, -88.227180), "\n" +
                " ics-print1\\un-040-bw (virtual)\n" +
                " ics-print1\\un-040-color (virtual)\n");
        printerLocationMap.put("Illini Union", IlliniUnion);

        Pair<LatLng, String> WohlersHall = new Pair<>(new LatLng(40.103889, -88.229857), "\n" +
                " ics-print1\\wh-70-bw (virtual)\n" +
                " ics-print1\\wh-70-color (virtual)\n");
        printerLocationMap.put("Wohlers Hall", WohlersHall);

        Pair<LatLng, String> AllenHall = new Pair<>(new LatLng(40.104378, -88.220873), "\n" +
                " ics-print2\\aln-52-bw\n" +
                " ics-print2\\aln-52-color\n" +
                " ics-print2\\aln-c144-bw\n" +
                " ics-print2\\aln-c144-color\n");
        printerLocationMap.put("Allen Hall and Unit One LLC", AllenHall);

        Pair<LatLng, String> Busey = new Pair<>(new LatLng(40.105854, -88.222920), "\n" +
                " ics-print2\\beh-10-bw\n" +
                " ics-print2\\beh-10-color\n" +
                " ics-print2\\beh-l101-bw\n" +
                " ics-print2\\beh-l101-color\nn");
        printerLocationMap.put("Busey Evans Hall", Busey);

        Pair<LatLng, String> Bousfield = new Pair<>(new LatLng(40.102003, -88.237866), "\n" +
                " ics-print2\\bou-1029-bw\n" +
                " ics-print2\\bou-1029-color\n");
        printerLocationMap.put("Bousfield Hall", Bousfield);

        Pair<LatLng, String> ClarkHall = new Pair<>(new LatLng(40.103847, -88.233927), "\n" +
                " ics-print2\\clk-36-bw\n" +
                " ics-print2\\clk-36-color\n");
        printerLocationMap.put("Clark Hall", ClarkHall);

        Pair<LatLng, String> DanielsHall = new Pair<>(new LatLng(40.111014, -88.221669), "\n" +
                " ics-print2\\dan-322-bw\n" +
                " ics-print2\\dan-322-color\n");
        printerLocationMap.put("Daniels Hall", DanielsHall);

        Pair<LatLng, String> FAR = new Pair<>(new LatLng(40.099434, -88.221124), "\n" +
                " ics-print2\\far-9-bw\n" +
                " ics-print2\\far-9-color\n" +
                " ics-print2\\far-c102-bw\n" +
                " ics-print2\\far-c102-color\n");
        printerLocationMap.put("Florida Avenue Residence Hall", FAR);

        Pair<LatLng, String> GoodwinGreen = new Pair<>(new LatLng(40.110004, -88.223632), "\n" +
                " ics-print2\\gng-116-bw\n" +
                " ics-print2\\gng-116-color\n");
        printerLocationMap.put("Goodwin-Green University Apartment", GoodwinGreen);

        Pair<LatLng, String> HopkinsHall = new Pair<>(new LatLng(40.111014, -88.221669), "\n" +
                " ics-print2\\hop-116-bw\n" +
                " ics-print2\\hop-116-color\n");
        printerLocationMap.put("Hopkins Hall", HopkinsHall);

        Pair<LatLng, String> LAR = new Pair<>(new LatLng(40.104330, -88.220336), "\n" +
                " ics-print2\\lar-144-bw\n" +
                " ics-print2\\lar-144-color\n");
        printerLocationMap.put("Lincoln Avenue Residence (LAR)", LAR);

        Pair<LatLng, String> NugentHall = new Pair<>(new LatLng(40.104174, -88.237242), "\n" +
                " ics-print2\\nug-1132-bw\n" +
                " ics-print2\\nug-1132-color\n");
        printerLocationMap.put("Nugent Hall", NugentHall);

        Pair<LatLng, String> OrchardDowns = new Pair<>(new LatLng(40.092415, -88.211066), "\n" +
                " ics-print2\\od-2030a-bw\n" +
                " ics-print2\\od-2030a-color\n");
        printerLocationMap.put("Orchard Downs Apartment", OrchardDowns);

        Pair<LatLng, String> PAR = new Pair<>(new LatLng(40.099958, -88.220789), "\n" +
                " ics-print2\\par-104a-bw (virtual)\n" +
                " ics-print2\\par-104a-color (virtual)\n");
        printerLocationMap.put("Pennsylvania Avenue Residence", PAR);

        Pair<LatLng, String> ScottHall = new Pair<>(new LatLng(40.102245, -88.236704), "\n" +
                " ics-print2\\sct-116-bw\n" +
                " ics-print2\\sct-116-color\n");
        printerLocationMap.put("Scott Hall", ScottHall);

        Pair<LatLng, String> Ikenberrysdrp = new Pair<>(new LatLng(40.104175, -88.235481), "\n" +
                " ics-print2\\sdrp-1010-bw (virtual)\n" +
                " ics-print2\\sdrp-1010-color (virtual)\n" +
                " ics-print2\\sdrp-2010-bw\n" +
                " ics-print2\\sdrp-2010-color\n");
        printerLocationMap.put("Ikenberry Student Dining and Residential Programs Building", Ikenberrysdrp);

        Pair<LatLng, String> ShermanHall = new Pair<>(new LatLng(40.107274, -88.232328), "\n" +
                " ics-print2\\shm-40-bw (virtual)\n" +
                " ics-print2\\shm-40-color (virtual)\n");
        printerLocationMap.put("Sherman Hall", ShermanHall);

        Pair<LatLng, String> SnyderHall = new Pair<>(new LatLng(40.102328, -88.235094), "\n" +
                " ics-print2\\sny-116-bw\n" +
                " ics-print2\\sny-116-color\n");
        printerLocationMap.put("Snyder Hall", SnyderHall);

        Pair<LatLng, String> TreleaseHall = new Pair<>(new LatLng(40.099119, -88.220352), "\n" +
                " ics-print2\\tre-231-bw\n" +
                " ics-print2\\tre-331-bw\n");
        printerLocationMap.put("Trelease Hall(FAR)", TreleaseHall);

        Pair<LatLng, String> TaftHall = new Pair<>(new LatLng(40.102002, -88.233655), "\n" +
                " ics-print2\\tvd-1-bw\n" +
                " ics-print2\\tvd-1-color\n");
        printerLocationMap.put("Taft-Van Doren Residence Halls", TaftHall);

        Pair<LatLng, String> WassajaHall = new Pair<>(new LatLng(40.103946, -88.238104), "\n" +
                " ics-print2\\was-1101-bw\n" +
                " ics-print2\\was-1101-color\n");
        printerLocationMap.put("Wassaja Hall", WassajaHall);

        Pair<LatLng, String> WardallHall = new Pair<>(new LatLng(40.109676, -88.221744), "\n" +
                " ics-print2\\\\wr-102-bw\\n\" +\n" +
                " ics-print2\\\\wr-102-color\\n");
        printerLocationMap.put("Wardall Hall(ISR)", WardallHall);

        Pair<LatLng, String> WestonHall = new Pair<>(new LatLng(40.103307, -88.235408), "\n" +
                " ics-print2\\wsh-176-bw\n" +
                " ics-print2\\wsh-176-color\n");
        printerLocationMap.put("Weston Hall(Ike)", WestonHall);

        Pair<LatLng, String> Ischool = new Pair<>(new LatLng(40.107768, -88.231478), "\n" +
                " ischoolprint\\optimus");
        printerLocationMap.put("ischool(Library and Information Science Building)", Ischool);

        Pair<LatLng, String> VetMed = new Pair<>(new LatLng(40.092901, -88.220400), "\n" +
                " vetprint\\Students2");
        printerLocationMap.put("Vet-Med(Basic Science Building)", VetMed);

        /**
         * Some printer locations are not listed in U of I printing system. Following are added manually
         * according to the actual printer locations.
         */
        Pair<LatLng, String> UGL = new Pair<>(new LatLng(40.104886, -88.227178), "\n" +
                " UGL printer-bw @Upper Level\n" +
                " UGL printer-color @Upper Level\n");
        printerLocationMap.put("Undergraduate Library", UGL);
    }
}
