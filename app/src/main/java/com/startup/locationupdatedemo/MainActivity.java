package com.startup.locationupdatedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationUpdateListener {

    private TextView tvLatLong;
    public static MainActivity mainActivity;
    private StringBuilder builder = new StringBuilder();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        setContentView(R.layout.activity_main);
        tvLatLong = findViewById(R.id.tv_lat_long);
        startService(new Intent(this, LocationService.class));
    }

    @Override
    public void locationUpdate(double latitude, double longitude) {

        builder.append(latitude + "," + longitude + "\n");
        tvLatLong.setText(builder.toString());
        tvLatLong.setMovementMethod(new ScrollingMovementMethod());
    }
}
