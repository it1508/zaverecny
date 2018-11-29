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


public class ListOfItemsActivity extends AppCompatActivity implements TaskCompleted {
    ListView itemsListView;
    String[] warframes;
    String[] melee;
    String[] secondary;
    String[] primary;
    String[] companios;
    String[] archwing;
     public  String mel = "";
    public static String frame = "";
    public static String sec = "";
    public static String prim = "";
    public static String comp = "";
    public static String arch = "";
    String parse = "";

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
        archwing = res.getStringArray(R.array.archwing);
        JSONFrameparsing warframe = new JSONFrameparsing(ListOfItemsActivity.this);
        JSONArchparsing archwings = new JSONArchparsing();
        JSONMeleeparsing melees = new JSONMeleeparsing();
        JSONSecondparsing secondarys = new JSONSecondparsing();
        JSONPrimaryparsing primarys = new JSONPrimaryparsing();
        JSONCompaparsing companioss = new JSONCompaparsing();
        warframe.execute();
        primarys.execute();
        secondarys.execute();
        melees.execute();
        companioss.execute();

        /*frame = JSONFrameparsing.dataParsed;
        comp = JSONFrameparsing.dataParsed;
        mel = JSONFrameparsing.dataParsed;
        sec = JSONFrameparsing.dataParsed;
        prim = JSONFrameparsing.dataParsed;
        arch = JSONFrameparsing.dataParsed;*/







        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.michal.ITEM", position);
                startActivity(showDetailActivity);
                DetailActivity.data.setText(parse);
            }
        });
    }


    @Override
    public void onTaskComplete(String result) {
        frame = result;
        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_ID",-1);
        if(index > -1) {
            switch (index) {
                case 0:
                    //JSONFrameparsing warframe = new JSONFrameparsing();
                    //warframe.execute();
                    parse = frame + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
                    break;
                case 1:
                    //JSONFrameparsing archwings = new JSONFrameparsing();
                    //archwings.execute();
                    parse = arch + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, archwing));
                    break;
                case 2:
                    //JSONFrameparsing melees = new JSONFrameparsing();
                    //primarys.execute();
                    parse = prim + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    break;
                case 3:
                    //JSONFrameparsing secondarys = new JSONFrameparsing();
                    //secondarys.execute();
                    parse = sec + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    break;
                case 4:
                    //JSONFrameparsing primarys = new JSONFrameparsing();
                    //melees.execute();
                    parse = mel + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    break;
                case 5:
                    //JSONFrameparsing companioss = new JSONFrameparsing();
                    //companioss.execute();
                    parse = comp + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, companios));
                    break;
                default:
                    break;
            }
        }
        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.michal.ITEM", position);
                startActivity(showDetailActivity);
                DetailActivity.data.setText(parse);
            }
        });
    }
}
