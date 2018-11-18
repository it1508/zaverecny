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
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //ListView secondListView;
    String[] warframes;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Resources res = getResources();
        warframes = res.getStringArray(R.array.warframes);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);
        Intent in = getIntent();
        int index = in.getIntExtra("com.example.michal.ITEM", -1);
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
            /*Resources res = getResources();
            secondListView = (ListView) findViewById(R.id.myListView);
            items = res.getStringArray(R.array.items);
            prices = res.getStringArray(R.array.prices);
            descriptions = res.getStringArray(R.array.descriptions);

            ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
            secondListView.setAdapter(itemAdapter);*/
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
        img.setImageBitmap(scaleImg);
    }

}
