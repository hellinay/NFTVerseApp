package com.project.nftverse;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class assetModelTable {
    public static String TABLE_NAME="nftworld";
    public static String FIELD_ID = "asset_id";
    public static String FIELD_IMG = "image_url";
    public static String FIELD_NAME = "name";
    public static String FIELD_URL = "external_link";
    public static String FIELD_PRICE = "price";
    public static String FIELD_SELLER = "owned_by";
    public static String FIELD_DESC = "description";
    public static String FIELD_FAV = "is_fav";

    public static String CREATE_TABLE_SQL="CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" number, "+FIELD_NAME+" text,)";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<String> INSERT_RECORD_SQL_LIST = new ArrayList<String>(){
        {
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+", "+FIELD_NAME+") values ( 1, 'abc') ");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+", "+FIELD_NAME+") values ( 2, 'xyz') ");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+", "+FIELD_NAME+") values ( 3, 'mnf') ");
        }
    };

    public static ArrayList<assetModel>  getAllFlags(DatabaseHelper dbHelper){
        assetModel anItem;
        ArrayList<assetModel> data = new ArrayList<>();
        Cursor cursor = dbHelper.getAllRecords(TABLE_NAME, null);
        Log.d("DATABASE OPERATIONS", cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] flg = cursor.getBlob(2);
            anItem = new assetModel(1, "1","1", "1", "1", "1", "1", "1");
            data.add(anItem);
            Log.d("DATABASE OPERATIONS",anItem.toString());
        }
        return data;
    }
}
