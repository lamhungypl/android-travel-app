package com.example.endtermandroid.ui.utilities;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.endtermandroid.R;
import com.example.endtermandroid.ui.utilities.compass.CompassActivity;
import com.example.endtermandroid.ui.utilities.map.MapsActivity;
import com.example.endtermandroid.ui.utilities.map.MapsActivity2;
import com.example.endtermandroid.ui.utilities.timezone.UtilitiesViewModel;
public class UtilitiesFragment extends Fragment {

    private UtilitiesViewModel ultilitiesViewModel;
    private Button buttonCompass;
    private  Button buttonMap;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ultilitiesViewModel =
                ViewModelProviders.of(this).get(UtilitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_utilities, container, false);
        final TextView textView = root.findViewById(R.id.text_utilities);
        ultilitiesViewModel.getText().observe(this, textView::setText);



        buttonCompass = root.findViewById(R.id.button_fragment_compass);
        buttonMap = root.findViewById(R.id.button_fragment_map);

        buttonCompass.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), CompassActivity.class);
            startActivity(i);
        });
        buttonMap.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), MapsActivity2.class);
            startActivity(i);
        });



        return root;
    }




}