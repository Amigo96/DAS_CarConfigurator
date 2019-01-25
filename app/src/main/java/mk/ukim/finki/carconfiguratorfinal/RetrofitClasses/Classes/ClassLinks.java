package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ClassLinks is a class where the data from the Configuration api is stored.
 * The SerializedName tag is used to connect with the api xml.
 */

public class ClassLinks {

    @SerializedName("self")
    @Expose
    private String self_link;

    @SerializedName("models")
    @Expose
    private String models_link;

    public String getSelfLink(){
        return self_link;
    }

    public String getModelsLink(){
        return models_link;
    }
}
