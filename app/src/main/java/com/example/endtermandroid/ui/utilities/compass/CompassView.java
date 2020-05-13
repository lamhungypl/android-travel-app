package com.example.endtermandroid.ui.utilities.compass;

import android.view.MenuItem;

public interface CompassView {

    void getAccelerometerSensor();
    void setupCompass();
    void adjustArrow(float azimuth);
    boolean onOptionsItemSelected(MenuItem item);

}
