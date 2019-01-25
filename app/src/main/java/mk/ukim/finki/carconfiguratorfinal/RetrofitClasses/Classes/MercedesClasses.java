package mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * MercedesClasses is a class that is connected with the Configuration api data.
 * The SerializedName tag is used to connect with the api xml.
 */

public class MercedesClasses {

    @SerializedName("classId")
    @Expose
    private String classId;

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

    public String getClassId() {return classId; }
}
