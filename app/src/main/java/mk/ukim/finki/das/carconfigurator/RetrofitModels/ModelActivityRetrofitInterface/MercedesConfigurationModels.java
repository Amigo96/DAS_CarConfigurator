package mk.ukim.finki.das.carconfigurator.RetrofitModels.ModelActivityRetrofitInterface;

import java.util.List;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercedesConfigurationModels {

    @GET("?")
    Call<List<Model>> getModels(@Query("apikey") String api_key);
}
