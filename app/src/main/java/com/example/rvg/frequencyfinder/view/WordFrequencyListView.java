package com.example.rvg.frequencyfinder.view;

import com.example.rvg.frequencyfinder.model.WordData;

import java.util.HashMap;
import java.util.List;

/**
 * View for the main screen. It can be used by the presenter to perform any action on view once presenter has the
 * updated data from model.
 *
 * Created by RvG on 11/4/2015.
 */
public interface WordFrequencyListView extends RootView {

    void setWordFrequencyList(List<WordData> wordFrequencyList);
}
