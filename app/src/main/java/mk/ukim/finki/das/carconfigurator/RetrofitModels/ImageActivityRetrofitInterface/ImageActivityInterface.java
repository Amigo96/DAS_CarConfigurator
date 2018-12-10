package mk.ukim.finki.das.carconfigurator.RetrofitModels.ImageActivityRetrofitInterface;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ImageActivityExtraClasses.ModelStart;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageActivityInterface {

    @GET("?")
    Call<ModelStart> getImages(@Query("apikey") String api_key);

}
