package com.example.rvg.frequencyfinder.presenter;

import com.example.rvg.frequencyfinder.view.WordFrequencyListView;

/**
 * WordFrequencyListPresenter - responsible for providing interface to the view to use its method.
 * Created by RvG on 11/4/2015.
 */
public interface WordFrequencyListPresenter extends RootPresenter<WordFrequencyListView> {

    void getWordFrequencyList(String inputString);

    void getWordFrequencyListByRest();
}
