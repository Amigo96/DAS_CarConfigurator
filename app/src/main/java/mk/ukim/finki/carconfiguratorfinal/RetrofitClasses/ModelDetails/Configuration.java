package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Configuration is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class Configuration {

    @SerializedName("technicalInformation")
    @Expose
    private TechicalInformation technicalInformation;

    @SerializedName("_links")
    @Expose
    private ConfigurationLinks links;

    @SerializedName("initialPrice")
    @Expose
    private Price price;

    public TechicalInformation getTechnicalInformation(){
        return technicalInformation;
    }

    public ConfigurationLinks getLinks(){
        return links;
    }

    public Price getPrice() {
        return price;
    }
}