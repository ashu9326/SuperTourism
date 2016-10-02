package com.example.ashutosh.supertourism;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashutosh.supertourism.model.About;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AboutPlace extends AppCompatActivity {
    int position;
    TextView text;
    ListView listView;
    Context context;
    private PlaceAdapter placeAdapter = new PlaceAdapter();
    ArrayList<About> aboutPlaceArrayList = new ArrayList<About>();
    String place = "{\n" +
            "\"adventure\":[\n" +
            "\n" +
            "{\n" +
            "\"name\": \"Anthargange Trek and Caving\"\n" +
            "\"summary\": \"This Is a beautiful place\"\n" +
            "};\n" +
            "{\n" +
            "\"name\": \"Kunti Betta Trek\"\n" +
            "\"summary\": \"This is a beautiful place\"\n" +
            "};\n" +
            "]\n" +
            "}";

    class PlaceAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return aboutPlaceArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return aboutPlaceArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            About about = (About) aboutPlaceArrayList.get(position);
            View v = getLayoutInflater().inflate(R.layout.about, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textSummary = (TextView) v.findViewById(R.id.textSummary);
           // imageView.setImageResource(Integer.parseInt(about.getImageId()));
           // textSummary.setText(about.getTextSummary());
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_place);
        listView = (ListView) findViewById(R.id.listview);
        aboutPlaceArrayList.addAll(parseJsonDataReturnResponseInArrayList(place));
        listView.setAdapter(placeAdapter);

    }
     private ArrayList<About>parseJsonDataReturnResponseInArrayList(String place)
     {
         ArrayList<About> aboutPlaceArrayList=new ArrayList<>();
         try{
             JSONObject rootObject=new JSONObject(place);
             JSONArray placeArray=rootObject.getJSONArray("adventure");
             for(int i=0;i<placeArray.length();i++)
             {
                 JSONObject obj=(JSONObject)placeArray.get(i);
            // String imageId=placeArray.getString("name");
             String summary=obj.getString("summary");
         }}
         catch (JSONException e)
         {
             e.printStackTrace();
         }
         return aboutPlaceArrayList;
     }
}
