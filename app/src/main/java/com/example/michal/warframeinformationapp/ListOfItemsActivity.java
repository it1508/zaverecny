package com.example.michal.warframeinformationapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOfItemsActivity extends AppCompatActivity {
    ListView itemsListView;
    String[] warframes;
    String[] melee;
    String[] secondary;
    String[] primary;
    String[] companios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);

        Resources res = getResources();
        itemsListView = (ListView) findViewById(R.id.itemsListView);
        warframes = res.getStringArray(R.array.warframes);
        melee = res.getStringArray(R.array.melee);
        secondary = res.getStringArray(R.array.secondary);
        primary = res.getStringArray(R.array.primary);
        companios = res.getStringArray(R.array.companions);

        //ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_ID",-1);
        if(index > -1) {
            switch (index) {
                case 0:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
                    break;
                case 1:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    break;
                case 2:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    break;
                case 3:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    break;
                case 4:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, companios));
                    break;
                default:
                    break;
            }
        }
        //itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
        //ItemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.michal.ITEM", position);
                startActivity(showDetailActivity);
            }
        });
    }
}
