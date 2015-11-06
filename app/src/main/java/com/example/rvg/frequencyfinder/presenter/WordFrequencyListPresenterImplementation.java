package com.example.rvg.frequencyfinder.presenter;

import android.util.Log;

import com.example.rvg.frequencyfinder.domain.inputhandler.RestAPIInputHandler;
import com.example.rvg.frequencyfinder.domain.processoralgorithm.AlgorithmChooser;
import com.example.rvg.frequencyfinder.domain.processoralgorithm.ConcreteAlgorithm2;
import com.example.rvg.frequencyfinder.domain.rest.RestAPIServices;
import com.example.rvg.frequencyfinder.domain.rest.RestClientProvider;
import com.example.rvg.frequencyfinder.model.RestData;
import com.example.rvg.frequencyfinder.model.WordData;
import com.example.rvg.frequencyfinder.view.WordFrequencyListView;

import java.util.HashMap;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Actual actions for the wordFrequency will be impleménted here. It Implements the WordFrequencyListPresenter
 * interface so it can override the features which are required. It will be instantiated in the view which wants to use it.
 *
 * Created by RvG on 11/4/2015.
 */
public class WordFrequencyListPresenterImplementation implements WordFrequencyListPresenter {

    final String TAG = "WORD FREQUENCY TAG";
    WordFrequencyListView wordFrequencyListView;
    private HashMap<String, Integer> mWordFrequencyHashMap;
    private List<WordData> wordDataList;

    /**
     * Handles the click event of Input text resource
     * @param inputString
     */

    @Override
    public void getWordFrequencyList(String inputString) {
        AlgorithmChooser algorithmChooser2 = new AlgorithmChooser(new ConcreteAlgorithm2());
        wordDataList = algorithmChooser2.processInputString(inputString);
        // Now we have list & Set it to view
        wordFrequencyListView.setWordFrequencyList(wordDataList);

    }

    /**
     * Handles Get String from REST interface.
     */
    @Override
    public void getWordFrequencyListByRest() {
        final AlgorithmChooser algorithmChooser2 = new AlgorithmChooser(new ConcreteAlgorithm2());
        RestAPIServices restAPIServices =  RestClientProvider.getInstance().getRetrofitInstance().create(RestAPIServices.class);

        Call<RestData> restDataCallSession = restAPIServices.loadString();
        restDataCallSession.enqueue(new Callback<RestData>() {
            @Override
            public void onResponse(Response<RestData> response, Retrofit retrofit) {

                Log.i(TAG, response.isSuccess()+"");
                Log.i(TAG, response.body().string_test);
                /**
                 * Check if the REST API call is success.
                 */
                if(response.isSuccess()){
                    wordDataList = algorithmChooser2.processInputString(response.body().string_test);
                    // Now we have list & Set it to view
                    wordFrequencyListView.setWordFrequencyList(wordDataList);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, t.getLocalizedMessage());
            }
        });
    }

    /**
     * To let presenter to update View This method is overridden.
     * This presenter can update the view using the object of wordFrequencyListView.
     * Activity which implements this wordFrequencyListView. need to set this view from client side.
     * @param view
     */
    @Override
    public void setView(WordFrequencyListView view) {
        this.wordFrequencyListView = view;
    }
}
