package com.example.michal.warframeinformationapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    //ListView secondListView;
    String[] warframes;
    String[] prices;
    String[] descriptions;
    public static TextView data;
    String mr1[];
    String location1[];
    String hp1[];
    String shield1[];
    String armor1[];
    String description1[];
    String speed1[];
    String power1[];
    String polarities1[];
    ArrayList<String> name = new ArrayList<String>();

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
        name = in.getStringArrayListExtra("com.example.michal.FRAME");
        /*mr1 = in.getStringArrayExtra("com.example.michal.MR");
        hp1 = in.getStringArrayExtra("com.example.michal.HP");
        shield1 = in.getStringArrayExtra("com.example.michal.SHIELD");
        armor1 = in.getStringArrayExtra("com.example.michal.ARMOR");
        polarities1 = in.getStringArrayExtra("com.example.michal.POLARITIES");
        description1 = in.getStringArrayExtra("com.example.michal.DESCRIPTION");
        speed1 = in.getStringArrayExtra("com.example.michal.SPEED");
        power1 = in.getStringArrayExtra("com.example.michal.POWER");*/

        data = (TextView) findViewById(R.id.priceTextView);
        data.setText(name.get(index));

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
        }

    }
    private int getImg(int index){
        switch (index){
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
        img.setImageBitmap(scaleImg);*/
    }

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
