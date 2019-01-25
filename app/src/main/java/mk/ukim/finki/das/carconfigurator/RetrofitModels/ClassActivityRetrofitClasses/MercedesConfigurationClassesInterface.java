package mk.ukim.finki.das.carconfigurator.RetrofitModels.ClassActivityRetrofitClasses;

import java.util.List;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees.MercedesClasses;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercedesConfigurationClassesInterface {

    @GET("?")
    Call<List<MercedesClasses>> getClasses(@Query("apikey") String api_key);

}
