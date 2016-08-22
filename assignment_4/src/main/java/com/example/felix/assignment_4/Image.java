package com.example.felix.assignment_4;

/**
 * Created by Felix on 2016-08-16.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Image extends ArrayAdapter<Planets> {
    private Context mContext;
    private ArrayList<Planets> planetList;

    public Image(Context c, ArrayList<Planets> planetList) {
        super(c, 0, planetList);
        mContext = c;
        this.planetList = planetList;
    }


    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageButton imageView;
        Log.i("MyListAdapter", "Called for position: " + position);
        Planets p = planetList.get(position);

        convertView = inflater.inflate(R.layout.grid_fragment,null);


        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_planetpic);

        TextView tv = (TextView) convertView.findViewById(R.id.iv_planetname);

        tv.setText(p.getName());
        iv.setImageDrawable(p.getImage());
        return convertView;
    }
}