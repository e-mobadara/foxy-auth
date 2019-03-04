package com.example.ensias_auth_library.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ensias_auth_library.models.Assignments;
import com.example.ensias_auth_library.models.Enrollment;
import com.example.ensias_auth_library.models.GameStat;
import com.example.ensias_auth_library.models.Organisation;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.ensias_auth_library.utils.AppConstants.TABLE_GAME_STATS;

/**
 * Created by younes on 8/19/2018.
 */

public class DatabaseManager {
    private DatabaseHelper mDBHelper;
    private static DatabaseManager mDatabaseManager;
    private SQLiteDatabase mDatabase;
    Context mContext;
    Cursor authentificationDataCursor;
    SQLiteDatabase db;

    public DatabaseManager(Context context){
        mContext = context;
        mDBHelper = DatabaseHelper.getInstance(context);
        mDatabase  = mDBHelper.getWritableDatabase();
    }
    public static DatabaseManager getInstance(Context context){
        if (mDatabaseManager == null){
            mDatabaseManager = new DatabaseManager(context.getApplicationContext());
        }
        return mDatabaseManager;
    }

public void storeOrganisations(List<Organisation> organisationList){
    for(Organisation organisation: organisationList )
        storeOrganisation(organisation);
}
    public void storeOrganisation(Organisation organisation){
        if (mDatabase != null){
            //prepare the transaction information that will be saved to the database
            ContentValues organisationRow = new ContentValues();
            organisationRow.put("id", organisation.getId());
            organisationRow.put("name", organisation.getName());
            organisationRow.put("description", organisation.getDescription());
            organisationRow.put("phone", organisation.getPhone());
            organisationRow.put("email", organisation.getEmail());
            organisationRow.put("address", organisation.getAddress());
            organisationRow.put("deleted_at", organisation.getDeletedAt());
            organisationRow.put("created_at", organisation.getCreatedAt());
            organisationRow.put("updated_at", organisation.getUpdatedAt());


            try {
                mDatabase.insertOrThrow("organisations", null, organisationRow);
                Log.d("Database Insertion", "Organisation Added");

            } catch (Exception e) {
                Log.e("Database Insertion", "Error " + e.getCause() + " " + e.getMessage());
            }
        }
    }
    ///String Kid Data In localDB
    public void storeOrganisationsChildren(Assignments assignments ){
        for(Assignments.Assignment assignment : assignments.getAssignments())
            storeOrganisationChild(assignment);
    }
    public void storeParentChildren(List<Enrollment> enrollments ){
        for(Enrollment enrollment : enrollments)
            storeParentChild(enrollment);
    }
    public void storeOrganisationChild(Assignments.Assignment assignment){
        if (mDatabase != null){
            //prepare the transaction information that will be saved to the database
            ContentValues kidRow = new ContentValues();
            kidRow.put("id", assignment.getId());

            kidRow.put("id_organisation", assignment.getOrganisationId());

            kidRow.put("first_name", assignment.getKid().getFirstName());
            kidRow.put("last_name", assignment.getKid().getLastName());
            kidRow.put("gender", assignment.getKid().getGender());
            kidRow.put("birthday", assignment.getKid().getBirthday());
            kidRow.put("parent_email", assignment.getKid().getParentEmail());
            kidRow.put("deleted_at", assignment.getKid().getDeletedAt());
            kidRow.put("created_at", assignment.getKid().getCreatedAt());
            kidRow.put("updated_at", assignment.getKid().getUpdatedAt());


            try {
                mDatabase.insertOrThrow("kids", null, kidRow);
                Log.d("Database Insertion", "Kid ("+assignment.getId()+") Added");

            } catch (Exception e) {
                Log.e("Database Insertion", "Error " + e.getCause() + " " + e.getMessage());
            }
        }
    }
    public void storeParentChild(Enrollment enrollment){
        if (mDatabase != null){
            //prepare the transaction information that will be saved to the database
            ContentValues kidRow = new ContentValues();
            kidRow.put("id", enrollment.getKid().getId());

//            kidRow.put("id_organisation", assignment.getOrganisationId());

            kidRow.put("first_name", enrollment.getKid().getFirstName());
            kidRow.put("last_name", enrollment.getKid().getLastName());
            kidRow.put("gender", enrollment.getKid().getGender());
            kidRow.put("birthday", enrollment.getKid().getBirthday());
            kidRow.put("parent_email", enrollment.getKid().getParentEmail());
            kidRow.put("deleted_at", enrollment.getKid().getDeletedAt());
            kidRow.put("created_at", enrollment.getKid().getCreatedAt());
            kidRow.put("updated_at", enrollment.getKid().getUpdatedAt());


            try {
                mDatabase.insertOrThrow("kids", null, kidRow);
                Log.d("Database Insertion", "Kid ("+enrollment.getKid().getId()+") Added");

            } catch (Exception e) {
                Log.e("Database Insertion", "Error " + e.getCause() + " " + e.getMessage());
            }
        }
    }
    public void storeGameStat(GameStat gameStat){
        ContentValues gameStatRow = new ContentValues();
        gameStatRow.put("id_application", gameStat.getApp_id());
        gameStatRow.put("id_apprenant", gameStat.getChild_id());
        gameStatRow.put("id_accompagnant", gameStat.getUser_id());
        gameStatRow.put("id_exercice", gameStat.getExercise_id());
        gameStatRow.put("id_niveau", gameStat.getLevel_id());
        gameStatRow.put("date_actuelle", gameStat.getUpdated_at());
        gameStatRow.put("heure_debut", gameStat.getCreated_at());
        gameStatRow.put("heure_fin", gameStat.getUpdated_at());
        gameStatRow.put("Nombre_operation_reuss", gameStat.getSuccessful_attempts());
        gameStatRow.put("Nombre_operation_echou", gameStat.getFailed_attempts());
        gameStatRow.put("minimum_temps_operation_sec", gameStat.getMin_time_succeed_sec());
        gameStatRow.put("moyen_temps_operation_sec", gameStat.getAvg_time_succeed_sec());
        gameStatRow.put("longitude", gameStat.getLongitude());
        gameStatRow.put("latitude", gameStat.getLatitude());
        gameStatRow.put("device", gameStat.getDevice());
        gameStatRow.put("flag", gameStat.getFlag());

        try {
            mDatabase.insertOrThrow(TABLE_GAME_STATS, null, gameStatRow);
            Log.e("Database Insertion", "Game ("+ gameStat.getApp_id()+") Added");

        } catch (Exception e) {
            Log.e("Database Insertion", "Game Error " + e.getCause() + " " + e.getMessage());
        }
    }
    public int gameStatsRowCount (){
        int rowsNumber;
        db = mContext.openOrCreateDatabase("Game", MODE_PRIVATE,null);
        authentificationDataCursor = db.rawQuery("SELECT COUNT(*) FROM "+TABLE_GAME_STATS,null);
        authentificationDataCursor.moveToFirst();
        rowsNumber = authentificationDataCursor.getInt(0);
        db.close();
        return rowsNumber;
    }
}
