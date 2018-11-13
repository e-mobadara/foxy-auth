package com.example.younes.testingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ensias_auth_library.FoxyAuth;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoxyAuth.emerge(this,MainActivity.class);
    }
}
