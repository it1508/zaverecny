package com.example.michal.warframeinformationapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DetailActivity extends AppCompatActivity /*implements TaskCompleted*/{
    int idcko = 0;
    //ListView secondListView;
    public static TextView data;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        /*Resources res = getResources();
        warframes = res.getStringArray(R.array.warframes);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);
        Intent in = getIntent();*/

        /*JSONFrameparsing warframe = new JSONFrameparsing(DetailActivity.this);
        try {
            warframe.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Intent in = getIntent();
        int index = in.getIntExtra("com.example.michal.ITEM",-1);
        idcko = in.getIntExtra("com.example.michal.ID",-1);
        names = in.getStringArrayListExtra("com.example.michal.FRAME");
        mrs = in.getStringArrayListExtra("com.example.michal.MRS");
        images = in.getStringArrayListExtra("com.example.michal.IMAGE");
        descriptions = in.getStringArrayListExtra("com.example.michal.DESCRIPTION");
        locations = in.getStringArrayListExtra("com.example.michal.LOCATION");
        healts = in.getStringArrayListExtra("com.example.michal.HEALT");
        armors = in.getStringArrayListExtra("com.example.michal.ARMOR");
        powers = in.getStringArrayListExtra("com.example.michal.POWER");
        polarities = in.getStringArrayListExtra("com.example.michal.POLARITIES");
        speeds = in.getStringArrayListExtra("com.example.michal.SPEED");
        accuracys = in.getStringArrayListExtra("com.example.michal.ACCURACY");
        criticalChances = in.getStringArrayListExtra("com.example.michal.CRITCHANCE");
        criticalMultipliers = in.getStringArrayListExtra("com.example.michal.CRITMULTIPLA");
        ammos = in.getStringArrayListExtra("com.example.michal.AMMO");
        magazineSizes = in.getStringArrayListExtra("com.example.michal.MAGAZINESIZE");
        dmgs = in.getStringArrayListExtra("com.example.michal.DMG");
        fireRates = in.getStringArrayListExtra("com.example.michal.FIRERATE");
        dispotions = in.getStringArrayListExtra("com.example.michal.DISPOTION");
        reloadTimes = in.getStringArrayListExtra("com.example.michal.RELOADTIME");
        types = in.getStringArrayListExtra("com.example.michal.TYPE");
        noises = in.getStringArrayListExtra("com.example.michal.NOISE");
        procChances = in.getStringArrayListExtra("com.example.michal.PROCCHANCE");
        slashs = in.getStringArrayListExtra("com.example.michal.SLASH");
        impacts = in.getStringArrayListExtra("com.example.michal.IMPACT");
        punctures = in.getStringArrayListExtra("com.example.michal.PUNCTURE");
        data = (TextView) findViewById(R.id.priceTextView);
        ImageView img = (ImageView) findViewById(R.id.ItemImageView);
        switch(idcko){
            case 0:
                data.setText("Name: " + names.get(index) + "\nMR: " + mrs.get(index) );
                setTitle(names.get(index));
                //scaleImg(img,pic);
                //img.setImageDrawable();
                break;
            case 1:
                data.setText("Name: " + names.get(index) + "\ncritMulti: " + armors.get(index) );
                setTitle(names.get(index));
                break;
            case 2:
                data.setText("Name: " + names.get(index) + "\nAmmo: " + ammos.get(index) );
                setTitle(names.get(index));
                break;
            case 3:
                data.setText("Name: " + names.get(index) + "\nProcChance: " + procChances.get(index) );
                setTitle(names.get(index));
                break;
            case 4:
                data.setText("Name: " + names.get(index) + "\nSlash: " + slashs.get(index) );
                setTitle(names.get(index));
                break;
            case 5:
                data.setText("Name: " + names.get(index) + "\nHealts: " + healts.get(index) );
                setTitle(names.get(index));
                break;
        }

        //data.setText("Name: " + names.get(index) + "\nMR: " + mrs.get(index) );

        /*int index = in.getIntExtra("com.example.michal.ITEM", -1);
        if(index > -1){
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.ItemImageView);
            scaleImg(img,pic);
            TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
            TextView priceTextView = (TextView) findViewById(R.id.priceTextView);
            String name = warframes[index];
            String price = prices[index];
            nameTextView.setText(name);
            priceTextView.setText(price);
        }*/

    }
    /*private int getImg(char jmeno){
        switch (jmeno){
            case 0: return R.drawable.excaliburprime;
            case 1: return R.drawable.nova;
            case 2: return R.drawable.hydroid;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),pic,options);
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaleImg = BitmapFactory.decodeResource(getResources(),pic,options);
        img.setImageBitmap(scaleImg);
    }*/

    /*@Override
    public void onTaskComplete(String[] name, String[] mr, String[] health, String[] shield, String[] armor, String[] power, String[] speed, String[] description, String[] polarities) {
    name1 = name;
    mr1 = mr;
    hp1 = health;
    shield1 = shield;
    armor1 = armor;
    power1 = power;
    description1 = description;
    speed1 = speed;
    polarities1 = polarities;
    }*/
}
