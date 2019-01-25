package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * CarEngine is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class CarEngine {

    @SerializedName("fuelType")
    @Expose
    private String fuel_type;

    @SerializedName("alternativeFuelType")
    @Expose
    private String alternative_fuel_type;

    @SerializedName("engineConcept")
    @Expose
    private String engine_concept;

    @SerializedName("driveConcept")
    @Expose
    private String drive_concept;

    @SerializedName("fuelEconomy")
    @Expose
    private FuelEconomy fuel;

    @SerializedName("powerHp")
    @Expose
    private Values engine_power;

    @SerializedName("powerKw")
    @Expose
    private Values engine_kw;

    @SerializedName("cylinder")
    @Expose
    private int engine_cilinders;

    @SerializedName("emissionStandard")
    @Expose
    private String emission_standard;

    public String getFuel_type() {
        return fuel_type;
    }

    public String getAlternative_fuel_type() {
        return alternative_fuel_type;
    }

    public String getEngine_concept() {
        return engine_concept;
    }

    public String getDrive_concept() {
        return drive_concept;
    }

    public FuelEconomy getFuel() {
        return fuel;
    }

    public Values getEngine_power() {
        return engine_power;
    }

    public Values getEngine_kw() {
        return engine_kw;
    }

    public int getEngine_cilinders() {
        return engine_cilinders;
    }

    public String getEmission_standard() {
        return emission_standard;
    }

}
