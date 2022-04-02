package com.tailorapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "customerinfo_db";
    public static final String CUSTABLE = "customerinfo_table";
    public static final String Toptable = "top_table";
    public static final String Salwartable = "salwar_table";
    public static final String Chaudidar = "chaudidar_table";
    public static final String Blause = "blause_table";

    public MyDbHandler(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table customerinfo_table (id integer PRIMARY KEY AUTOINCREMENT , name text, phonenumber text UNIQUE, email text)";
        db.execSQL(create);

        String query = "create table " + Toptable + "(fulllength text,chestround text,waistlength text,waistround text,seatlength text,seatround text,shoulder text,readyshoulder text,sleeveslength text,sleevesround text,frontneck text,backneck text,armhole text,Topbottom text)";
        db.execSQL(query);

        String Create = "create table " + Salwartable + "(fulllength text,seatround text,bottom text,beltlength text)";
        db.execSQL(Create);

        String Query = "create table " + Chaudidar + "(fulllength text,seatround text,bottomround text,kneelength text,Kneeround text)";
        db.execSQL(Query);

        String info = "create table " + Blause + "(fulllength text,chestround text,waistlength text,sleeveslength text,sleevesround text,frontneck text,backneck text,shoulder text,readyshoulder text,tuckspoint text,armhole text)";
        db.execSQL(info);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists customerinfo_table");
        db.execSQL("drop table if exists top_table");
        db.execSQL("drop table if exists salwar_table");
        db.execSQL("drop table if exists chaudidar_table");
        db.execSQL("drop table if exists blause_table");
        onCreate(db);
    }

    public boolean addCustomer(String Name, String PhoneNumber, String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", Name);
        values.put("phonenumber", PhoneNumber);
        values.put("email", Email);
        long r = db.insert("customerinfo_table", null, values);
        if (r == -1) return false;
        else {
            return true;
        }

    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from customerinfo_table order by id desc";
        return db.rawQuery(qry, null);

    }

    public boolean addtopinfo(String Fulllength, String Chestround, String Waistlength, String Waistround, String Seatlength, String Seatround, String Shoulder, String Readyshoulder, String Sleeveslength, String Sleevesround, String Frontneck, String Backneck, String Armhole, String Topbottom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("fulllength", Fulllength);
        values.put("chestround", Chestround);
        values.put("waistlength", Waistlength);
        values.put("waistround", Waistround);
        values.put("seatlength", Seatlength);
        values.put("seatround", Seatround);
        values.put("shoulder", Shoulder);
        values.put("readyshoulder", Readyshoulder);
        values.put("sleeveslength", Sleeveslength);
        values.put("sleevesround", Sleevesround);
        values.put("frontneck", Frontneck);
        values.put("backneck", Backneck);
        values.put("armhole", Armhole);
        values.put("topbottom", Topbottom);
        long r = db.insert(Toptable, null, values);
        return true;

    }

    public boolean addsalwarinfo(String Fulllength, String Seatround, String Bottom, String Beltlength) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fulllength", Fulllength);
        values.put("seatround", Seatround);
        values.put("bottom", Bottom);
        values.put("beltlength", Beltlength);
        long r = db.insert(Salwartable, null, values);
        return true;
    }

    public boolean addchuadidarinfo(String Fulllength, String Seatround, String Bottomround, String Kneelength, String Kneeround) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fulllength", Fulllength);
        values.put("seatround", Seatround);
        values.put("bottomround", Bottomround);
        values.put("kneelength", Kneelength);
        values.put("kneeround", Kneeround);
        long r = db.insert(Chaudidar, null, values);
        return true;
    }

    public boolean addblauseinfo(String Fulllength, String Chestround, String Waistlength, String Sleeveslength, String Sleevesround, String Frontneck, String Backneck, String Shoulder, String Readyshoulder, String Tuckspoint, String Armhole) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fulllength", Fulllength);
        values.put("chestround", Chestround);
        values.put("waistlength", Waistlength);
        values.put("sleeveslength", Sleeveslength);
        values.put("sleevesround", Sleevesround);
        values.put("frontneck", Frontneck);
        values.put("backneck", Backneck);
        values.put("shoulder", Shoulder);
        values.put("readyshoulder", Readyshoulder);
        values.put("tuckspoint", Tuckspoint);
        values.put("armhole", Armhole);
        long r = db.insert(Chaudidar, null, values);
        return true;
    }


}