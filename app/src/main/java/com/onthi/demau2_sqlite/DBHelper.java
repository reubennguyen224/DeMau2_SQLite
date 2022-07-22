package com.onthi.demau2_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "NV.db";
    private Context context;
    private static final String TABLE_NAME = "employee";
    private static final String TABLE_VTRI = "vitri";
    private static final String TABLE_NVVT = "nhanvienvitri";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "tenNV";
    private static final String COLUMN_IDVT = "id";
    private static final String COLUMN_tenvti = "tenVT";
    private static final String COLUMN_motavti = "motaVT";
    private static final String COLUMN_namsinh = "namsinhNV";
    private static final String COLUMN_quequan = "quequanNV";
    private static final String COLUMN_trinhdo = "trinhdoNV";

    private static final String COLUMN_maNVVT = "id";
    private static final String COLUMN_maNV = "idNV";
    private static final String COLUMN_maVT = "idVT";
    private static final String COLUMN_time = "thoigian";
    private static final String COLUMN_mta = "mota";

    private static final String query = "CREATE TABLE " + TABLE_NAME + " (" +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME+" TEXT, "
            + COLUMN_namsinh + " INTEGER, "+
            COLUMN_quequan + " TEXT, "+
            COLUMN_trinhdo + " TEXT);";
    private static final String query1 = "CREATE TABLE " + TABLE_VTRI+ " ("+COLUMN_IDVT+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_tenvti + " TEXT, "+
            COLUMN_motavti + " TEXT);";
    private static final String query2 = "CREATE TABLE " + TABLE_NVVT+ " ("+COLUMN_maNVVT+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_maVT+ " INTEGER , "+
            COLUMN_maNV+ " INTEGER , "+
            COLUMN_time + " TEXT, "+
            COLUMN_mta + " TEXT, FOREIGN KEY("+COLUMN_maNV+") REFERENCES "+TABLE_NAME+"("+COLUMN_ID+"), "+
            " FOREIGN KEY("+COLUMN_maVT+") REFERENCES "+TABLE_VTRI+"("+COLUMN_IDVT+"));";

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
        sqLiteDatabase.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_VTRI);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NVVT);
        onCreate(sqLiteDatabase);
    }

    void addNV(String name, int namsinh, String quequan, String trinhdo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_namsinh, namsinh);
        cv.put(COLUMN_quequan, quequan);
        cv.put(COLUMN_trinhdo, trinhdo);

        long res = db.insert(TABLE_NAME, null, cv);
        if (res == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "Add Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void addVT(String tenVT, String motaVT){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_tenvti, tenVT);
        cv.put(COLUMN_motavti, motaVT);

        long res = db.insert(TABLE_VTRI, null, cv);
        if (res == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "Add Successfully!", Toast.LENGTH_SHORT).show();
        }

    }
    void addNVVT(int idNV, int idVT, String thoigian, String mota){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_maNV, idNV);
        cv.put(COLUMN_maVT, idVT);
        cv.put(COLUMN_time, thoigian);
        cv.put(COLUMN_mta, mota);

        long res = db.insert(TABLE_NVVT, null, cv);
        if (res == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "Add Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllVtri(){
        String query = "SELECT * FROM " + TABLE_VTRI;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllNVVT(){
        String query = "SELECT * FROM " + TABLE_NVVT;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor findNV(String key){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN_namsinh +" LIKE '"+key+"';";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor findVT(String key){
        String query = "SELECT * FROM " + TABLE_VTRI + " WHERE "+ COLUMN_tenvti+" LIKE '%"+key+"%';";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
