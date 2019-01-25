package mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
