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
    int idcko = 0;
    //String frame[];
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> shields = new ArrayList<String>();
    ArrayList<String> healts = new ArrayList<String>();
    ArrayList<String> mrs = new ArrayList<String>();
    ArrayList<String> speeds = new ArrayList<String>();
    ArrayList<String> armors = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> locations = new ArrayList<String>();
    ArrayList<String> powers = new ArrayList<String>();
    ArrayList<String> polarities = new ArrayList<String>();
    ArrayList<String> dispotions = new ArrayList<String>();
    ArrayList<String> dmgs = new ArrayList<String>();
    ArrayList<String> types = new ArrayList<String>();
    ArrayList<String> noises = new ArrayList<String>();
    ArrayList<String> accuracys = new ArrayList<String>();
    ArrayList<String> criticalChances = new ArrayList<String>();
    ArrayList<String> criticalMultipliers = new ArrayList<String>();
    ArrayList<String> procChances = new ArrayList<String>();
    ArrayList<String> fireRates = new ArrayList<String>();
    ArrayList<String> ammos = new ArrayList<String>();
    ArrayList<String> magazineSizes = new ArrayList<String>();
    ArrayList<String> reloadTimes = new ArrayList<String>();
    ArrayList<String> impacts = new ArrayList<String>();
    ArrayList<String> slashs = new ArrayList<String>();
    ArrayList<String> punctures = new ArrayList<String>();
    ArrayList<String> images = new ArrayList<String>();

    /*String sec = "";
    String prim = "";
    String comp = "";
    String arch = "";
    String parse = "";*/

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
                    setTitle("Warframes");
                    break;
                case 1:
                    //JSONFrameparsing archwings = new JSONFrameparsing();
                    //archwings.execute();
                    //parse = arch + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, archwing));
                    setTitle("Archwings");
                    break;
                case 2:
                    //JSONFrameparsing melees = new JSONFrameparsing();
                    //primarys.execute();
                    //parse = prim + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    setTitle("Primary");
                    break;
                case 3:
                    //JSONFrameparsing secondarys = new JSONFrameparsing();
                    //secondarys.execute();
                    //parse = sec + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    setTitle("Secondary");
                    break;
                case 4:
                    //JSONFrameparsing primarys = new JSONFrameparsing();
                    //melees.execute();
                    //parse = mel + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    setTitle("Melee");
                    break;
                case 5:
                    //JSONFrameparsing companioss = new JSONFrameparsing();
                    //companioss.execute();
                    //parse = comp + "\n";
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, companios));
                    setTitle("Companions");
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
                                    String polaritie = c.getString("polarities");
                                    String power = c.getString("power");
                                    String location = c.getString("location");
                                    String description = c.getString("description");
                                    //String image = c.getString("imageName");

                                    names.add(name);
                                    healts.add(health);
                                    mrs.add(mr);
                                    shields.add(shield);
                                    speeds.add(speed);
                                    armors.add(armor);
                                    polarities.add(polaritie);
                                    powers.add(power);
                                    locations.add(location);
                                    descriptions.add(description);
                                    //images.add(image);
                                    idcko = 0;
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
                        String url1 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/archwings.json";
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
                                    String shield = c.getString("shield");
                                    String armor = c.getString("armor");
                                    String power = c.getString("power");
                                    String location = c.getString("location");
                                    String description = c.getString("description");
                                    String image = c.getString("imageName");

                                    names.add(name);
                                    healts.add(health);
                                    mrs.add(mr);
                                    shields.add(shield);
                                    armors.add(armor);
                                    powers.add(power);
                                    locations.add(location);
                                    descriptions.add(description);
                                    images.add(image);
                                    idcko = 1;
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
                        String url2 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/primary.json";
                        String jsonStr2 = sh.makeServiceCall(url2);

                        Log.e(TAG, "Response from url: " + jsonStr2);

                        if(jsonStr2 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr2);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String dmg = c.getString("damage");
                                    String mr = c.getString("masteryReq");
                                    String accuracy = c.getString("accuracy");
                                    String reloadTime = c.getString("reloadTime");
                                    String magazinesize = c.getString("magazineSize");
                                    //String location = c.getString("location");
                                    String description = c.getString("description");
                                    String noise = c.getString("noise");
                                    String dispotion = c.getString("disposition");
                                    String fireRate = c.getString("fireRate");
                                    String ammo = c.getString("ammo");
                                    String procChance = c.getString("procChance");
                                    String critChance = c.getString("criticalChance");
                                    String critMultipla = c.getString("criticalMultiplier");
                                    String type = c.getString("type");
                                    String image = c.getString("imageName");

                                    names.add(name);
                                    dmgs.add(dmg);
                                    mrs.add(mr);
                                    accuracys.add(accuracy);
                                    reloadTimes.add(reloadTime);
                                    magazineSizes.add(magazinesize);
                                    //locations.add(location);
                                    descriptions.add(description);
                                    procChances.add(procChance);
                                    criticalChances.add(critChance);
                                    criticalMultipliers.add(critMultipla);
                                    ammos.add(ammo);
                                    dispotions.add(dispotion);
                                    types.add(type);
                                    noises.add(noise);
                                    fireRates.add(fireRate);
                                    images.add(image);
                                    idcko = 2;


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
                        String url3 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/secondary.json";
                        String jsonStr3 = sh.makeServiceCall(url3);

                        Log.e(TAG, "Response from url: " + jsonStr3);

                        if(jsonStr3 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr3);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String dmg = c.getString("damage");
                                    String mr = c.getString("masteryReq");
                                    String accuracy = c.getString("accuracy");
                                    String reloadTime = c.getString("reloadTime");
                                    String magazinesize = c.getString("magazineSize");
                                    //String location = c.getString("location");
                                    String description = c.getString("description");
                                    String noise = c.getString("noise");
                                    String dispotion = c.getString("disposition");
                                    String fireRate = c.getString("fireRate");
                                    String ammo = c.getString("ammo");
                                    String procChance = c.getString("procChance");
                                    String critChance = c.getString("criticalChance");
                                    String critMultipla = c.getString("criticalMultiplier");
                                    String type = c.getString("type");
                                    String image = c.getString("imageName");

                                    names.add(name);
                                    dmgs.add(dmg);
                                    mrs.add(mr);
                                    accuracys.add(accuracy);
                                    reloadTimes.add(reloadTime);
                                    magazineSizes.add(magazinesize);
                                    //locations.add(location);
                                    descriptions.add(description);
                                    procChances.add(procChance);
                                    criticalChances.add(critChance);
                                    criticalMultipliers.add(critMultipla);
                                    ammos.add(ammo);
                                    dispotions.add(dispotion);
                                    types.add(type);
                                    noises.add(noise);
                                    fireRates.add(fireRate);
                                    images.add(image);
                                    idcko = 3;
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
                        String url4 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/melee.json";
                        String jsonStr4 = sh.makeServiceCall(url4);

                        Log.e(TAG, "Response from url: " + jsonStr4);

                        if(jsonStr4 != null){
                            try{
                                //JSONObject jsonObj = new JSONObject(jsonStr);
                                JSONArray frames = new JSONArray(jsonStr4);
                                for(int i =0;i < frames.length();i++){
                                    JSONObject c = frames.getJSONObject(i);
                                    String name = c.getString("name");
                                    String dmg = c.getString("totalDamage");
                                    String mr = c.getString("masteryReq");
                                    //String location = c.getString("location");
                                    String description = c.getString("description");
                                    String slash = c.getString("slash");
                                    String dispotion = c.getString("disposition");
                                    String puncture = c.getString("puncture");
                                    String impact = c.getString("impact");
                                    String procChance = c.getString("procChance");
                                    String critChance = c.getString("criticalChance");
                                    String critMultipla = c.getString("criticalMultiplier");
                                    String type = c.getString("type");
                                    String image = c.getString("imageName");

                                    names.add(name);
                                    dmgs.add(dmg);
                                    mrs.add(mr);
                                    //locations.add(location);
                                    descriptions.add(description);
                                    procChances.add(procChance);
                                    criticalChances.add(critChance);
                                    criticalMultipliers.add(critMultipla);
                                    slashs.add(slash);
                                    dispotions.add(dispotion);
                                    types.add(type);
                                    punctures.add(puncture);
                                    impacts.add(impact);
                                    images.add(image);
                                    idcko = 4;
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
                    case 5:
                        String url5 = "https://raw.githubusercontent.com/it1508/zaverecny/master/Data/companions.json";
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
                                    String shield = c.getString("shield");
                                    String armor = c.getString("armor");
                                    String power = c.getString("power");
                                    //String location = c.getString("location");
                                    String description = c.getString("description");
                                    String image = c.getString("imageName");

                                    names.add(name);
                                    healts.add(health);
                                    shields.add(shield);
                                    armors.add(armor);
                                    powers.add(power);
                                    //locations.add(location);
                                    descriptions.add(description);
                                    images.add(image);
                                    idcko = 5;
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
                    showDetailActivity.putExtra("com.example.michal.ITEM", position);
                    showDetailActivity.putExtra("com.example.michal.FRAME", names);
                    showDetailActivity.putExtra("com.example.michal.MRS", mrs);
                    showDetailActivity.putExtra("com.example.michal.IMAGE", images);
                    showDetailActivity.putExtra("com.example.michal.DESCRIPTION", descriptions);
                    showDetailActivity.putExtra("com.example.michal.LOCATION", locations);
                    switch(idcko){
                        case 0:
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            showDetailActivity.putExtra("com.example.michal.HEALT", healts);
                            showDetailActivity.putExtra("com.example.michal.ARMOR", armors);
                            showDetailActivity.putExtra("com.example.michal.SHIELD", shields);
                            showDetailActivity.putExtra("com.example.michal.POWER", powers);
                            showDetailActivity.putExtra("com.example.michal.POLARITIES", polarities);
                            showDetailActivity.putExtra("com.example.michal.SPEED", speeds);

                            break;
                        case 1:
                            showDetailActivity.putExtra("com.example.michal.HEALT", healts);
                            showDetailActivity.putExtra("com.example.michal.ARMOR", armors);
                            showDetailActivity.putExtra("com.example.michal.SHIELD", shields);
                            showDetailActivity.putExtra("com.example.michal.POWER", powers);
                            showDetailActivity.putExtra("com.example.michal.POLARITIES", polarities);
                            showDetailActivity.putExtra("com.example.michal.SPEED", speeds);
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            break;
                        case 2:
                            showDetailActivity.putExtra("com.example.michal.ACCURACY", accuracys);
                            showDetailActivity.putExtra("com.example.michal.CRITCHANCE", criticalChances);
                            showDetailActivity.putExtra("com.example.michal.CRITMULTIPLA", criticalMultipliers);
                            showDetailActivity.putExtra("com.example.michal.AMMO", ammos);
                            showDetailActivity.putExtra("com.example.michal.MAGAZINESIZE", magazineSizes);
                            showDetailActivity.putExtra("com.example.michal.DMG", dmgs);
                            showDetailActivity.putExtra("com.example.michal.FIRERATE", fireRates);
                            showDetailActivity.putExtra("com.example.michal.DISPOTION", dispotions);
                            showDetailActivity.putExtra("com.example.michal.RELOADTIME", reloadTimes);
                            showDetailActivity.putExtra("com.example.michal.TYPE", types);
                            showDetailActivity.putExtra("com.example.michal.NOISE", noises);
                            showDetailActivity.putExtra("com.example.michal.PROCCHANCE", procChances);
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            break;
                        case 3:
                            showDetailActivity.putExtra("com.example.michal.ACCURACY", accuracys);
                            showDetailActivity.putExtra("com.example.michal.CRITCHANCE", criticalChances);
                            showDetailActivity.putExtra("com.example.michal.CRITMULTIPLA", criticalMultipliers);
                            showDetailActivity.putExtra("com.example.michal.AMMO", ammos);
                            showDetailActivity.putExtra("com.example.michal.MAGAZINESIZE", magazineSizes);
                            showDetailActivity.putExtra("com.example.michal.DMG", dmgs);
                            showDetailActivity.putExtra("com.example.michal.FIRERATE", fireRates);
                            showDetailActivity.putExtra("com.example.michal.DISPOTION", dispotions);
                            showDetailActivity.putExtra("com.example.michal.RELOADTIME", reloadTimes);
                            showDetailActivity.putExtra("com.example.michal.TYPE", types);
                            showDetailActivity.putExtra("com.example.michal.NOISE", noises);
                            showDetailActivity.putExtra("com.example.michal.PROCCHANCE", procChances);
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            break;
                        case 4:
                            showDetailActivity.putExtra("com.example.michal.CRITCHANCE", criticalChances);
                            showDetailActivity.putExtra("com.example.michal.CRITMULTIPLA", criticalMultipliers);
                            showDetailActivity.putExtra("com.example.michal.DMG", dmgs);
                            showDetailActivity.putExtra("com.example.michal.IMPACT", impacts);
                            showDetailActivity.putExtra("com.example.michal.DISPOTION", dispotions);
                            showDetailActivity.putExtra("com.example.michal.PUNCTURE", punctures);
                            showDetailActivity.putExtra("com.example.michal.TYPE", types);
                            showDetailActivity.putExtra("com.example.michal.SLASH", slashs);
                            showDetailActivity.putExtra("com.example.michal.PROCCHANCE", procChances);
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            break;
                        case 5:
                            showDetailActivity.putExtra("com.example.michal.HEALT", healts);
                            showDetailActivity.putExtra("com.example.michal.ARMOR", armors);
                            showDetailActivity.putExtra("com.example.michal.SHIELD", shields);
                            showDetailActivity.putExtra("com.example.michal.POWER", powers);
                            showDetailActivity.putExtra("com.example.michal.ID", idcko);
                            break;
                    }


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
