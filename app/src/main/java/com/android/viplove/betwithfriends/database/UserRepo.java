package com.android.viplove.betwithfriends.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.viplove.betwithfriends.users.BetUser;

import java.util.ArrayList;

/**
 * Created by Viplove Prakash on 02-Jan-16.
 */
public class UserRepo extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "betwithfriends.db";

    private static final String USER_TABLE = "my_user_table";

    public static final String USER_COL_ID = "user_id";
    public static final String USER_COL_NAME = "user_name";
    public static final String USER_COL_AGE = "user_age";
    public static final String USER_COL_GENDER = "user_gender";
    public static final String USER_COL_MOBILE = "user_mobile";
    public static final String USER_COL_EMAIL = "user_email";
    public static final String USER_COL_PASSWORD = "user_pwd";
    public static final String USER_COL_COUNTRY = "user_country";
    public static final String USER_COL_SETTINGS = "user_settings";

    public UserRepo(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BET_TABLE = "CREATE TABLE " +
                USER_TABLE + "("
                + USER_COL_ID + " TEXT PRIMARY KEY,"
                + USER_COL_NAME + " TEXT"
                + USER_COL_AGE + " INTEGER,"
                + USER_COL_GENDER + " TEXT"
                + USER_COL_MOBILE + " TEXT"
                + USER_COL_EMAIL + " TEXT"
                + USER_COL_COUNTRY + " TEXT"
                + USER_COL_PASSWORD + " TEXT"
                + USER_COL_SETTINGS + " INTEGER"
                + ")";
        db.execSQL(CREATE_BET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void addNewUserRow(BetUser betUser) {

        ContentValues values = new ContentValues();
        values.put(USER_COL_ID, betUser.getUserId());
        values.put(USER_COL_NAME, betUser.getUserName());
        values.put(USER_COL_AGE, betUser.getUserAge());
        values.put(USER_COL_GENDER, betUser.getUserGender());
        values.put(USER_COL_MOBILE, betUser.getUserMobile());
        values.put(USER_COL_EMAIL, betUser.getUserEmail());
        values.put(USER_COL_COUNTRY, betUser.getUserCountry());
        values.put(USER_COL_PASSWORD, betUser.getUserPassword());
        values.put(USER_COL_SETTINGS, betUser.getUserOddsFormatSetting());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public BetUser findUserRow(String userId) {
        String query = "Select * FROM " + USER_TABLE + " WHERE " + USER_COL_ID + " =  \"" + userId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        BetUser userRow = new BetUser();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            userRow.setUserId(cursor.getString(0));
            userRow.setUserAge(Integer.parseInt(cursor.getString(1)));
            userRow.setUserName(cursor.getString(1));
            userRow.setUserGender(cursor.getString(2));
            cursor.close();
        } else {
            userRow = null;
        }
        db.close();
        return userRow;
    }

    public boolean deleteUserRow(String userId) {

        boolean result = false;

        String query = "Select * FROM " + USER_TABLE + " WHERE " + USER_COL_ID + " =  \"" + userId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        BetUser userRow = new BetUser();

        if (cursor.moveToFirst()) {
            userRow.setUserId(cursor.getString(0));
            db.delete(USER_TABLE, USER_COL_ID + " = ?",
                    new String[]{String.valueOf(userRow.getUserId())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void updateUserRow(String userNewOddsFormatSetting) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        BetUser userRow = new BetUser();

        values.put(USER_COL_SETTINGS, userNewOddsFormatSetting);

        db.update(USER_TABLE, values, USER_COL_ID + "=" + userRow.getUserId(), null);
        db.close(); // Closing database connection
    }

    public ArrayList getAllUserName() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  " + USER_COL_ID + " FROM " + USER_TABLE;

        ArrayList userList = new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                userList.add(cursor.getString(cursor.getColumnIndex(USER_COL_ID)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;

    }

}
