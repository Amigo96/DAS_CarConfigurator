package mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
