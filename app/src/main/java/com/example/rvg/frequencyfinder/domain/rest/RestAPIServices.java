package com.example.rvg.frequencyfinder.domain.rest;

import com.example.rvg.frequencyfinder.model.RestData;

import retrofit.Call;
import retrofit.http.GET;

/**
 * We have to define all the REST service here.
 *
 * Created by RvG on 11/5/2015.
 */
public interface RestAPIServices {

    /**
     * loadString - get the String from the REST API with Path - /api/testmock after Base URL
     * @return
     */
    @GET("/api/testmock")
    Call<RestData> loadString();

}
