package com.squorpikkor.app.labaratory;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

//Created by Vadim on 21.05.2017.

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyBase";
    public static final int DB_VERSION = 1;
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String IMAGE_RESOURCE_ID = "IMAGE_RESOURCE_ID";
    public static final String TAB1_NAME = "TAB1_NAME";

    ContentValues cv = new ContentValues();
//    SQLiteDatabase db = dbHelper.

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TAB1_NAME + " ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + DESCRIPTION + " TEXT, "
                + IMAGE_RESOURCE_ID + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
