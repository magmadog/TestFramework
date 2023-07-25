package com.example.common.api.service;

import com.example.common.api.model.Token;
import com.example.common.api.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetService implements Callback<Token> {

    public static final String BASE_URL = "https://ce65cd12-1adc-4083-be88-f56494a90f18.mock.pstmn.io";

    public void getToken(User user) throws IOException {
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Response<Token> response = apiService
                .getAuthTokenByLoginAndPassword(user.getLogin(), user.getPassword())
                .execute();
        assert response.body() != null;

        user.setAuthToken(response.body().getToken());
    }

    @Override
    public void onResponse(Call<Token> call, Response<Token> response) {
        if(response.isSuccessful()) {
            Token token = response.body();
            System.out.println(token);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Token> call, Throwable t) {
        t.printStackTrace();
    }
}
