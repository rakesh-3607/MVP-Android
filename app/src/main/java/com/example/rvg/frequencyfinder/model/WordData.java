package com.example.rvg.frequencyfinder.model;

import java.util.Comparator;

/**
 *
 * WordData - stores the unique word name & its occurrence in whole sentence.
 * It implements the Comparable interface to make natural sorting of count in desceednig way.
 *
 * Created by RvG on 11/5/2015.
 */
public class WordData implements Comparable<WordData>{
    // Represents the data we need about a word:  the word and
    // the number of times it has been encountered.
    public String word;
    public int count;

    public WordData(String w) {
        // Constructor for creating a WordData object when
        // we encounter a new word.
        word = w;
        count = 1;  // The initial value of count is 1.
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(WordData wordData) {
        int compareFrequency = ((WordData) wordData).getCount();
        // Descending order
        return compareFrequency - this.count;
    }

    /**
     * WordNameComparator - To make alphabetical sorting.
     */
    public static Comparator<WordData> WordNameComparator
            = new Comparator<WordData>() {
        @Override
        public int compare(WordData wordData1, WordData wordData2) {

            String word1 = wordData1.getWord();
            String word2 = wordData2.getWord();

            //ascending order sort by word name.
            return wordData1.compareTo(wordData2);
        }
    };

}
