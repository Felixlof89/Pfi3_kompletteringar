package com.example.felix.uppgift_3.view;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.example.felix.uppgift_3.R;
import com.example.felix.uppgift_3.control.Constants;
import com.example.felix.uppgift_3.model.Journey;
import com.example.felix.uppgift_3.model.Journeys;
import com.example.felix.uppgift_3.xmlparser.Parser;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private ArrayList<Journey> myItems = new ArrayList<Journey>();
    private ExpandableListAdapter myExListAdapter;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFran);
        spinnerTo = (Spinner) view.findViewById(R.id.spinnerTill);


        ExpandableListView ev = (ExpandableListView) view.findViewById(R.id.expandableListView);
        myExListAdapter = new ExpandableListAdapter(getActivity(),myItems);
        ev.setAdapter(myExListAdapter);
        spinnerFrom.setSelection(1);


        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);

        return view;
    }

    ///Listens to menu selection.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {

            int fromStation = spinnerFrom.getSelectedItemPosition();
            int toStation = spinnerTo.getSelectedItemPosition();

            String[] stationNo = getResources().getStringArray(R.array.stationNumbers);
            String searchURL = Constants.getURL(stationNo[fromStation], stationNo[toStation], 14);

            myItems.clear();
            new MyAsyncTask().execute(searchURL);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int fromStation = spinnerFrom.getSelectedItemPosition();
        int toStation = spinnerTo.getSelectedItemPosition();

        String[] stationNo = getResources().getStringArray(R.array.stationNumbers);
        String searchURL = Constants.getURL( stationNo[fromStation], stationNo[toStation], 14);
        new MyAsyncTask().execute(searchURL);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class MyAsyncTask extends AsyncTask<String,Void,Long> {

        @Override
        protected Long doInBackground(String... params) {
            Journeys journeys = Parser.getJourneys(params[0]); //There can be many in the params Array
            //And put the Journeys in our list.
            myItems.clear();
            myItems.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute(Long result) {
            myExListAdapter.notifyDataSetChanged();
            for (Journey si :myItems){
                Log.i("ExpFragment", "moment" + si.getStartStation().getStationName());

            }


        }
    }






}