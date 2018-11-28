package com.example.michal.warframeinformationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] warframes;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        warframes = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return warframes.length;
    }

    @Override
    public Object getItem(int position) {
        return warframes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_list_view, null);


        return v;
    }
}
