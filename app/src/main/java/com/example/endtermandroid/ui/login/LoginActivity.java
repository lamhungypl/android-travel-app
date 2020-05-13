package com.example.endtermandroid.ui.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.endtermandroid.R;
import com.example.endtermandroid.object.ViewDialog;
import com.example.endtermandroid.ui.main.MainActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private ViewDialog viewDialog;
    SharedPreferences mSharedPref;
    EditText mEmailEditText;

    EditText mPasswordEditText;

    Button mButtonLogin;

    ImageButton mButtonGoogleLogin;
    ImageButton mButtonFacebookLogin;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        getPermissions();

    }

    void init() {
        viewDialog = new ViewDialog(this);

        mSharedPref = getSharedPreferences("login", MODE_PRIVATE);


        mEmailEditText = findViewById(R.id.et_email);
        mPasswordEditText = findViewById(R.id.et_password);
        mButtonLogin = findViewById(R.id.btn_login);
        mButtonGoogleLogin = findViewById(R.id.btn_google_login);
        mButtonFacebookLogin = findViewById(R.id.btn_fb_login);

        mButtonLogin.setOnClickListener(view -> {
            String emailValue = mEmailEditText.getText().toString();
            String passValue = mPasswordEditText.getText().toString();
            this.emuSplat(emailValue, passValue);
        });
        mButtonGoogleLogin.setOnClickListener(view -> {
            String email = "lamhungypl@gmail.com";
            this.emuSplat(email);
        });
        mButtonFacebookLogin.setOnClickListener(view -> {
            String email = "lamhungypl@facebook.com";

            this.emuSplat(email);
        });

    }


    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }


    @Override
    public void rememberUserInfo(String email) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString("email", email);
        editor.apply();
    }


    @Override
    public void onLoginClick(String email, String password) {

    }

    @Override
    public void onGoogleLoginClick() {

    }

    @Override
    public void onFacebookLoginClick() {

    }


    @Override
    public void showLoading() {
        viewDialog.showDialog();

    }

    @Override
    public void dismissLoading() {
        viewDialog.hideDialog();
    }

    @Override
    public void emuSplat(String email, String password) {
        this.showLoading();
        final Handler handler = new Handler();

        handler.postDelayed(() -> {
//            String emailValue = mEmailEditText.getText().toString();
//            String passValue = mPasswordEditText.getText().toString();
            if (validateEmail(email) && validatePassword(password)) {
                this.rememberUserInfo(email);
                this.openMainActivity();
            }
            this.dismissLoading();
        }, 2000);
    }

    public void emuSplat(String email) {
        this.showLoading();
        final Handler handler = new Handler();

        handler.postDelayed(() -> {
            this.rememberUserInfo(email);
            this.openMainActivity();
            this.dismissLoading();
        }, 2000);
    }

    @Override
    public void getPermissions() {
        if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CAMERA)) {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.BLUETOOTH,
                    Manifest.permission.BLUETOOTH_ADMIN,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WAKE_LOCK,
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.VIBRATE,
            }, 0);
        }

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public boolean validateEmail(String email) {
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(email);
        if (!email.equals("") && matcher.matches()) {
            Toast.makeText(this, "Wellcome", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean validatePassword(String password) {
        if (password.length() >= 1) {
            return true;
        }
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "More character", Snackbar.LENGTH_LONG);
        snackbar.show();
        return false;
    }


}
