package mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
