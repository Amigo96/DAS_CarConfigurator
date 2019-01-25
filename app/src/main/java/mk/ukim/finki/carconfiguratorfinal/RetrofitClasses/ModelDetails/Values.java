package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Values is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class Values {

    @SerializedName("value")
    @Expose
    private double value;

    @SerializedName("unit")
    @Expose
    private String unit;

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
