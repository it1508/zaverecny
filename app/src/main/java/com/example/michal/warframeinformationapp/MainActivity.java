package com.example.michal.warframeinformationapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] main_board;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        main_board = res.getStringArray(R.array.main_board);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        //ItemAdapter itemAdapter = new ItemAdapter(this, main_board, prices, descriptions);
        myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, main_board));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showListOfItemsActivity = new Intent(getApplicationContext(), ListOfItemsActivity.class);
                showListOfItemsActivity.putExtra("ITEM_ID",position);
                startActivity(showListOfItemsActivity);
            }
        });
    }
}
