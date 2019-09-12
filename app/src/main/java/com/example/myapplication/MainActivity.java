package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.esri.android.map.MapView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.esri.android.map.MapOptions;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.android.map.ogc.WMSLayer;
import com.esri.android.map.ogc.WMSLayerInfo;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.android.runtime.ArcGISRuntime.License;
import com.esri.android.map.ogc.WMSLayer;
import com.esri.core.io.OnSelfSignedCertificateListener;
import com.esri.core.io.SelfSignedCertificateHandler;
import com.esri.core.io.UserCredentials;
import com.esri.core.tasks.ags.geoprocessing.Geoprocessor;

import java.security.cert.X509Certificate;

public class MainActivity extends AppCompatActivity {
    Point cpoint = new Point(57.1630758, -2.07151918);
  //  MapView mMapView = null;
    String wmsURL= "https://digimap.edina.ac.uk/mapproxy/wms/marine-licensed/ba8fb3c71d88497dfad791633238b0c6091c2a5e99d531079f30c1e8906fdddb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       // Toolbar toolbar = findViewById(R.id.toolbar);
      //  MapView mMapView = findViewById(R.id.map);
      //  MapOptions topo = new MapOptions(MapOptions.MapType.TOPO, 57.1630758, -2.0715198, 9);

// Set listener to handle self-signed certificate
        SelfSignedCertificateHandler.setOnSelfSignedCertificateListener(
                new OnSelfSignedCertificateListener() {
                    public boolean checkServerTrusted(X509Certificate[] chain, String authType) {
                      return true;
                    }
                });
        WMSLayer wmsLayer = new WMSLayer(wmsURL);
      // mMapView.removeAll();
      //mMapView.addLayer(wmsLayer);
      //MapView mv = new MapView(this, topo);
        MapView mv = new MapView(this);
      mv.zoomToScale(cpoint, 1000000 );

        mv.addLayer(wmsLayer);
       setContentView(mv);
        //setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
