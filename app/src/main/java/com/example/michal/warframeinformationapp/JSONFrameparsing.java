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

public class JSONFrameparsing extends AsyncTask<Void, Void, Void> {

    private final TaskCompleted listener;
    String data = "";
    static String dataParsed = "";
    String singleParsed = "";
    String items = "";
    String mr[];
    String location[];
    String hp[];
    String shield[];
    String armor[];
    String description[];
    String speed[];
    String power[];
    String polarities[];
    String name[];



    public JSONFrameparsing(TaskCompleted listener){
        this.listener=listener;
    }
    
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
                name[i] =  "Name:" + JO.get("name");
                /*mr[i] = "MR:" + JO.get("mr");
                hp[i] = "health:" + JO.get("health");
                shield[i] = "shield:" + JO.get("shield");
                armor [i] = "armor:" + JO.get("armor");
                power[i] = "power:" + JO.get("power");
                speed[i] = "speed:" + JO.get("speed");
                description[i] = "description:" + JO.get("description");
                polarities [i] = "polarities:" + JO.get("polarities");*/

                //"location:" + JO.get("location") + "\n";
                //"relic:" + JO.get("relic") + "\n";


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
        //ListOfItemsActivity.frame = dataParsed;
        //DetailActivity.armor = armor;
        listener.onTaskComplete(name/*,mr,hp,shield,armor,power,speed,description,polarities*/);
        //DetailActivity.data.setText(name[0]);
    }
    

}
