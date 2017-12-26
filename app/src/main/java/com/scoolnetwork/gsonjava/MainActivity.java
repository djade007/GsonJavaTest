package com.scoolnetwork.gsonjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String t = "{\"message\":\"Hello man\"}";
//        val data = JSONObject(t)
        Hello r = new Gson().fromJson(t, Hello.class);

        Toast.makeText(this, r.message, Toast.LENGTH_LONG).show();

//        toast(r.toString())
//        toast(data.getString("message"))
    }
}
