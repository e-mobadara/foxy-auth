package com.example.younes.testingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;

import java.sql.Time;


public class MainActivity extends AppCompatActivity {
    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoxyAuth.emerge(this,MainActivity.class);

        a = findViewById(R.id.test);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameStat gameStat = new GameStat();

                gameStat.setApp_id("2018_3_3_4");
                gameStat.setExercise_id("T_6_20");
                gameStat.setLevel_id("1");
                gameStat.setUpdated_at(new Time(System.currentTimeMillis()).toString());
                gameStat.setCreated_at(new Time(System.currentTimeMillis()).toString());
                gameStat.setSuccessful_attempts("10");
                gameStat.setFailed_attempts("11");
                gameStat.setMin_time_succeed_sec("20");
                gameStat.setAvg_time_succeed_sec("25");
                gameStat.setLongitude("0.554");
                gameStat.setLatitude("5.41141");
                FoxyAuth.storeGameStat(MainActivity.this,gameStat);
            }
        });

    }
}
