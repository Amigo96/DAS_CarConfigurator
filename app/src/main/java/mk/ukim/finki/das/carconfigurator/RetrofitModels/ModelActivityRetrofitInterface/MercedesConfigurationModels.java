package mk.ukim.finki.das.carconfigurator.RetrofitModels.ModelActivityRetrofitInterface;

import java.util.List;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercedesConfigurationModels {

//    https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models?classId=190&apikey=636fa4d1-dfbf-4a78-a260-0215e51b3879
    @GET("?")
    Call<List<Model>> getModels(@Query("classId") String class_id, @Query("apikey") String api_key);
}
