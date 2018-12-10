package mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigurationLinks {

    @SerializedName("image")
    @Expose
    private String image_link;

    public String getImageLink(){
        return image_link;
    }
}
