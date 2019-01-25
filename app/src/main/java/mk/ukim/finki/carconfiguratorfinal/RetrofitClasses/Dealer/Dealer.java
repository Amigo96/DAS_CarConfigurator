package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Dealer is a class that is connected to the Dealer api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class Dealer {

    @SerializedName("dealers")
    @Expose
    private List<DealerInfo> dealers;

    public void setDealers(List<DealerInfo> dealers){
        this.dealers = dealers;
    }

    public List<DealerInfo> getDealers(){
        return dealers;
    }

}
