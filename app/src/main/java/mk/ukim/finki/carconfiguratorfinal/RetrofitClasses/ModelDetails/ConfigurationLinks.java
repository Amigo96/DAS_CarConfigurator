package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ConfigurationLinks is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class ConfigurationLinks {

    @SerializedName("image")
    @Expose
    private String image_link;

    public String getImageLink(){
        return image_link;
    }
}
