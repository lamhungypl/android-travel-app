package com.example.endtermandroid.ui.mytrips;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.endtermandroid.R;

public class MyTripsFragment extends Fragment {

    private MyTripsViewModel myTripsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myTripsViewModel =
                ViewModelProviders.of(this).get(MyTripsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_trips, container, false);
        final TextView textView = root.findViewById(R.id.text_my_trips);
        myTripsViewModel.getText().observe(this, textView::setText);
        return root;
    }
}