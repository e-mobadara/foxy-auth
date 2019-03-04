package com.example.ensias_auth_library;

import android.content.Context;
import android.content.Intent;


import com.example.ensias_auth_library.models.GameStat;
import com.example.ensias_auth_library.services.DatabaseManager;
import com.example.ensias_auth_library.ui.activities.LoginActivity;
import com.example.ensias_auth_library.utils.CrossVariables;

/**
 * Created by younes on 11/13/2018.
 */

public class FoxyAuth {

    public static void emerge(Context context,Class mainActivityName){
        if(!CrossVariables.authIsAlreadyShown)
            startAuthActivity(context);
        CrossVariables.mainActivityName = mainActivityName;
    }
    private static void startAuthActivity(Context context){
        CrossVariables.authIsAlreadyShown = true;
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void storeGameStat(Context context, GameStat gameStat){
        DatabaseManager.getInstance(context).storeGameStat(gameStat);
    }
}
