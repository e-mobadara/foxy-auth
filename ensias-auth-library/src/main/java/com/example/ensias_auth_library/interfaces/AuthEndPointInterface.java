package com.example.ensias_auth_library.interfaces;

import com.example.ensias_auth_library.models.Assignments;
import com.example.ensias_auth_library.models.GameStat;
import com.example.ensias_auth_library.models.UserAssignmentsRequestBody;
import com.example.ensias_auth_library.models.UserInfo;
import com.example.ensias_auth_library.models.UserLoginInfo;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by younes on 8/19/2018.
 */

public interface AuthEndPointInterface {

    @POST("api/v1/login")
    Call<UserInfo> getUserInfo(@Body UserLoginInfo userLoginInfo);
    @POST("api/v1/userAssignments")
    Call<Assignments> getUserOrganisationAssignments(@Body UserAssignmentsRequestBody userAssignmentsRequestBody, @Header("Authorization") String authHeader);
    @POST("fcdba0dd-a6be-4046-bc97-f75542cc6d48")
    Call<RequestBody> sendGameInfo(@Body GameStat gameStat, @Header("Authorization") String authHeader);
}
