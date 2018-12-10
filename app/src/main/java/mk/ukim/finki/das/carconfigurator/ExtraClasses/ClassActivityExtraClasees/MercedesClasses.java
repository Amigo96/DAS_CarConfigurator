package mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MercedesClasses {

    @SerializedName("className")
    @Expose
    private String className;

    @SerializedName("_links")
    @Expose
    private ClassLinks links;

    public String getClassName(){
        return className;
    }

    public ClassLinks getAllLinks(){
        return links;
    }

}
