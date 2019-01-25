package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model is a class that is connected to the Configuration api, and data is stored in this class
 * The SerializedName tag is used to connect with the api xml.
 */

public class Model {

    @SerializedName("name")
    @Expose
    private String model_name;

    @SerializedName("_links")
    @Expose
    private ModelLinks model_links;

    public String getModelName(){
        return model_name;
    }

    public ModelLinks getModelLinks(){
        return model_links;
    }
}

