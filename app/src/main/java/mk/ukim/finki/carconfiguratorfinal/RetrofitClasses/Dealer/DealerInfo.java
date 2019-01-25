package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * DealerInfo is a class that is connected to the Dealer api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class DealerInfo {

    @SerializedName("dealerId")
    @Expose
    private String dealerID;

    @SerializedName("legalName")
    @Expose
    private String legalName;

    @SerializedName("address")
    @Expose
    private DealerAddress address;

    public String getDealerID() {
        return dealerID;
    }

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public DealerAddress getAddress() {
        return address;
    }

    public void setAddress(DealerAddress address) {
        this.address = address;
    }
}
