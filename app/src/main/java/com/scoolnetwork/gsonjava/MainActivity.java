package com.scoolnetwork.gsonjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.get("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=06fc0d14f0ae25c074f270637001454b")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray lists = response.getJSONArray("list");
                            for(int i = 0; i < lists.length(); i++) {
                                JSONObject list = lists.getJSONObject(i);
                                JSONObject main = list.getJSONObject("main");
                                Double temp = main.getDouble("temp");
                                Toast.makeText(getApplicationContext(), temp.toString(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
