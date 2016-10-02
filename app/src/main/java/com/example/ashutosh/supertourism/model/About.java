package com.example.ashutosh.supertourism.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashutosh.supertourism.AboutPlace;
import com.example.ashutosh.supertourism.R;

/**
 * Created by Ashutosh on 22-09-2016.
 */
public class About {
private String summary;
    public About(String summary)
    {
        this.summary=summary;
    }
    public String getSummary()
    {
        return summary;
    }

}

