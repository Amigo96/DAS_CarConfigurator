package mk.ukim.finki.das.carconfigurator.RetrofitModels;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceCreator {

    public Retrofit createService(String baseURL, OkHttpClient client){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return build;
    }

}
