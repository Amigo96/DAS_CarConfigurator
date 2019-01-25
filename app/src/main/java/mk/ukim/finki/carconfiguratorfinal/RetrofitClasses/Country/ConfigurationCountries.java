package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ConfigurationCountries is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

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
