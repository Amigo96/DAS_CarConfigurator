package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * DealerAddress is a class that is connected to the Dealer api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class DealerAddress {

    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("zipCode")
    @Expose
    private String zipCode;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("countryIsoCode")
    @Expose
    private String countryIsoCode;

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }
}
