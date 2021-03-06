package com.example.SmartShopping.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.SmartShopping.R;
import com.example.SmartShopping.connections.ConnectionThread;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HomeActivity extends Activity {

    private final String FILENAME = "log.txt";
    private final String urlAddress = "http://10.0.186.221:8080/ShoppingAssistantWS/entryServ/send";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button shoppingButton = (Button) this.findViewById(R.id.shopped);
        Button boughtButton = (Button) this.findViewById(R.id.bought);
        Button aboutButton = (Button) this.findViewById(R.id.help);

       // addButton.setTypeface(font);
        shoppingButton.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shoppingIntent = new Intent(HomeActivity.this, ShoppingActivity.class);
                HomeActivity.this.startActivityForResult(shoppingIntent, 1);

            }
        });

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void writeInfo(){

        OutputStream fos = null;
        try {
            fos = getBaseContext().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (Exception e) {
            Toast.makeText(HomeActivity.this, "Error saving", Toast.LENGTH_LONG).show();
        }
    }


}
