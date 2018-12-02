package com.example.michal.warframeinformationapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONPrimaryparsing extends AsyncTask<Void, Void, Void> {

    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String items = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://raw.githubusercontent.com/it1508/zaverecny/master/Data/warframes.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0;i <JA.length();i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "Name:" + JO.get("name") + "\n"+
                        "MR:" + JO.get("mr") + "\n"+
                        "health:" + JO.get("health") + "\n"+
                        "shield:" + JO.get("shield") + "\n"+
                        "armor:" + JO.get("armor") + "\n"+
                        "power:" + JO.get("power") + "\n"+
                        "speed:" + JO.get("speed") + "\n"+
                        "polarities:" + JO.get("polarities") + "\n"+
                        "description:" + JO.get("description") + "\n";
                //"location:" + JO.get("location") + "\n";
                //"relic:" + JO.get("relic") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";
            }





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //ListOfItemsActivity.prim.matches(this.data);
    }


}
