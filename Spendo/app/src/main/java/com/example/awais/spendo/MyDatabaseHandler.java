package com.example.awais.spendo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by awais on 7/25/2017.
 */

public class MyDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME =  "SpendoDB";
    private static final String DB_TABLE1 = "Categories";
    private static final String DB_TABLE2 = "Expense";

    public MyDatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("dbCreation", "onCreate: ");

        String CREATE_CAT_TABLE = "CREATE TABLE " + DB_TABLE1 + "( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "catName TEXT )";
        String CREATE_EXP_TABLE = "CREATE TABLE " + DB_TABLE2 + "( " +
                "expense_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "expense_amount INTEGER, cat_id INTEGER NOT NULL, expense_DateTime DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY(cat_id) REFERENCES Categories(id) )";

        db.execSQL(CREATE_EXP_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Categories");
        db.execSQL("DROP TABLE IF EXISTS Expense");
        this.onCreate(db);
    }

    private static final String KEY_ID = "id";
    private static final String KEY_CATNAME = "catName";
    private static final String[] COLUMNS = {KEY_ID,KEY_CATNAME};

    public void addCategory(Category cat){
        Log.d("addCategory", "adding");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATNAME, cat.getCatName());
        db.insert(DB_TABLE1,null,values);
        db.close();
    }
    public long addExpense(Expense exp){
        Log.d("tag", "adding expense to database ");
        long c = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("tag", "database open");
        ContentValues values = new ContentValues();
        values.put("expense_amount", exp.getExpenseAmount());
        values.put("cat_id", exp.getCat_id());
        try {
            Log.d("tag", "try k ander");
            c = db.insert(DB_TABLE2, null, values);
        }catch (SQLException e){
            Log.d("tag", "try k ander");
            e.printStackTrace();
        }
        db.close();
        return c;
    }

    public int getSumOfCategory(int id) {

        String query = "SELECT SUM(expense_amount) FROM " + DB_TABLE2 + " where cat_id = '"+id+"' ";
        Cursor cursor = null;

        SQLiteDatabase db = this.getWritableDatabase();
        try{
            cursor = db.rawQuery(query, null);
        }catch (SQLException e){
            e.printStackTrace();
        }
        int sum = 0;

        if (cursor != null && cursor.moveToFirst()) {

            sum = cursor.getInt(0);
        }
        return sum;
    }
}