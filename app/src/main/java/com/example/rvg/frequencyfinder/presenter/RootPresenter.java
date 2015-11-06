package com.example.rvg.frequencyfinder.presenter;

/**
 *
 * Root presenter for all the other custom interfaces. It uses the abstarct View - which can be defined in the overridding
 * interface by the View it is attached to.
 * Created by RvG on 11/4/2015.
 */
public interface RootPresenter<V> {
    void setView(V view);
}
