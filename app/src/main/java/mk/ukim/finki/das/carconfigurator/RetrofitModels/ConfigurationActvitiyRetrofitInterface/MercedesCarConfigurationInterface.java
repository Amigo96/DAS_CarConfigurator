package mk.ukim.finki.das.carconfigurator.RetrofitModels.ConfigurationActvitiyRetrofitInterface;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.Configuration;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercedesCarConfigurationInterface {

    @GET("initial?")
    Call<Configuration> getConfiguration(@Query("apikey") String api_key);

}
