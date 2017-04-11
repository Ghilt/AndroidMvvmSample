package mvvmtest.shouse.se.mvvmtest.model;

import android.databinding.ObservableInt;

import com.google.gson.annotations.SerializedName;

import java.util.Observable;

/**
 * Created by ani on 2017-04-10.
 */

public class Gelato extends Observable{

    @SerializedName("name")
    private String name;
    @SerializedName("hasGluten")
    private boolean hasGluten;
    @SerializedName("likes")
    private int likes;

    public Gelato(String name, boolean hasGluten) {
        this.name = name;
        this.hasGluten = hasGluten;
    }

    public String getName() {
        return name;
    }

    public int getLikes() {
        return likes;
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

    public void increase() {
        likes++;
        setChanged();
        notifyObservers();
    }
}
