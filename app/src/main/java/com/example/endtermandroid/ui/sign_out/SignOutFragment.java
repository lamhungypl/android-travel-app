package com.example.endtermandroid.ui.sign_out;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.endtermandroid.R;

public class SignOutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignOutViewModel signOutViewModel = ViewModelProviders.of(this).get(SignOutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sign_out, container, false);
        final TextView textView = root.findViewById(R.id.text_sign_out);
        signOutViewModel.getText().observe(this, textView::setText);
        return root;
    }
}