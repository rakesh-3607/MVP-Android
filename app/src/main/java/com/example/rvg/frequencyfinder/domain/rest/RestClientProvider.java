package com.example.rvg.frequencyfinder.domain.rest;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Singleton RestClientProvider to provide REST Client.
 *
 * Created by RvG on 11/6/2015.
 */
public class RestClientProvider {

    // TODO this is just for proof of concept with retrofit. Later this will be replaced by our server address
    private static final String ROOT_URL = "https://demo4462252.mockable.io";
    private static final int REQUEST_TIME_OUT = 20;

    private static RestClientProvider restClientProviderInstance = null;

    private RestClientProvider() {
        // Exists only to defeat instantiation.
    }

    /**
     * Create instance of RestClientProvider. If null create new else return existing instance.
     *
     * @return
     */
    public static RestClientProvider getInstance() {
        synchronized (RestClientProvider.class){};
        if(restClientProviderInstance == null) {
            restClientProviderInstance = new RestClientProvider();
        }
        return restClientProviderInstance;
    }

    /**
     * getRetrofitInstance returns the Instance of Retrofit which is required to make REST call.
     * set Base Url, set HTTP client, & gson for desreializing the response.
     * @return Retrofit
     */
    public Retrofit getRetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    /**
     *
     * OkHttpClient manages the HTTP connection client.
     * We can configure the custom configuration related to HTTP call here.
     *
     * @return
     */
    private OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS);
        return okHttpClient;
    }

}