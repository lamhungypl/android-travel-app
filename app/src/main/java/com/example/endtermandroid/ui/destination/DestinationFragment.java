package com.example.endtermandroid.ui.destination;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.endtermandroid.R;


public class DestinationFragment extends Fragment {

    private DestinationViewModel destinationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        destinationViewModel =
                ViewModelProviders.of(this).get(DestinationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_destination, container, false);
        final TextView textView = root.findViewById(R.id.text_destination);
        destinationViewModel.getText().observe(this, textView::setText);
        return root;
    }
}