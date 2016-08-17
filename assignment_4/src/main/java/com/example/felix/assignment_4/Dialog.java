package com.example.felix.assignment_4;


import android.app.FragmentManager;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Dialog extends DialogFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



                View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        Planets p = (Planets) getArguments().getSerializable("planet");
        ImageView iv = (ImageView) v.findViewById(R.id.planetsFactImage);
        iv.setImageDrawable(p.getImage());

        TextView descriptionView = (TextView) v.findViewById(R.id.factDescription);
        descriptionView.setText(p.getSummary());

        TextView factView = (TextView) v.findViewById((R.id.fun_fact));
        factView.setText(p.getFact());

        getDialog().setTitle(p.getName());

        v.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentDialog.this.dismiss();
    }
}