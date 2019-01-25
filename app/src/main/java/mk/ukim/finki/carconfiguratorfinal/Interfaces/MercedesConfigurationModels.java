package mk.ukim.finki.carconfiguratorfinal.Interfaces;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interfaces that connect with the base url and preforms the operation GET.
 * As input takes a class id, and the api key.
 * Returns a list of objects from the Model class.
 */

public interface MercedesConfigurationModels {
    @GET("?")
    Call<List<Model>> getModels(@Query("classId") String class_id, @Query("apikey") String api_key);
}
