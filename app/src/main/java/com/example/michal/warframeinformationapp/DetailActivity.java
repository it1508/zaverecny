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

public class DetailActivity extends AppCompatActivity {
    int idcko = 0;
    public static TextView data;
    public static TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent in = getIntent();
        int index = in.getIntExtra("com.example.michal.ITEM",-1);
        idcko = in.getIntExtra("com.example.michal.ID",-1);
        data = (TextView) findViewById(R.id.priceTextView);
        desc = (TextView) findViewById(R.id.atributesTextView);
        ImageView img = (ImageView) findViewById(R.id.ItemImageView);
        int pic = 0;
        SpannableString ss1=  new SpannableString( "Description: ");
        switch(idcko){
            case 0:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nMR: " + Warframe.getMr(index)
                        + "\nHP: " + Warframe.getHealth(index)
                        + "\nShield: " + Warframe.getShield(index)
                        + "\nArmor: " + Warframe.getArmor(index)
                        + "\nPower: " + Warframe.getPower(index)
                        + "\nSpeed: " + Warframe.getSpeed(index)
                        + "\nLocation: " + Warframe.getLocation(index));
                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 1:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nMR: " + Warframe.getMr(index)
                        + "\nHP: " + Warframe.getHealth(index)
                        + "\nShield: " + Warframe.getShield(index)
                        + "\nArmor: " + Warframe.getArmor(index)
                        + "\nPower: " + Warframe.getPower(index));
                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 2:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nMR: " + Warframe.getMr(index)
                        + "\nCrittical Chance: " + Warframe.getCritChance(index)
                        + "\nCritical Multiplayer: " + Warframe.getCritMulti(index)
                        + "\nReload speed: " + Warframe.getReloadTime(index)
                        + "\nMagazine: " + Warframe.getMagazineSize(index)
                        + "\nAmmo: " + Warframe.getAmmo(index)
                        + "\nFire rate: " + Warframe.getFireRate(index)
                        + "\nAccucary: " + Warframe.getAccuracy(index)
                        + "\nProc. chance: " + Warframe.getProcChance(index)
                        + "\nNoise: " + Warframe.getNoise(index)
                        + "\nDamage: " + Warframe.getDmg(index)
                        + "\nDisposition: " + Warframe.getDispotion(index)
                        + "\nType: " + Warframe.getType(index)
                );
                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 3:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nMR: " + Warframe.getMr(index)
                        + "\nCrittical Chance: " + Warframe.getCritChance(index)
                        + "\nCritical Multiplayer: " + Warframe.getCritMulti(index)
                        + "\nReload speed: " + Warframe.getReloadTime(index)
                        + "\nMagazine: " + Warframe.getMagazineSize(index)
                        + "\nAmmo: " + Warframe.getAmmo(index)
                        + "\nFire rate: " + Warframe.getFireRate(index)
                        + "\nAccucary: " + Warframe.getAccuracy(index)
                        + "\nProc. chance: " + Warframe.getProcChance(index)
                        + "\nNoise: " + Warframe.getNoise(index)
                        + "\nDamage: " + Warframe.getDmg(index)
                        + "\nDisposition: " + Warframe.getDispotion(index)
                        + "\nType: " + Warframe.getType(index)
                );
                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 4:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nMR: " + Warframe.getMr(index)
                        + "\nCrittical Chance: " + Warframe.getCritChance(index)
                        + "\nCritical Multiplayer: " + Warframe.getCritMulti(index)
                        + "\nSpeed: " + Warframe.getFireRate(index)
                        + "\nProc. chance: " + Warframe.getProcChance(index)
                        + "\nDamage: " + Warframe.getDmg(index)
                        + "\nDisposition: " + Warframe.getDispotion(index)
                );
                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
            case 5:
                ss1=  new SpannableString("Description: "+ Warframe.getDescription(index) );
                ss1.setSpan(new RelativeSizeSpan(1.2f), 0,12, 0);
                data.setText(ss1 );
                desc.setText("Name: " + Warframe.getName(index)
                        + "\nHP: " + Warframe.getHealth(index)
                        + "\nShield: " + Warframe.getShield(index)
                        + "\nArmor: " + Warframe.getArmor(index)
                        + "\nPower: " + Warframe.getPower(index));

                setTitle(Warframe.getName(index));
                pic = getImg(index);
                scaleImg(img,pic);
                break;
        }
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
                    case 6:
                        return R.drawable.amprex;
                    case 7:
                        return R.drawable.astilla;
                    case 8:
                        return R.drawable.arca_plasmor;
                    case 9:
                        return R.drawable.attica;
                    case 10:
                        return R.drawable.afuris;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.arca_plasmor;
                    case 13:
                        return R.drawable.attica;
                    case 14:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 3: {
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
                    case 6:
                        return R.drawable.amprex;
                    case 7:
                        return R.drawable.astilla;
                    case 8:
                        return R.drawable.arca_plasmor;
                    case 9:
                        return R.drawable.attica;
                    case 10:
                        return R.drawable.afuris;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.arca_plasmor;
                    case 13:
                        return R.drawable.attica;
                    case 14:
                        return R.drawable.afuris;
                    case 15:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 4: {
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
                    case 6:
                        return R.drawable.amprex;
                    case 7:
                        return R.drawable.astilla;
                    case 8:
                        return R.drawable.arca_plasmor;
                    case 9:
                        return R.drawable.attica;
                    case 10:
                        return R.drawable.afuris;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.arca_plasmor;
                    case 13:
                        return R.drawable.attica;
                    case 14:
                        return R.drawable.afuris;
                    default:
                        return -1;
                }
            }
            case 5: {
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
                    case 6:
                        return R.drawable.amprex;
                    case 7:
                        return R.drawable.astilla;
                    case 8:
                        return R.drawable.arca_plasmor;
                    case 9:
                        return R.drawable.attica;
                    case 10:
                        return R.drawable.afuris;
                    case 11:
                        return R.drawable.afuris;
                    case 12:
                        return R.drawable.arca_plasmor;
                    case 13:
                        return R.drawable.attica;
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
}
