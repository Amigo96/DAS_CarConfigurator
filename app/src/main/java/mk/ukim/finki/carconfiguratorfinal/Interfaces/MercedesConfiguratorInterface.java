package mk.ukim.finki.carconfiguratorfinal.Interfaces;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country.ConfigurationCountries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interfaces that connect with the base url and preforms the operation GET.
 * As input takes the api key string.
 * Returns a list of object from ConfigurationCountries class.
 */

public interface MercedesConfiguratorInterface{

    @GET("configurator/v1/markets?language=en")
    Call<List<ConfigurationCountries>> countriesGetter(@Query("apikey") String api_key);

}
