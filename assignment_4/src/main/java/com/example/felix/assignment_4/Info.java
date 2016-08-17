package com.example.felix.assignment_4;

import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Info extends DialogFragment implements View.OnClickListener {


    public Info() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getDialog().setTitle(getString(R.string.author_name));

        View v = inflater.inflate(R.layout.fragment_info, container, false);
        v.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Info.this.dismiss();
    }
}

