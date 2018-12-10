package mk.ukim.finki.das.carconfigurator.ExtraClasses.ImageActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class URL {

    @SerializedName("url")
    @Expose
    private String url;

    public String getURL(){
        return url;
    }

}
