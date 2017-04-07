package mvvmtest.shouse.se.mvvmtest;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by ani on 2017-04-07.
 */

public class ProfileInfoViewModel extends BaseObservable {

    public ObservableField<String> name = new ObservableField<String>(); //Observed data bound field

    public void onButtonClick(View view) {
        name.set("schduoo"); // WHY DOES THIS NOT SET THE VALUE?
    }

}
