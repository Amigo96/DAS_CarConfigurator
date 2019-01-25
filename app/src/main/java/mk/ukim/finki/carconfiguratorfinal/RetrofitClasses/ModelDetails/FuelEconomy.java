package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * FuelEconomy is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class FuelEconomy {

    @SerializedName("fuelConsumptionCityMin")
    @Expose
    private Values fuel_consumin_city_min;

    @SerializedName("fuelConsumptionCityMax")
    @Expose
    private Values fuel_consumin_city_max;

    @SerializedName("fuelConsumptionOverlandMin")
    @Expose
    private Values fuel_consumin_overlan_min;

    @SerializedName("fuelConsumptionOverlandMax")
    @Expose
    private Values fuel_consumin_overlan_max;

    @SerializedName("fuelConsumptionCombinedMin")
    @Expose
    private Values fuel_consumin_combined_min;

    @SerializedName("fuelConsumptionCombinedMax")
    @Expose
    private Values fuel_consumin_combined_max;

    @SerializedName("emissionCO2Min")
    @Expose
    private Values emission_co2_min;

    @SerializedName("emissionCO2Max")
    @Expose
    private Values emission_co2_max;

    public Values getFuel_consumin_city_min() {
        return fuel_consumin_city_min;
    }

    public Values getFuel_consumin_city_max() {
        return fuel_consumin_city_max;
    }

    public Values getFuel_consumin_overlan_min() {
        return fuel_consumin_overlan_min;
    }

    public Values getFuel_consumin_overlan_max() {
        return fuel_consumin_overlan_max;
    }

    public Values getFuel_consumin_combined_min() {
        return fuel_consumin_combined_min;
    }

    public Values getFuel_consumin_combined_max() {
        return fuel_consumin_combined_max;
    }

    public Values getEmission_co2_min() {
        return emission_co2_min;
    }

    public Values getEmission_co2_max() {
        return emission_co2_max;
    }
}

