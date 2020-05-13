package com.example.endtermandroid.ui.utilities.compass;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.endtermandroid.R;

import java.util.Objects;

import butterknife.ButterKnife;

public class CompassActivity extends AppCompatActivity implements CompassView {
    private static final String TAG = "CompassActivity";
    ImageView mArrowView;
    private Compass mCompass;
    private float mCurrentAzimuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        mArrowView = findViewById(R.id.compass_image_hands);


        ButterKnife.bind(this);
        setTitle("Compass");
        //not have action bar ???
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Check accelerometer sensor for device
        getAccelerometerSensor();
        //Setup compass
        setupCompass();

    }

    @Override
    public void getAccelerometerSensor() {
        PackageManager mManager = getPackageManager();
        boolean hasAccelerometer = mManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
        boolean hasMagneticSensor = mManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
        if (!hasAccelerometer || !hasMagneticSensor) {
            AlertDialog alertDialog = new AlertDialog.Builder(CompassActivity.this).create();
            alertDialog.setTitle(getResources().getString(R.string.compass_dialog_header));
            alertDialog.setMessage(getResources().getString(R.string.compass_dialog_description));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.compass_dialog_confirm),
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        }
    }

    @Override
    public void setupCompass() {
        mCompass = new Compass(this);
        Compass.CompassListener cl = this::adjustArrow;
        mCompass.setListener(cl);
    }

    @Override
    public void adjustArrow(float azimuth) {
        Log.d(TAG, "will set rotation from " + mCurrentAzimuth + " to "
                + azimuth);
        Animation an = new RotateAnimation(-mCurrentAzimuth, -azimuth,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mCurrentAzimuth = azimuth;
        an.setDuration(500);
        an.setRepeatCount(0);
        an.setFillAfter(true);
        mArrowView.startAnimation(an);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, CompassActivity.class);
        return intent;
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "start compass");
        mCompass.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mCompass.stop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mCompass.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "stop compass");
        mCompass.stop();
    }
}
