package mk.ukim.finki.das.carconfigurator.RetrofitModels;

import java.util.List;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationCountries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercedesConfiguratorInterface {

    @GET("configurator/v1/markets?language=en")
    Call<List<ConfigurationCountries>> countriesGetter(@Query("apikey") String api_key);

}
