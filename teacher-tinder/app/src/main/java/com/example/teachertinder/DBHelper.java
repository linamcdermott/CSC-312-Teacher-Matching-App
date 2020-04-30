package com.example.teachertinder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TeacherTinder.db";
    public static final String TABLE_NAME1 = "teachers";
    public static final String TABLE_NAME2 = "schools";
    public static final String TABLE_NAME3 = "jobOpenings";
    public static final String COL_11 = "ID";
    public static final String COL_12 = "NAME";
    public static final String COL_13 = "SURNAME";
    public static final String COL_14 = "USER";
    public static final String COL_15 = "PASSWORD";
    public static final String COL_16 = "EXPERIENCE";
    public static final String COL_17 = "SUBJTAUGHT";
    public static final String COL_18 = "PREFERREDREGION";
    public static final String COL_19 = "CERTIFICATES";
    public static final String COL_110 = "BIO";
    public static final String COL_24 = "ADDRESS";
    public static final String COL_25 = "JOBSAVAILABLE";
    public static final String COL_33 = "POSITION";
    public static final String COL_34 = "DESCRIPTION";
    public static final String COL_35 = "SALARY";


    public static final String TABLE_NAME_2 = "schools";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,USER TEXT, PASSWORD TEXT, EXPERIENCE INTEGER, SUBJTAUGHT TEXT, PREFERREDREGION TEXT, CERTIFICATES TEXT, BIO TEXT)");
        db.execSQL("create table " + TABLE_NAME2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,USER TEXT,PASSWORD TEXT, ADDRESS TEXT, JOBSAVAILABLE TEXT)");
        db.execSQL("create table " + TABLE_NAME3 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,POSITION TEXT,DESCRIPTION TEXT, SALARY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        onCreate(db);
    }

    public boolean insertTeacherData(String name,String surname,String user,String password, String exp, String subj, String preferred, String cert, String bio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_12,name);
        contentValues.put(COL_13,surname);
        contentValues.put(COL_14,user);
        contentValues.put(COL_15,password);
        contentValues.put(COL_16,exp);
        contentValues.put(COL_17,subj);
        contentValues.put(COL_18,preferred);
        contentValues.put(COL_19,cert);
        contentValues.put(COL_110,bio);
        long result = db.insert(TABLE_NAME1,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean updateTeacherData(String id, String name,String surname,String user,String password, String exp, String subj, String preferred, String cert, String bio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,id);
        contentValues.put(COL_12,name);
        contentValues.put(COL_13,surname);
        contentValues.put(COL_14,user);
        contentValues.put(COL_15,password);
        contentValues.put(COL_16,exp);
        contentValues.put(COL_17,subj);
        contentValues.put(COL_18,preferred);
        contentValues.put(COL_19,cert);
        contentValues.put(COL_110,bio);
        db.update(TABLE_NAME1, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteTeacherData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME1, "ID = ?",new String[] {id});
    }
    public boolean insertSchoolData(String name,String user,String password, String address, Integer jobsAvailable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_12,name);
        contentValues.put(COL_14,user);
        contentValues.put(COL_15,password);
        contentValues.put(COL_24,address);
        contentValues.put(COL_25,jobsAvailable);
        long result = db.insert(TABLE_NAME2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean updateTeacherData(String id, String name, String user,String password, String address, Integer jobsAvailable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,id);
        contentValues.put(COL_12,name);
        contentValues.put(COL_14,user);
        contentValues.put(COL_15,password);
        contentValues.put(COL_24,address);
        contentValues.put(COL_25,jobsAvailable);
        db.update(TABLE_NAME2, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteSchoolData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "ID = ?",new String[] {id});
    }
    public boolean insertJobData(String name,String position,String description, Integer salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_12,name);
        contentValues.put(COL_33,position);
        contentValues.put(COL_34,description);
        contentValues.put(COL_35,salary);
        long result = db.insert(TABLE_NAME3,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean updateJobData(String id, String name,String position,String description, Integer salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,id);
        contentValues.put(COL_12,name);
        contentValues.put(COL_12,name);
        contentValues.put(COL_33,position);
        contentValues.put(COL_34,description);
        contentValues.put(COL_35,salary);
        db.update(TABLE_NAME3, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteJobData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME3, "ID = ?",new String[] {id});
    }
}
