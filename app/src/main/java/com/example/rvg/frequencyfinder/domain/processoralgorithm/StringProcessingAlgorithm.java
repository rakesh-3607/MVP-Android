package com.example.rvg.frequencyfinder.domain.processoralgorithm;

import com.example.rvg.frequencyfinder.model.WordData;

import java.util.HashMap;
import java.util.List;

/**
 * Interface which can be implemented by concrete algorithms. This is done in order to have flexibility on changing
 * algorithm during later stage in the development.
 * Created by RvG on 11/2/2015.
 */
public interface StringProcessingAlgorithm {

    /**
     * processInputString
     *
     * @param inputString
     * @return
     */
    public List<WordData> processInputString(String inputString);
}
