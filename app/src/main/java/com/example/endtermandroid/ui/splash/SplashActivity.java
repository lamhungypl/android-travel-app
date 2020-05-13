package com.example.endtermandroid.ui.splash;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.endtermandroid.R;
import com.example.endtermandroid.ui.login.LoginActivity;
import com.example.endtermandroid.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashPresenter {

    SharedPreferences mSharedPref;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSharedPref = getSharedPreferences("login", MODE_PRIVATE);


        final Handler handler = new Handler();

        String userEmail = mSharedPref.getString("email", "");

        handler.postDelayed(() -> {
            if (userEmail.isEmpty()) {
                Intent i = LoginActivity.getStartIntent(SplashActivity.this);
                startActivity(i);
                finish();

            } else {

                Intent i = MainActivity.getStartIntent(SplashActivity.this);
                startActivity(i);
                finish();


            }

        }, 500);


    }

    /**
     * Making the screen wait so that the  branding can be shown
     */
    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    public void startSyncService() {
//        SyncService.start(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void setUp() {

    }
}
