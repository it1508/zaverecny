package com.example.michal.warframeinformationapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
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
    public static TextView desc;
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
        shields = in.getStringArrayListExtra("com.example.michal.SHIELD");
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
        desc = (TextView) findViewById(R.id.atributesTextView);
        ImageView img = (ImageView) findViewById(R.id.ItemImageView);
        int pic = 0;
        switch(idcko){
            case 0:
                SpannableString ss1=  new SpannableString("Description: "+ descriptions.get(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + names.get(index)
                        + "\nMR: " + mrs.get(index)
                        + "\nHP: " + healts.get(index)
                        + "\nShield: " + shields.get(index)
                        + "\nArmor: " + armors.get(index)
                        + "\nPower: " + powers.get(index)
                        + "\nSpeed: " + speeds.get(index)
                        + "\nLocation: " + locations.get(index));
                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 1:
                data.setText("Description: "+ descriptions.get(index) );
                desc.setText("Name: " + names.get(index)
                        + "\nMR: " + mrs.get(index)
                        + "\nHP: " + healts.get(index)
                        + "\nShield: " + shields.get(index)
                        + "\nArmor: " + armors.get(index)
                        + "\nPower: " + powers.get(index));
                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 2:
                data.setText("Description: "+ descriptions.get(index) );
                desc.setText("Name: " + names.get(index)
                        + "\nMR: " + mrs.get(index)
                        + "\nCrittical Chance: " + criticalChances.get(index)
                        + "\nCritical Multiplayer: " + criticalMultipliers.get(index)
                        + "\nReload speed: " + reloadTimes.get(index)
                        + "\nMagazine: " + magazineSizes.get(index)
                        + "\nAmmo: " + ammos.get(index)
                        + "\nFire rate: " + fireRates.get(index)
                        + "\nAccucary: " + accuracys.get(index)
                        + "\nProc. chance: " + procChances.get(index)
                        + "\nNoise: " + noises.get(index)
                        + "\nDamage: " + dmgs.get(index)
                        + "\nDisposition: " + dispotions.get(index)
                        + "\nType: " + types.get(index)
                );
                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 3:
                data.setText("Description: "+ descriptions.get(index) );
                desc.setText("Name: " + names.get(index)
                        + "\nMR: " + mrs.get(index)
                        + "\nCrittical Chance: " + criticalChances.get(index)
                        + "\nCritical Multiplayer: " + criticalMultipliers.get(index)
                        + "\nReload speed: " + reloadTimes.get(index)
                        + "\nMagazine: " + magazineSizes.get(index)
                        + "\nAmmo: " + ammos.get(index)
                        + "\nFire rate: " + fireRates.get(index)
                        + "\nAccucary: " + accuracys.get(index)
                        + "\nProc. chance: " + procChances.get(index)
                        + "\nNoise: " + noises.get(index)
                        + "\nDamage: " + dmgs.get(index)
                        + "\nDisposition: " + dispotions.get(index)
                        + "\nType: " + types.get(index)
                );
                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 4:
                data.setText("Description: "+ descriptions.get(index) );
                desc.setText("Name: " + names.get(index)
                        + "\nMR: " + mrs.get(index)
                        + "\nCrittical Chance: " + criticalChances.get(index)
                        + "\nCritical Multiplayer: " + criticalMultipliers.get(index)
                        + "\nSpeed: " + fireRates.get(index)
                        + "\nProc. chance: " + procChances.get(index)
                        + "\nDamage: " + dmgs.get(index)
                        + "\nDisposition: " + dispotions.get(index)
                );
                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 5:
                data.setText("Description: "+ descriptions.get(index) );
                desc.setText("Name: " + names.get(index)
                        + "\nHP: " + healts.get(index)
                        + "\nShield: " + shields.get(index)
                        + "\nArmor: " + armors.get(index)
                        + "\nPower: " + powers.get(index));

                setTitle(names.get(index));
                pic = getImg(index);
                scaleImg(img,pic);
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
    private int getImg(int jmeno){
        switch(idcko) {
            case 0: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.ash_prime;
                    case 1:
                        return R.drawable.ash_prime;
                    case 2:
                        return R.drawable.afuris;
                    case 3:
                        return R.drawable.ankyros_prime;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    case 6:
                        return R.drawable.ash_prime;
                    case 7:
                        return R.drawable.ash_prime;
                    case 8:
                        return R.drawable.afuris;
                    case 9:
                        return R.drawable.ankyros_prime;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.afuris;
                    case 13:
                        return R.drawable.ash_prime;
                    case 14:
                        return R.drawable.ash_prime;
                    case 15:
                        return R.drawable.afuris;
                    case 16:
                        return R.drawable.ankyros_prime;
                    case 17:
                        return R.drawable.afuris;
                    case 18:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 1: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.acrid;
                    case 1:
                        return R.drawable.adarza_kavat;
                    case 2:
                        return R.drawable.afuris;
                    case 3:
                        return R.drawable.ankyros_prime;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    case 6:
                        return R.drawable.ash_prime;
                    case 7:
                        return R.drawable.ash_prime;
                    case 8:
                        return R.drawable.afuris;
                    case 9:
                        return R.drawable.ankyros_prime;
                    case 10:
                        return R.drawable.afuris;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.ash_prime;
                    case 13:
                        return R.drawable.ash_prime;
                    case 14:
                        return R.drawable.afuris;
                    case 15:
                        return R.drawable.ankyros_prime;
                    case 16:
                        return R.drawable.afuris;
                    case 17:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 2: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.amprex;
                    case 1:
                        return R.drawable.astilla;
                    case 2:
                        return R.drawable.arca_plasmor;
                    case 3:
                        return R.drawable.attica;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 3: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.acrid;
                    case 1:
                        return R.drawable.akbronco;
                    case 2:
                        return R.drawable.afuris;
                    case 3:
                        return R.drawable.ankyros_prime;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 4: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.acrid;
                    case 1:
                        return R.drawable.adarza_kavat;
                    case 2:
                        return R.drawable.afuris;
                    case 3:
                        return R.drawable.ankyros_prime;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 5: {
                switch (jmeno) {
                    case 0:
                        return R.drawable.acrid;
                    case 1:
                        return R.drawable.adarza_kavat;
                    case 2:
                        return R.drawable.afuris;
                    case 3:
                        return R.drawable.ankyros_prime;
                    case 4:
                        return R.drawable.afuris;
                    case 5:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            default:return 0;
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
