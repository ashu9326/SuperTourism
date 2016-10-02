package com.example.ashutosh.supertourism;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class TourType extends AppCompatActivity {


    private ListView listViewTourType;
    Toolbar toolbar;
    //Data Source
    private String[] typeOfTour = new String[]{"Adventure", "Ecotourism", "Historical", "Industrial Tourism", "Religious Tourism"};
    private ArrayAdapter<String> arrayAdapterTypeOfTour;
    ArrayList<String> arrayListTypeOfTour = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_type);
        listViewTourType = (ListView) findViewById(R.id.listview_tour_type);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Build array list
        arrayListTypeOfTour.add(typeOfTour[0]);
        arrayListTypeOfTour.add(typeOfTour[1]);
        arrayListTypeOfTour.add(typeOfTour[2]);
        arrayListTypeOfTour.add(typeOfTour[3]);
        arrayListTypeOfTour.add(typeOfTour[4]);

        //Initialliziing adapter and attaching data source

        arrayAdapterTypeOfTour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListTypeOfTour);

        //Attaching the adapter to the listview (destination)
        listViewTourType.setAdapter(arrayAdapterTypeOfTour);
        listViewTourType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TourType.this, TourismPlace.class);
                intent.putExtra("typeOfTour", typeOfTour[position]);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

    }

}
