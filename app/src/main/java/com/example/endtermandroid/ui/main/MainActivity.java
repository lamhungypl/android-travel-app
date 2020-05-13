package com.example.endtermandroid.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.endtermandroid.R;
import com.example.endtermandroid.ui.about_us.AboutUsFragment;
import com.example.endtermandroid.ui.destination.DestinationFragment;
import com.example.endtermandroid.ui.home.HomeFragment;
import com.example.endtermandroid.ui.login.LoginActivity;
import com.example.endtermandroid.ui.mytrips.MyTripsFragment;
import com.example.endtermandroid.ui.share.ShareFragment;
import com.example.endtermandroid.ui.utilities.UtilitiesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private AppBarConfiguration mAppBarConfiguration;
    SharedPreferences mSharedPref;
    TextView mTextViewEmail;

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //----default-----
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_destinations,
//                R.id.nav_my_trips, R.id.nav_utilities, R.id.nav_about_us, R.id.nav_share, R.id.nav_sign_out)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
        //----default-----


        this.init();

        View headerView = navigationView.getHeaderView(0);
        mTextViewEmail = headerView.findViewById(R.id.textViewEmail);


        String emailStored = mSharedPref.getString("email", "sample@gmail.com");
        mTextViewEmail.setText(emailStored);


//        setupDrawerContent(navigationView);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
//


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
        } else {
            super.onBackPressed();

        }
    }

    public void init() {
        mSharedPref = getSharedPreferences("login", MODE_PRIVATE);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {

            case R.id.nav_home: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;

            }
            case R.id.nav_destinations: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new DestinationFragment()).commit();


                break;

            }
            case R.id.nav_my_trips: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new MyTripsFragment()).commit();
                Toast.makeText(getApplicationContext(), "MyStrip", Toast.LENGTH_SHORT).show();

                break;

            }
            case R.id.nav_utilities: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new UtilitiesFragment()).commit();
                Toast.makeText(getApplicationContext(), "Utilities", Toast.LENGTH_SHORT).show();

                break;

            }
            case R.id.nav_about_us: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new AboutUsFragment()).commit();

                Toast.makeText(getApplicationContext(), "AboutUs", Toast.LENGTH_SHORT).show();

                break;

            }
            case R.id.nav_share: {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ShareFragment()).commit();

                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();

                break;

            }
            case R.id.nav_sign_out: {
                //do something

                Intent i = LoginActivity.getStartIntent(MainActivity.this);
                startActivity(i);

                SharedPreferences.Editor editor = mSharedPref.edit();
                editor.remove("email");
                editor.commit();
                finish();


                break;
            }
        }
        //close navigation drawer
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }


}
