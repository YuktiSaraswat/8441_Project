package com.example.hack1;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearByPlacesData extends AsyncTask<Object,String,String>
{
    String googlePlacesData;
    GoogleMap map;
    String url;

    @Override
    protected String doInBackground(Object... objects) {
        map=(GoogleMap)objects[0];
        url=(String)objects[1];
        DownloadUrl downloadUrl=new DownloadUrl();
        try {
            googlePlacesData=downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlacesData;
    }
    @Override
    protected void onPostExecute(String s)
    {
        List<HashMap<String,String>>nearbyPlaceList=null;
        DataParser parser=new DataParser();
        nearbyPlaceList=parser.parse(s);
        showNearByPlaces(nearbyPlaceList);
    }
    private void showNearByPlaces(List<HashMap<String,String>> nearbyPlaceList)
    {
        for(int i=0;i<nearbyPlaceList.size();i++)
        {
            MarkerOptions markerOptions=new MarkerOptions();
            HashMap<String,String>googlePlace=nearbyPlaceList.get(i);

            String placeName=googlePlace.get("place_name");
            String vicinity=googlePlace.get("vicinity");
            double lat=Double.parseDouble( googlePlace.get("lat"));
            double lng=Double.parseDouble( googlePlace.get("lng"));
            LatLng latLng=new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName+":"+vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            map.addMarker(markerOptions);
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            map.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }
}
