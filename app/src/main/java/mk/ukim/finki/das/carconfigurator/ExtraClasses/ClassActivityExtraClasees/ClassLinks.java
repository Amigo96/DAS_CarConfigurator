package mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
