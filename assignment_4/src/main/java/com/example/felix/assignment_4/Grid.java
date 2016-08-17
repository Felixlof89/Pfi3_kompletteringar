package com.example.felix.assignment_4;

import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Grid extends Fragment {

    public static ArrayList<Planets> planets = new ArrayList<Planets>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        planets.clear();



        Drawable d = getResources().getDrawable(R.drawable.earth);
        planets.add(new Planets(getResources().getString(R.string.earth_name),d,getResources().getString(R.string.earth_description), getResources().getString(R.string.earth_fact)));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planets(getResources().getString(R.string.mars_name),d,getResources().getString(R.string.mars_description), getResources().getString(R.string.mars_fact)));
        d = getResources().getDrawable(R.drawable.jupiter);
        planets.add(new Planets(getResources().getString(R.string.jupiter_name),d,getResources().getString(R.string.jupiter_description), getResources().getString(R.string.jupiter_fact)));
        d = getResources().getDrawable(R.drawable.mercury);
        planets.add(new Planets(getResources().getString(R.string.mercury_name),d,getResources().getString(R.string.mercury_description), getResources().getString(R.string.mercury_fact)));
        d = getResources().getDrawable(R.drawable.neptun);
        planets.add(new Planets(getResources().getString(R.string.neptune_name),d,getResources().getString(R.string.neptune_description), getResources().getString(R.string.neptune_fact)));
        d = getResources().getDrawable(R.drawable.saturn);
        planets.add(new Planets(getResources().getString(R.string.saturn_name),d, getResources().getString(R.string.saturn_description), getResources().getString(R.string.saturn_fact)));
        d = getResources().getDrawable(R.drawable.uranus);
        planets.add(new Planets(getResources().getString(R.string.uranus_name),d,getResources().getString(R.string.uranus_description), getResources().getString(R.string.uranus_fact)));
        d = getResources().getDrawable(R.drawable.venus);
        planets.add(new Planets(getResources().getString(R.string.venus_name),d,getResources().getString(R.string.venus_description), getResources().getString(R.string.venus_fact)));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        Image myImageAdapter = new Image(getActivity(),Planets);
        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(myImageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);
                FragmentManager fm = getFragmentManager();
                Dialog fd = new Dialog();
                Bundle b = new Bundle();
                b.putSerializable("planet", planets.get(position));
                fd.setArguments(b);
                fd.show(fm,"Dialog");

            }
        });
        return view;

    }


}