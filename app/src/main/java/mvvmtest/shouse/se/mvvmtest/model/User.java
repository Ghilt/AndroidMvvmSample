package mvvmtest.shouse.se.mvvmtest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ani on 2017-04-10.
 */

public class User implements Serializable {

    @SerializedName("name") private String name;
    @SerializedName("number")  private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
