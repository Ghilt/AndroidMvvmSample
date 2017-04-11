package mvvmtest.shouse.se.mvvmtest.viewmodel;

import android.databinding.ObservableField;

import java.util.Observable;
import java.util.Observer;

import mvvmtest.shouse.se.mvvmtest.model.Gelato;

/**
 * Created by ani on 2017-04-11.
 */

public class IceCreamListViewModel implements Observer {

    public ObservableField<String> currentLiked = new ObservableField<String>();

    @Override
    public void update(Observable observable, Object o) {
        Gelato c = (Gelato)  observable;
        currentLiked.set(c.getName() + " : " + c.getLikes());
    }
}
