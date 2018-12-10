package mk.ukim.finki.das.carconfigurator.ExtraClasses.ImageActivityExtraClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreURL {

    @SerializedName("INT1")
    @Expose
    private URL int1;

    @SerializedName("EXT020")
    @Expose
    private URL ext020;

    public URL getInt1() {
        return int1;
    }

    public URL getExt020() {
        return ext020;
    }
}
