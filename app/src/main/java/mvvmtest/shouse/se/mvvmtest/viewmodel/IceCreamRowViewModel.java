package mvvmtest.shouse.se.mvvmtest.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import java.util.Observable;
import java.util.Observer;

import mvvmtest.shouse.se.mvvmtest.model.Gelato;

/**
 * Created by ani on 2017-04-10.
 */

public class IceCreamRowViewModel implements Observer {

    private Gelato iceCream;

    public ObservableField<String> name = new ObservableField<String>();
    public ObservableBoolean hasGluten = new ObservableBoolean();
    public ObservableInt calories = new ObservableInt();

    public IceCreamRowViewModel(@NonNull Gelato iceCream) {
        this.iceCream = iceCream;
        iceCream.addObserver(this);
        name.set(iceCream.getName());
        hasGluten.set(iceCream.isGluten());
        calories.set(123);
    }


    public void onPlusButtonClick(View view) {
        iceCream.increase();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
