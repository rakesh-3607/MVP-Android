package com.example.rvg.frequencyfinder.domain.processoralgorithm;

import com.example.rvg.frequencyfinder.model.WordData;

import java.util.HashMap;
import java.util.List;

/**
 * It is implemented as the strategy pattern.
 * To let the client decide what algorithm it wants to use.
 * Created by RvG on 11/2/2015.
 */
public class AlgorithmChooser {
    StringProcessingAlgorithm stringProcessingAlgorithm;

    public AlgorithmChooser(StringProcessingAlgorithm stringProcessingAlgorithm) {
        this.stringProcessingAlgorithm = stringProcessingAlgorithm;
    }

    public StringProcessingAlgorithm getStringProcessingAlgorithm() {
        return stringProcessingAlgorithm;
    }

    public void setStringProcessingAlgorithm(StringProcessingAlgorithm stringProcessingAlgorithm) {
        this.stringProcessingAlgorithm = stringProcessingAlgorithm;
    }

    public List<WordData> processInputString(String inputString){
        return stringProcessingAlgorithm.processInputString(inputString);
    }


}
