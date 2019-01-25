package mk.ukim.finki.carconfiguratorfinal.Interfaces;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer.Dealer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit interfaces that connect with the base url and preforms the operation GET.
 * As input takes a city - string, brand - string, field - string and the api key - string.
 * Returns an object from the class Dealer.
 */

public interface MercedesDealerInterface {
    @GET("dealers?")
    Call<Dealer> getDealersInCity(@Query("city")String city, @Query("brand")String brand, @Query("fields")String field, @Query("apikey") String apikey);
}
