package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ModelLinks is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class ModelLinks {

    @SerializedName("self")
    @Expose
    private String self_link;

    @SerializedName("configurations")
    @Expose
    private String configuration_link;

    public String getSelfLink(){
        return self_link;
    }

    public String getConfigurationLink(){
        return configuration_link;
    }
}