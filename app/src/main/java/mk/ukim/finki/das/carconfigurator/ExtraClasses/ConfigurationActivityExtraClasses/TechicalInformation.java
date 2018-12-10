package mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechicalInformation {

    @SerializedName("engine")
    @Expose
    private CarEngine engine;

    @SerializedName("topSpeed")
    @Expose
    private Values topSpeed;

    @SerializedName("doors")
    @Expose
    private int number_of_doors;

    @SerializedName("seats")
    @Expose
    private int number_of_seats;

    @SerializedName("acceleration")
    @Expose
    private Values acceleration;

    public CarEngine getEngine() {
        return engine;
    }

    public Values getTopSpeed() {
        return topSpeed;
    }

    public int getNumber_of_doors() {
        return number_of_doors;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public Values getAcceleration(){ return acceleration; }

}
