package com.example.rvg.frequencyfinder.domain.inputhandler;

import android.util.Log;

import com.example.rvg.frequencyfinder.domain.rest.RestAPIServices;
import com.example.rvg.frequencyfinder.model.RestData;

import java.util.logging.Logger;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 *
 *Not used. Logic is managed from singleton RestProvider.
 * Created by RvG on 11/2/2015.
 */
public class RestAPIInputHandler {

    public String getDataFromRest(){

        final String BASEURL = "https://demo4462252.mockable.io";

        final RestData[] restDataResponse = new RestData[1];

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPIServices restAPIServices = retrofit.create(RestAPIServices.class);
        Call<RestData> restDataCallSession = restAPIServices.loadString();
        restDataCallSession.enqueue(new Callback<RestData>() {
            @Override
            public void onResponse(Response<RestData> response, Retrofit retrofit) {

                restDataResponse[0] = response.body();
                Log.i("Frequency", response.body().string_test);
                Log.i("Frequency", restDataResponse[0].string_test);

            }
            @Override
            public void onFailure(Throwable t) {
                Log.i("Frequency", t.getLocalizedMessage());
            }
        });

        return restDataResponse[0].string_test;
    }

}
