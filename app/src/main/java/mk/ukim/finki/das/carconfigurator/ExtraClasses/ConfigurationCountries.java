package mk.ukim.finki.das.carconfigurator.ExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
//import java.util.TreeMap;

public class ConfigurationCountries {

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("_links")
    @Expose
    private LinksCountryConfiguration links;

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public LinksCountryConfiguration getAllLinks(){
        return links;
    }
}
