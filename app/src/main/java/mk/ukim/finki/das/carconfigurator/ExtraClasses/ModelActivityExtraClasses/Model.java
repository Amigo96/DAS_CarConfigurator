package mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
