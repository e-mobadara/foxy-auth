package com.example.younes.testingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoxyAuth.emerge(this,MainActivity.class);
        GameStat gameStat = new GameStat();

        gameStat.setApp_id("a");
        gameStat.setExercise_id("a");
        gameStat.setLevel_id("a");
        gameStat.setUpdated_at("a");
        gameStat.setCreated_at("a");
        gameStat.setGame_date_id("a");
        gameStat.setSuccessful_attempts("a");
        gameStat.setFailed_attempts("a");
        gameStat.setMin_time_succeed_sec("a");
        gameStat.setAvg_time_succeed_sec("a");
        gameStat.setLongitude("a");
        gameStat.setLatitude("a");
        gameStat.setDevice("a");
        gameStat.setFlag("a");
        FoxyAuth.storeGameStat(this,gameStat);
    }
}
