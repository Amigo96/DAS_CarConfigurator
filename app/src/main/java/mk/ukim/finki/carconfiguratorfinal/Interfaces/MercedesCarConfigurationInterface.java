package mk.ukim.finki.carconfiguratorfinal.Interfaces;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interfaces that connect with the base url and preforms the operation GET.
 * As input takes the api key.
 * Returns a Configuration object.
 */

public interface MercedesCarConfigurationInterface {

    @GET("initial?")
    Call<Configuration> getConfiguration(@Query("apikey") String api_key);

}
