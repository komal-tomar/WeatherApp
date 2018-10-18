package com.example.sai.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Queue;

import javax.xml.namespace.QName;

import static com.example.sai.weatherapp.R.id.userList;

public class MainActivity extends AppCompatActivity {
    private static final String URl;

    static {
        URl = "https://samples.openweathermap.org/data/2.5/forecast?q=Indore,in&appid=b6907d289e10d714a6e88b30761fae22";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        final RecyclerView userList =(RecyclerView)findViewById (R.id.userList);
        userList.setLayoutManager (new LinearLayoutManager (this));


        StringRequest request = new StringRequest (URl, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                Log.d ("CODE",response);
                GsonBuilder gsonBuilder = new GsonBuilder ();
                Gson gson = gsonBuilder.create ();
                User[] users = gson.fromJson (response, User[].class);
                userList.setAdapter (new WeatherAdapter (MainActivity.this,users));
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText (MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show ();
            }
        });

        RequestQueue queue = Volley.newRequestQueue (this);
        queue.add (request);
    }
}
