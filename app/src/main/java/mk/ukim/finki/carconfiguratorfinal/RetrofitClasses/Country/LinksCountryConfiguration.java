package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * LinksCountryConfiguration is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class LinksCountryConfiguration {

    @SerializedName("self")
    @Expose
    private String self;

    @SerializedName("classes")
    @Expose
    private String classes;

    @SerializedName("bodies")
    @Expose
    private String bodies;

    @SerializedName("models")
    @Expose
    private String models;

    @SerializedName("productgroups")
    @Expose
    private String productgroups;

    public String getSelfLink(){
        return self;
    }

    public String getClassesLink(){
        return classes;
    }

    public String getBodiesLink(){
        return bodies;
    }

    public String getModelsLink(){
        return models;
    }

    @Override
    public String toString() {
        return "LinksCountryConfiguration{" +
                "self='" + self + '\'' +
                ", classes='" + classes + '\'' +
                ", bodies='" + bodies + '\'' +
                ", models='" + models + '\'' +
                ", productgroups='" + productgroups + '\'' +
                '}';
    }

    public String getProductgroupsLink(){
        return productgroups;
    }
}