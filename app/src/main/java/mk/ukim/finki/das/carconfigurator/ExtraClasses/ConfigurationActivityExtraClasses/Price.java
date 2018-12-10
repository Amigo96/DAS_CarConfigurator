package mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
