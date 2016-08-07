package com.webhawksit.rio.loginregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WebHabhawksIT on 8/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABSE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " + "name text not null, email text not null, username text not null, password text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.db = sqLiteDatabase;
    }


    public void insertUser(User user) {
        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        contentValues.put(COLUMN_ID, count);
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_EMAIL, user.getEmail());
        contentValues.put(COLUMN_UNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }


    public String searchPass(String username) {
        db = this.getReadableDatabase();
        String query = "select username,password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String user, pass;
        pass = "Not Found";
        if (cursor.moveToFirst()) {
            do {
                user = cursor.getString(0);
                if (user.equals(username)) {
                    pass = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return pass;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.onCreate(sqLiteDatabase);
    }
}
