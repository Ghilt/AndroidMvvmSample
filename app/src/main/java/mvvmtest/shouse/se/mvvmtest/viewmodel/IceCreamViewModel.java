package mvvmtest.shouse.se.mvvmtest.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;

import mvvmtest.shouse.se.mvvmtest.model.Gelato;

/**
 * Created by ani on 2017-04-10.
 */

public class IceCreamViewModel {

    private Gelato iceCream;

    public ObservableField<String> name = new ObservableField<String>();
    public ObservableBoolean hasGluten = new ObservableBoolean();
    public ObservableField<Integer> calories = new ObservableField<Integer>();

    public IceCreamViewModel(@NonNull Gelato iceCream) {
        this.iceCream = iceCream;
        name.set(iceCream.getName());
        hasGluten.set(iceCream.isGluten());
        calories.set(123);
    }

}
