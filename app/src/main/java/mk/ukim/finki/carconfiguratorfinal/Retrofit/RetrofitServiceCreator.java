package mk.ukim.finki.carconfiguratorfinal.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitServiceCreator is a class that creates a retrofit service.
 */

public class RetrofitServiceCreator {

    /**
     * Creates a retrofit service
     * @param baseURL - String from the base url, it does not require the full url. The rest is connect through the interface.
     * @param client - OKHttpClient object.
     * @return a retrofit service
     */
    public Retrofit createService(String baseURL, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}
