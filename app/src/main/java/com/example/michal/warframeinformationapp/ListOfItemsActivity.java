package com.example.michal.warframeinformationapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ListOfItemsActivity extends AppCompatActivity /*implements TaskCompleted*/ {
    private String TAG = MainActivity.class.getSimpleName();
    private ListView itemsListView;
    ArrayList<HashMap<String, String>> contactList;
    String[] warframes;
    String[] melee;
    String[] secondary;
    String[] primary;
    String[] companios;
    String[] archwing;
    String mel = "";
    //String frame[];
    ArrayList<String> frame = new ArrayList<String>();
    ArrayList<String> shields = new ArrayList<String>();
    ArrayList<String> healts = new ArrayList<String>();
    ArrayList<String> mrs = new ArrayList<String>();
    ArrayList<String> speeds = new ArrayList<String>();
    ArrayList<String> armors = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> locations = new ArrayList<String>();
    ArrayList<String> powers = new ArrayList<String>();
    ArrayList<String> polarities = new ArrayList<String>();
    String sec = "";
    String prim = "";
    String comp = "";
    String arch = "";
    String parse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);

        contactList = new ArrayList<>();
        itemsListView = (ListView) findViewById(R.id.itemsListView);
        new GetContacts().execute();
        Resources res = getResources();
        itemsListView = (ListView) findViewById(R.id.itemsListView);
        warframes = res.getStringArray(R.array.warframes);
        melee = res.getStringArray(R.array.melee);
        secondary = res.getStringArray(R.array.secondary);
        primary = res.getStringArray(R.array.primary);
        companios = res.getStringArray(R.array.companions);
        archwing = res.getStringArray(R.array.archwing);
        //JSONFrameparsing warframe = new JSONFrameparsing(ListOfItemsActivity.this);
        /*JSONArchparsing archwings = new JSONArchparsing();
        JSONMeleeparsing melees = new JSONMeleeparsing();
        JSONSecondparsing secondarys = new JSONSecondparsing();*/
        //JSONFrameparsing primarys = new JSONFrameparsing();
        //JSONCompaparsing companioss = new JSONCompaparsing();
        //warframe.execute();
        //primarys.execute();
        //secondarys.execute();
        //melees.execute();
        //companioss.execute();

        /*frame = JSONFrameparsing.dataParsed;
        comp = JSONFrameparsing.dataParsed;
        mel = JSONFrameparsing.dataParsed;
        sec = JSONFrameparsing.dataParsed;
        prim = JSONFrameparsing.dataParsed;
        arch = JSONFrameparsing.dataParsed;*/

        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_ID", -1);
        if (index > -1) {
            switch (index) {
                case 0:
                    //JSONFrameparsing warframe = new JSONFrameparsing();
                    //warframe.execute();
                    //parse = frame + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
                    break;
                case 1:
                    //JSONFrameparsing archwings = new JSONFrameparsing();
                    //archwings.execute();
                    //parse = arch + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, archwing));
                    break;
                case 2:
                    //JSONFrameparsing melees = new JSONFrameparsing();
                    //primarys.execute();
                    //parse = prim + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    break;
                case 3:
                    //JSONFrameparsing secondarys = new JSONFrameparsing();
                    //secondarys.execute();
                    //parse = sec + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    break;
                case 4:
                    //JSONFrameparsing primarys = new JSONFrameparsing();
                    //melees.execute();
                    //parse = mel + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    break;
                case 5:
                    //JSONFrameparsing companioss = new JSONFrameparsing();
                    //companioss.execute();
                    //parse = comp + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, companios));
                    break;
                default:
                    break;
            }
        }


    }

    private class GetContacts extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ListOfItemsActivity.this,"JSON Data is downloading",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            Intent in = getIntent();
            int index = in.getIntExtra("ITEM_ID", -1);
            if (index > -1) {
                switch (index) {
                    case 0:
                        String url = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr = sh.makeServiceCall(url);

                        Log.e(TAG, "Response from url: " + jsonStr);

                        if(jsonStr != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");
                                    String shield = c.getString("shield");
                                    String speed = c.getString("speed");
                                    String armor = c.getString("armor");
                                    String polarities = c.getString("polarities");
                                    String power = c.getString("power");
                                    String location = c.getString("location");
                                    String description = c.getString("description");

                                    frame.add(name);
                                    healts.add(health);
                                    mrs.add(mr);
                                    shields.add(shield);
                                    speeds.add(speed);
                                    armors.add(armor);
                                    polarities.add(polarities);
                                    powers.add(power);
                                    locations.add(location);
                                    descriptions.add(description);
                                    //frame[i].concat(name) ;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;
                    case 1:
                        String url1 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr1 = sh.makeServiceCall(url1);

                        Log.e(TAG, "Response from url: " + jsonStr1);

                        if(jsonStr1 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr1);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");
                                    frame.add(name);
                                    //frame[i].concat(name) ;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;
                    case 2:
                        String url2 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr2 = sh.makeServiceCall(url2);

                        Log.e(TAG, "Response from url: " + jsonStr2);

                        if(jsonStr2 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr2);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");



                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;
                    case 3:
                        String url3 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr3 = sh.makeServiceCall(url3);

                        Log.e(TAG, "Response from url: " + jsonStr3);

                        if(jsonStr3 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr3);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");
                                    frame.add(name);
                                    //frame[i].concat(name) ;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;
                    case 4:
                        String url4 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr4 = sh.makeServiceCall(url4);

                        Log.e(TAG, "Response from url: " + jsonStr4);

                        if(jsonStr4 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr4);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");
                                    frame.add(name);
                                    //frame[i].concat(name) ;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;
                    case 6:
                        String url5 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json";
                        String jsonStr5 = sh.makeServiceCall(url5);

                        Log.e(TAG, "Response from url: " + jsonStr5);

                        if(jsonStr5 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr5);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String health = c.getString("health");
                                    String mr = c.getString("mr");
                                    frame.add(name);
                                    //frame[i].concat(name) ;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Log.e(TAG, "Couldn't get json from server.");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Couldn't get json from server. Check LogCat for possible errors!",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        break;

                }
            }
         return null;
    }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //ItemAdapter adapter = new ItemAdapter(ListOfItemsActivity.this, frame);
            //itemsListView.setAdapter(adapter);
            itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                    showDetailActivity.putExtra("com.example.michal.FRAME", frame);
                    showDetailActivity.putExtra("com.example.michal.ITEM", position);
                    startActivity(showDetailActivity);
                    //DetailActivity.data.setText(parse);
                }
            });
        }
    }
}


/*
    @Override
    public void onTaskComplete (final String[] name/*, final String[] mr, final String[] health, final String[] shield, final String[] armor, final String[] power, final String[] speed, final String[] description, final String[] polarities){
        //frame = name;
        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_ID", -1);
        if (index > -1) {
            switch (index) {
                case 0:
                    //JSONFrameparsing warframe = new JSONFrameparsing();
                    //warframe.execute();
                    //parse = frame + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
                    break;
                case 1:
                    //JSONFrameparsing archwings = new JSONFrameparsing();
                    //archwings.execute();
                    //parse = arch + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, archwing));
                    break;
                case 2:
                    //JSONFrameparsing melees = new JSONFrameparsing();
                    //primarys.execute();
                    //parse = prim + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    break;
                case 3:
                    //JSONFrameparsing secondarys = new JSONFrameparsing();
                    //secondarys.execute();
                    //parse = sec + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    break;
                case 4:
                    //JSONFrameparsing primarys = new JSONFrameparsing();
                    //melees.execute();
                    //parse = mel + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    break;
                case 5:
                    //JSONFrameparsing companioss = new JSONFrameparsing();
                    //companioss.execute();
                    //parse = comp + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, companios));
                    break;
                default:
                    break;
            }
        }

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showParsingActivity = new Intent(getApplicationContext(), ParsingActivity.class);
                //showParsingActivity.putExtra("com.example.michal.FRAME", name);
                /*showDetailActivity.putExtra("com.example.michal.MR", mr);
                showDetailActivity.putExtra("com.example.michal.HP", health);
                showDetailActivity.putExtra("com.example.michal.SHIELD", shield);
                showDetailActivity.putExtra("com.example.michal.ARMOR", armor);
                showDetailActivity.putExtra("com.example.michal.POWER", power);
                showDetailActivity.putExtra("com.example.michal.SPEED", speed);
                showDetailActivity.putExtra("com.example.michal.DESCRIPTION", description);
                showDetailActivity.putExtra("com.example.michal.POLARITIES", polarities);
                showParsingActivity.putExtra("com.example.michal.ITEM", position);
                startActivity(showParsingActivity);
                //DetailActivity.data.setText(parse);
            }
        });
    }*/

//}
