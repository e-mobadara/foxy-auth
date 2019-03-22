package com.example.younes.testingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;

import org.w3c.dom.Text;


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

                gameStat.setApp_id("a");
                gameStat.setExercise_id("a");
                gameStat.setLevel_id("ab");
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
                FoxyAuth.storeGameStat(MainActivity.this,gameStat);
            }
        });

    }
}
