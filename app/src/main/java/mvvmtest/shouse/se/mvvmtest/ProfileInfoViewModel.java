package mvvmtest.shouse.se.mvvmtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

/**
 * Created by ani on 2017-04-07.
 */

public class ProfileInfoViewModel extends BaseObservable {

    private ObservableField<String> name = new ObservableField<String>();

    @Bindable
    public String getName() {
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);
    }

}
