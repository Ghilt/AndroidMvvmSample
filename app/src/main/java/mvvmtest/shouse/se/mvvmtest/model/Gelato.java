package mvvmtest.shouse.se.mvvmtest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ani on 2017-04-10.
 */

public class Gelato {

    @SerializedName("name") private String name;
    @SerializedName("hasGluten") private boolean hasGluten;

    public Gelato(String name, boolean hasGluten) {
        this.name = name;
        this.hasGluten = hasGluten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGluten() {
        return hasGluten;
    }

    public void setIsGluten(boolean hasGluten) {
        this.hasGluten = hasGluten;
    }
}
