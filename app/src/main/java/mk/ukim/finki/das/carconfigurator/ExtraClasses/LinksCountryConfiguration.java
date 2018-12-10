package mk.ukim.finki.das.carconfigurator.ExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
