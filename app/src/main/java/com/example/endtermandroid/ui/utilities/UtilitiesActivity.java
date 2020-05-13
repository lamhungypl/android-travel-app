package com.example.endtermandroid.ui.utilities.timezone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bumptech.glide.util.Util;
import com.example.endtermandroid.R;
import com.example.endtermandroid.ui.utilities.compass.CompassActivity;
import com.example.endtermandroid.ui.utilities.map.MapsActivity;
import com.example.endtermandroid.ui.utilities.map.MapsActivity2;


public class UtilitiesActivity extends AppCompatActivity {
    private Button mButtonCompass;
    private Button mButtonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultilities);
        init();

        mButtonCompass.setOnClickListener(v -> {
            Intent i = new Intent(UtilitiesActivity.this, CompassActivity.class);
            startActivity(i);
        });
        mButtonMap.setOnClickListener(v -> {
            Intent i = new Intent(UtilitiesActivity.this, MapsActivity2.class);
            startActivity(i);
        });
    }
    public void init(){
        mButtonCompass = findViewById(R.id.button_fragment_compass);
        mButtonMap = findViewById(R.id.button_fragment_map);
    }
}
