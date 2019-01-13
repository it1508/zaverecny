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


public class ListOfItemsActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ListView itemsListView;
    ArrayList<HashMap<String, String>> contactList;
    String[] warframes;
    String[] melee;
    String[] secondary;
    String[] primary;
    String[] companios;
    String[] archwing;
    int idcko = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);
        Warframe.clear();
        contactList = new ArrayList<>();
        new GetContacts().execute();
        Resources res = getResources();
        itemsListView = findViewById(R.id.itemsListView);
        warframes = res.getStringArray(R.array.warframes);
        melee = res.getStringArray(R.array.melee);
        secondary = res.getStringArray(R.array.secondary);
        primary = res.getStringArray(R.array.primary);
        companios = res.getStringArray(R.array.companions);
        archwing = res.getStringArray(R.array.archwing);
        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_ID", -1);
        if (index > -1) {
            switch (index) {
                case 0:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, warframes));
                    setTitle("Warframes");
                    break;
                case 1:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, archwing));
                    setTitle("Archwings");
                    break;
                case 2:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, primary));
                    setTitle("Primary");
                    break;
                case 3:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, secondary));
                    setTitle("Secondary");
                    break;
                case 4:
                    itemsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_view, melee));
                    setTitle("Melee");
                    break;
                case 5:
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
            //Toast.makeText(ListOfItemsActivity.this,"JSON Data is downloading",Toast.LENGTH_SHORT).show();
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

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setHealth(health);
                                    Warframe.setMr(mr);
                                    Warframe.setArmor(armor);
                                    Warframe.setPolaritie(polaritie);
                                    Warframe.setPower(power);
                                    Warframe.setShield(shield);
                                    Warframe.setSpeed(speed);
                                    Warframe.setDescription(description);
                                    Warframe.setLocation(location);
                                    idcko = 0;
                                    Toast.makeText(ListOfItemsActivity.this,"JSON Downloaded",Toast.LENGTH_LONG).show();
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

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setHealth(health);
                                    Warframe.setMr(mr);
                                    Warframe.setArmor(armor);
                                    Warframe.setPower(power);
                                    Warframe.setShield(shield);
                                    Warframe.setDescription(description);
                                    Warframe.setLocation(location);
                                    idcko = 1;
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

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setDmg(dmg);
                                    Warframe.setMr(mr);
                                    Warframe.setAccuracy(accuracy);
                                    Warframe.setReloadTime(reloadTime);
                                    Warframe.setMagazineSize(magazinesize);
                                    Warframe.setNoise(noise);
                                    Warframe.setDescription(description);
                                    Warframe.setDispotion(dispotion);
                                    Warframe.setName(name);
                                    Warframe.setFireRate(fireRate);
                                    Warframe.setProcChance(procChance);
                                    Warframe.setAmmo(ammo);
                                    Warframe.setCritChance(critChance);
                                    Warframe.setCritMulti(critMultipla);
                                    Warframe.setType(type);
                                    Warframe.setImage(image);
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

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setDmg(dmg);
                                    Warframe.setMr(mr);
                                    Warframe.setAccuracy(accuracy);
                                    Warframe.setReloadTime(reloadTime);
                                    Warframe.setMagazineSize(magazinesize);
                                    Warframe.setNoise(noise);
                                    Warframe.setDescription(description);
                                    Warframe.setDispotion(dispotion);
                                    Warframe.setName(name);
                                    Warframe.setFireRate(fireRate);
                                    Warframe.setProcChance(procChance);
                                    Warframe.setAmmo(ammo);
                                    Warframe.setCritChance(critChance);
                                    Warframe.setCritMulti(critMultipla);
                                    Warframe.setType(type);
                                    Warframe.setImage(image);
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
                                    String fireRate = c.getString("fireRate");

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setDmg(dmg);
                                    Warframe.setMr(mr);
                                    Warframe.setSlash(slash);
                                    Warframe.setPuncture(puncture);
                                    Warframe.setImpact(impact);
                                    Warframe.setDescription(description);
                                    Warframe.setDispotion(dispotion);
                                    Warframe.setName(name);
                                    Warframe.setFireRate(fireRate);
                                    Warframe.setProcChance(procChance);
                                    Warframe.setCritChance(critChance);
                                    Warframe.setCritMulti(critMultipla);
                                    Warframe.setType(type);
                                    Warframe.setImage(image);
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
                                    String location = c.getString("location");
                                    String description = c.getString("description");
                                    //String image = c.getString("imageName");

                                    Warframe.setName(name);
                                    //Warframe.setImage(image);
                                    Warframe.setHealth(health);
                                    Warframe.setArmor(armor);
                                    Warframe.setPower(power);
                                    Warframe.setShield(shield);
                                    Warframe.setDescription(description);
                                    Warframe.setLocation(location);
                                    idcko = 5;
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
                }Toast.makeText(ListOfItemsActivity.this,"JSON Download",Toast.LENGTH_LONG).show();
            }
         return null;
    }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Toast.makeText(ListOfItemsActivity.this,"JSON Download",Toast.LENGTH_LONG).show();
            itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                    showDetailActivity.putExtra("com.example.michal.ITEM", position);
                    showDetailActivity.putExtra("com.example.michal.ID", idcko);
                    startActivity(showDetailActivity);
                }
            });
        }
    }
}