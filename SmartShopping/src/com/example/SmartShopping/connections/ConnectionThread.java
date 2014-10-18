package com.example.SmartShopping.connections;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.net.URL;

/**
 * Created by Leonardo on 18-Oct-14.
 */
public class ConnectionThread extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        URL url = null;
        JSONObject json = new JSONObject();
        String result = "";
        try {

            json.put("name", "ghanshyam");
            json.put("country", "India");
            json.put("twitter", "ghahhd");

            HttpPost post = new HttpPost(params[0]);
            post.setHeader("Content-type", "application/json");
            post.setEntity(new StringEntity(json.toString(), "UTF-8"));
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse httpresponse = client.execute(post);
            Log.v("Connection Thread", "Response code: " + httpresponse.getStatusLine().getStatusCode());

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            httpresponse.getEntity().writeTo(out);
            out.close();
            result = out.toString();
            Log.v("Connection Thread", result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
