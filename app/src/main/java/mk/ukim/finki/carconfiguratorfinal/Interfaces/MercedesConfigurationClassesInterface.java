package mk.ukim.finki.carconfiguratorfinal.Interfaces;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes.MercedesClasses;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interfaces that connect with the base url and preforms the operation GET.
 * As input takes api key string.
 * Returns a list of objects from MercedesClasses class.
 */

public interface MercedesConfigurationClassesInterface {

    @GET("?")
    Call<List<MercedesClasses>> getClasses(@Query("apikey") String api_key);

}
