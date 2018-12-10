package mk.ukim.finki.das.carconfigurator.ExtraClasses.ImageActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelStart {

    @SerializedName("vehicle")
    @Expose
    private PreURL vehicle;

    public PreURL getVehicle(){
        return vehicle;
    }

}
