package mvvmtest.shouse.se.mvvmtest.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.google.gson.Gson;

import mvvmtest.shouse.se.mvvmtest.R;
import mvvmtest.shouse.se.mvvmtest.model.User;

/**
 * Created by ani on 2017-04-07.
 */

public class ProfileInfoViewModel extends BaseObservable {

    public ObservableField<String> name = new ObservableField<String>(); //Observed data bound field
    public ObservableField<String> phoneNumber = new ObservableField<String>();

    private Context context;
    private User user;

    public ProfileInfoViewModel(Context context, User u) {
        this.context = context;
        this.user = u;
        if (user == null) {
            user = new User();
        }
        name.set(user.getName());
        phoneNumber.set(user.getNumber());
    }

    public void onSaveButtonClick(View view) {
        user.setName(name.get());
        user.setNumber(phoneNumber.get());
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        prefs.edit().putString(context.getString(R.string.prefs_key_user), new Gson().toJson(user)).apply();
    }

}
