package com.example.michal.warframeinformationapp;


import java.util.ArrayList;

public class Warframe {
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<String> shields = new ArrayList<String>();
    static ArrayList<String> healts = new ArrayList<String>();
    static ArrayList<String> mrs = new ArrayList<String>();
    static ArrayList<String> speeds = new ArrayList<String>();
    static ArrayList<String> armors = new ArrayList<String>();
    static ArrayList<String> descriptions = new ArrayList<String>();
    static ArrayList<String> locations = new ArrayList<String>();
    static ArrayList<String> powers = new ArrayList<String>();
    static ArrayList<String> polarities = new ArrayList<String>();
    static ArrayList<String> dispotions = new ArrayList<String>();
    static ArrayList<String> dmgs = new ArrayList<String>();
    static ArrayList<String> types = new ArrayList<String>();
    static ArrayList<String> noises = new ArrayList<String>();
    static ArrayList<String> accuracys = new ArrayList<String>();
    static ArrayList<String> criticalChances = new ArrayList<String>();
    static ArrayList<String> criticalMultipliers = new ArrayList<String>();
    static ArrayList<String> procChances = new ArrayList<String>();
    static ArrayList<String> fireRates = new ArrayList<String>();
    static ArrayList<String> ammos = new ArrayList<String>();
    static ArrayList<String> magazineSizes = new ArrayList<String>();
    static ArrayList<String> reloadTimes = new ArrayList<String>();
    static ArrayList<String> impacts = new ArrayList<String>();
    static ArrayList<String> slashs = new ArrayList<String>();
    static ArrayList<String> punctures = new ArrayList<String>();
    static ArrayList<String> images = new ArrayList<String>();
    static ArrayList<String> special = new ArrayList<String>();

    public static void setName(String n) {
        names.add(n);
    }

    public static String getName(int i) {
        return names.get(i);
    }

    public static void setShield ( String n ) {
        shields.add(n);
    }

    public static String getShield(int i) {
        return shields.get(i);
    }

    public static void setHealth(String n) {
        healts.add(n);
    }

    public static String getHealth(int i) {
        return healts.get(i);
    }

    public static void setPower ( String n ) {
        powers.add(n);
    }

    public static String getPower(int i) {
        return powers.get(i);
    }

    public static void setSpeed ( String n ) {
        speeds.add(n);
    }

    public static String getSpeed(int i) {
        return speeds.get(i);
    }

    public static void setArmor ( String n ) {
        armors.add(n);
    }

    public static String getArmor(int i) {
        return armors.get(i);
    }

    public static void setDescription ( String n ) {
        descriptions.add(n);
    }

    public static String getDescription(int i) {
        return descriptions.get(i);
    }

    public static void setLocation ( String n ) {
        locations.add(n);
    }

    public static String getLocation(int i) {
        return locations.get(i);
    }

    public static void setDmg ( String n ) {
        dmgs.add(n);
    }

    public static String getDmg(int i) {
        return dmgs.get(i);
    }

    public static void setCritChance ( String n ) {
        criticalChances.add(n);
    }

    public static String getCritChance(int i) {
        return criticalChances.get(i);
    }

    public static void setCritMulti ( String n ) {
        criticalMultipliers.add(n);
    }

    public static String getCritMulti(int i) {
        return criticalMultipliers.get(i);
    }

    public static void setType ( String n ) {
        types.add(n);
    }

    public static String getType(int i) {
        return types.get(i);
    }

    public static void setPuncture ( String n ) {
        punctures.add(n);
    }

    public static String getPuncture(int i) {
        return punctures.get(i);
    }

    public static void setSlash ( String n ) {
        slashs.add(n);
    }

    public static String getSlash(int i) {
        return slashs.get(i);
    }

    public static void setImpact ( String n ) {
        impacts.add(n);
    }

    public static String getImpact(int i) {
        return impacts.get(i);
    }

    public static void setSpecial ( String n ) {
        special.add(n);
    }

    public static String getSpecial(int i) {
        return special.get(i);
    }

    public static void setFireRate ( String n ) {
        fireRates.add(n);
    }

    public static String getFireRate(int i) {
        return fireRates.get(i);
    }

    public static void setProcChance ( String n ) {
        procChances.add(n);
    }

    public static String getProcChance(int i) {
        return procChances.get(i);
    }

    public static void setNoise ( String n ) {
        noises.add(n);
    }

    public static String getNoise(int i) {
        return noises.get(i);
    }

    public static void setAccuracy ( String n ) {
        accuracys.add(n);
    }

    public static String getAccuracy(int i) {
        return accuracys.get(i);
    }

    public static void setDispotion ( String n ) {
        dispotions.add(n);
    }

    public static String getDispotion(int i) {
        return dispotions.get(i);
    }

    public static void setPolaritie ( String n ) {
        polarities.add(n);
    }

    public static String getPolaritie(int i) {
        return polarities.get(i);
    }

    public static void setMagazineSize ( String n ) {
        magazineSizes.add(n);
    }

    public static String getMagazineSize(int i) {
        return magazineSizes.get(i);
    }

    public static void setAmmo ( String n ) {
        ammos.add(n);
    }

    public static String getAmmo(int i) {
        return ammos.get(i);
    }

    public static void setReloadTime ( String n ) {
        reloadTimes.add(n);
    }

    public static String getReloadTime(int i) {
        return reloadTimes.get(i);
    }

    public static void setImage ( String n ) {
        images.add(n);
    }

    public static String getImage(int i) {
        return images.get(i);
    }

    public static void setMr ( String n ) {
        mrs.add(n);
    }

    public static String getMr(int i) {
        return mrs.get(i);
    }

    public static void clear(){
        mrs.clear();
        images.clear();
        ammos.clear();
        reloadTimes.clear();
        criticalChances.clear();
        criticalMultipliers.clear();
        magazineSizes.clear();
        names.clear();
        healts.clear();
        armors.clear();
        shields.clear();
        locations.clear();
        descriptions.clear();
        polarities.clear();
        dispotions.clear();
        dmgs.clear();
        speeds.clear();
        special.clear();
        fireRates.clear();
        accuracys.clear();
        types.clear();
        procChances.clear();
        powers.clear();
        slashs.clear();
        punctures.clear();
        impacts.clear();
        noises.clear();
    }

}
