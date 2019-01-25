package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Price is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class Price {

    @SerializedName("price")
    @Expose
    private double price;

    @SerializedName("netPrice")
    @Expose
    private double netPrice;

    @SerializedName("currency")
    @Expose
    private String currency;

    public double getPrice(){
        return price;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public String getCurrency() {
        return currency;
    }
}
