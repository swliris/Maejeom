package com.limsungwoo.maejeom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, "maejeomdb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String maejeomTable = "create table tb_maejeom ("+
                "name text," +
                "cost integer," +
                "status integer)";

        try {
            db.execSQL(maejeomTable);
        } catch (Exception e) { // 오류가 발생하면?
            Log.e("createTable", "테이블 생성 오류 발생");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropSQL = "DROP TABLE tb_maejeom";
        db.execSQL(dropSQL);
        onCreate(db);
    }
}
