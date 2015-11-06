package com.example.rvg.frequencyfinder.androidinterface;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rvg.frequencyfinder.R;
import com.example.rvg.frequencyfinder.model.WordData;

import java.util.List;

/**
 * Created by RvG on 11/3/2015.
 */
public class WordFrequencyMapAdapter extends RecyclerView.Adapter<WordFrequencyMapAdapter.Holder> {

    List<WordData> mWordFrequencyDataList;

    public WordFrequencyMapAdapter(List<WordData> mWordFrequencyDataList) {
        //setHasStableIds(true);
        this.mWordFrequencyDataList = mWordFrequencyDataList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.frequency_row, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {


        holder.mWordNameTextView.setText(mWordFrequencyDataList.get(position).getWord());
        holder.mWordFrequencyTextView.setText(mWordFrequencyDataList.get(position).getCount()+"");
    }

    @Override
    public int getItemCount() {
        return mWordFrequencyDataList.size();

    }

//    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
//    }

    class Holder extends RecyclerView.ViewHolder {

        public TextView mWordNameTextView,mWordFrequencyTextView;

        public Holder(View itemView) {
            super(itemView);
            mWordNameTextView = (TextView) itemView.findViewById(R.id.fragment_wordfreq_word_textview);
            mWordFrequencyTextView = (TextView) itemView.findViewById(R.id.fragment_wordfreq_freq_textview);
        }
    }
}
