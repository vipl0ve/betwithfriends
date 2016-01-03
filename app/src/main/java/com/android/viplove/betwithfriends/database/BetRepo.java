package com.android.viplove.betwithfriends.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.viplove.betwithfriends.bet.Bet;

import java.util.ArrayList;

/**
 * Created by Viplove Prakash on 02-Jan-16.
 */
public class BetRepo extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "betwithfriends.db";

    private static final String BET_TABLE = "my_bets_table";

    public static final String BET_COL_ID = "bet_id";
    public static final String BET_COL_NAME = "bet_name";
    public static final String BET_COL_DETAILS = "bet_details";
    public static final String BET_COL_EVENTS_COUNT = "bet_events_count";
    public static final String BET_COL_EVENTS_NAME = "bet_events_name";
    public static final String BET_COL_EVENTS_PROBABILITY = "bet_events_probability";
    public static final String BET_COL_TOTAL_PROBABILITY = "bet_total_probability";
    public static final String BET_COL_EVENTS_ODDS = "bet_events_odds";

    public BetRepo(Context context, String name,
                   SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BET_TABLE = "CREATE TABLE " +
                BET_TABLE + "("
                + BET_COL_ID + " INTEGER PRIMARY KEY,"
                + BET_COL_NAME + " TEXT,"
                + BET_COL_DETAILS + " TEXT"
                + BET_COL_EVENTS_COUNT + " TEXT"
                + BET_COL_EVENTS_NAME + " TEXT"
                + BET_COL_EVENTS_PROBABILITY + " TEXT"
                + BET_COL_EVENTS_ODDS + " TEXT"
                + BET_COL_TOTAL_PROBABILITY + " TEXT"
                + ")";
        db.execSQL(CREATE_BET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BET_TABLE);
        onCreate(db);
    }

    public void addNewBetRow(Bet bet) {

        ContentValues values = new ContentValues();
        values.put(BET_COL_ID, bet.getBetId());
        values.put(BET_COL_NAME, bet.getBetName());
        values.put(BET_COL_DETAILS, bet.getBetDetails());
        values.put(BET_COL_EVENTS_COUNT, bet.getEventCount());
        values.put(BET_COL_EVENTS_NAME, bet.getEventNameString());
        values.put(BET_COL_EVENTS_PROBABILITY, bet.getEventProbabilityString());
        values.put(BET_COL_EVENTS_ODDS, bet.getEventOddString());
        values.put(BET_COL_TOTAL_PROBABILITY, bet.getEventProbabilitySum());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(BET_TABLE, null, values);
        db.close();
    }

    public Bet findBetRow(String betName) {
        String query = "Select * FROM " + BET_TABLE + " WHERE " + BET_COL_NAME + " =  \"" + betName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Bet betRow = new Bet();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            betRow.setBetId(Integer.parseInt(cursor.getString(0)));
            betRow.setBetName(cursor.getString(1));
            betRow.setBetDetails(cursor.getString(2));
            cursor.close();
        } else {
            betRow = null;
        }
        db.close();
        return betRow;
    }

    public boolean deleteBetRow(String betName) {

        boolean result = false;

        String query = "Select * FROM " + BET_TABLE + " WHERE " + BET_COL_NAME + " =  \"" + betName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Bet betRow = new Bet();

        if (cursor.moveToFirst()) {
            betRow.setBetId(Integer.parseInt(cursor.getString(0)));
            db.delete(BET_TABLE, BET_COL_ID + " = ?",
                    new String[]{String.valueOf(betRow.getBetId())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void updateBetRow(String betName) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        Bet betRow = new Bet();

        values.put(BET_COL_ID, betRow.getBetId());

        db.update(BET_TABLE, values, BET_COL_ID + "=" + betRow.getBetId(), null);
        db.close(); // Closing database connection
    }

    public ArrayList getAllBetName() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  " + BET_COL_NAME + " FROM " + BET_TABLE;

        ArrayList betList = new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                betList.add(cursor.getString(cursor.getColumnIndex(BET_COL_NAME)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return betList;

    }

}
