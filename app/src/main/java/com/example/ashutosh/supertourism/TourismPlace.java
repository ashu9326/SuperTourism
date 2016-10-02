package com.example.ashutosh.supertourism;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashutosh.supertourism.model.Place;

import java.util.ArrayList;


public class TourismPlace extends AppCompatActivity {
    ListView listViewTourPlace;
    TextView text;
    int position;
    private ArrayList<Place> placeArrayList = new ArrayList<>();
    private String[] Adventure = {"Sky Diving", "Dirt Bike Racing", "Skuba Diving"};
    private int[] adventureImages = {R.mipmap.adventur1, R.mipmap.adventure2, R.mipmap.adventure3};
    private String[] Ecotourism = {"Agumbe", "Shimoga Or Shivamogga"};
    private ArrayAdapter<String> arrayAdapterTourPlace;
    private ArrayList<String> arrayListTourPlaceName = new ArrayList<>();
    FloatingActionButton floatingActionButton;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_place);
        listViewTourPlace = (ListView) findViewById(R.id.listViewPlaces);
        text = (TextView) findViewById(R.id.textView);
        ///insert intent code
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TourismPlace.this, AddNewPlace.class);
                startActivity(intent);
               /* Snackbar snackbar = Snackbar.make(v, "Add New Places", Snackbar.LENGTH_LONG);
                snackbar.setAction("Add", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Snackbar.make(v, "Add New Place", Snackbar.LENGTH_LONG).show();
                        Intent intent=new Intent(TourismPlace.this,AddNewPlace.class);
                        startActivity(intent);
                    }
                });

                View snackbarLayout = snackbar.getView();
                snackbarLayout.setBackgroundColor(Color.WHITE);

                TextView textView = (TextView) snackbarLayout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                //snackbar.setActionTextColor(Color.BLUE);

                Button button = (Button) snackbarLayout.findViewById(android.support.design.R.id.snackbar_action);
                button.setTextColor(Color.BLACK);

                snackbar.show();*/
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("position");

        myAdapter = new MyAdapter();

        text.setText("" + position);

        switch (position) {
            case 0:
                addDataToArrayList(Adventure, adventureImages,"Adventure" );
                //arrayListTourPlaceName.add(Adventure[0]);
                //arrayListTourPlaceName.add(Adventure[1]);
                //arrayAdapterTourPlace = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Adventure);
                listViewTourPlace.setAdapter(myAdapter);
                listViewTourPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(TourismPlace.this, AboutPlace.class);

                        intent.putExtra("Adventure", Adventure[position]);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                });
                break;

            case 1:
                arrayListTourPlaceName.add(Ecotourism[0]);
                arrayListTourPlaceName.add(Ecotourism[1]);
                arrayAdapterTourPlace = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ecotourism);
                listViewTourPlace.setAdapter(arrayAdapterTourPlace);
                listViewTourPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(TourismPlace.this, AboutPlace.class);

                        intent.putExtra("Ecotourism", Ecotourism[position]);
                        intent.putExtra("position", position);

                        startActivity(intent);
                    }
                });
                break;
        }

    }

    private void addDataToArrayList(String[] placeNames, int[] imageNames, String type) {
        for (int i = 0; i < placeNames.length; i++) {

            Place p = new Place(type, placeNames[i],imageNames[i] );
            placeArrayList.add(p);
        }
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return placeArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return placeArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.place_row, parent, false);

            Place p = placeArrayList.get(position);

            TextView textViewPlace = (TextView) view.findViewById(R.id.place_text);
            ImageView imageView = (ImageView) view.findViewById(R.id.place_image);

            textViewPlace.setText(p.getName());
            imageView.setImageResource(p.getImageLocation());

            return view;
        }
    }
}



