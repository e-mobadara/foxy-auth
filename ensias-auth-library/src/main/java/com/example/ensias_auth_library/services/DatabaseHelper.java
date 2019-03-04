package com.example.ensias_auth_library.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.ensias_auth_library.utils.AppConstants.DATABASE_NAME;
import static com.example.ensias_auth_library.utils.AppConstants.DATABASE_VERSION;
import static com.example.ensias_auth_library.utils.AppConstants.TABLE_GAME_STATS;

/**
 * Created by younes on 8/19/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper mDatabaseInstance = null;
    private Context mContext;

    private String a="id";
    private String b="id_application";
    private String c="id_apprenant";
    private String d="id_accompagnant";
    private String e="id_exercice";
    private String f="id_niveau";
    private String g="date_actuelle";
    private String h="heure_debut";
    private String i="heure_fin";
    private String j="Nombre_operation_reuss";
    private String k="Nombre_operation_echou";
    private String l="minimum_temps_operation_sec";
    private String m="moyen_temps_operation_sec";
    private String n="longitude";
    private String o="latitude";
    private String p="device";
    private String q="flag";

    public static DatabaseHelper getInstance(Context context){
        if (mDatabaseInstance == null){
            mDatabaseInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return mDatabaseInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table BasicInfoTable (" +
                "mac_address Text Not NULL," +
                "id_user Integer Not NULL," +
                "anomalie_state INTEGER NOT NULL );");
        db.execSQL("create table Organisations (" +
                "id INTEGER Not NULL," +
                "name TEXT Not NULL," +
                "description TEXT Not NULL," +
                "phone TEXT ," +
                "email TEXT ," +
                "address TEXT ," +
                "deleted_at TEXT ," +
                "created_at TEXT ," +
                "updated_at TEXT);");
        db.execSQL("create table Kids (" +
                "id INTEGER Not NULL," +
                "id_organisation INTEGER," +
                "first_name TEXT," +
                "last_name TEXT," +
                "gender TEXT," +
                "birthday TEXT," +
                "parent_email TEXT," +
                "deleted_at TEXT," +
                "created_at TEXT," +
                "updated_at TEXT);");
        db.execSQL("create table " + TABLE_GAME_STATS + "("
                + a + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + b + " VARCHAR(100),"
                + c + " VARCHAR(100),"
                + d + " VARCHAR(100),"
                + e + " VARCHAR(100),"
                + f + " VARCHAR(100),"
                + g + " VARCHAR(100),"
                + h + " VARCHAR(100),"
                + i + " VARCHAR(100),"
                + j + " INTEGER,"
                + k + " INTEGER,"
                + l + " INTEGER,"
                + m + " INTEGER,"
                + n + " DOUBLE,"
                + o + " DOUBLE,"
                + p + " VARCHAR(100),"
                + q + " BOOLEAN"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
