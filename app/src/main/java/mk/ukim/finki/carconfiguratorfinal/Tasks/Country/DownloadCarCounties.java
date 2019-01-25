package mk.ukim.finki.carconfiguratorfinal.Tasks.Country;

import android.os.AsyncTask;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.Interfaces.MercedesConfiguratorInterface;
import mk.ukim.finki.carconfiguratorfinal.Retrofit.RetrofitServiceCreator;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country.ConfigurationCountries;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadCarCounties extends AsyncTask<String,Void, List<ConfigurationCountries>> {

    //Variables
    public AsyncResponse delegate;
    private static OkHttpClient.Builder httpClient;
    private RetrofitServiceCreator creator;
    private List<ConfigurationCountries> list;

    /**
     * Constructor
     * @param delegate - Interface object from AsyncResponse interface
     */
    public DownloadCarCounties(AsyncResponse delegate){
        this.delegate = delegate;
        creator = new RetrofitServiceCreator();
        httpClient = new OkHttpClient.Builder();
    }

    @Override
    protected List<ConfigurationCountries> doInBackground(String... strings) {
        //Parameters that are needed so that retrofit can function
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService("https://api.mercedes-benz.com/", client);
        MercedesConfiguratorInterface service = retrofit.create(MercedesConfiguratorInterface.class);
        service.countriesGetter(strings[0]).enqueue(new Callback<List<ConfigurationCountries>>() {
            @Override
            public void onResponse(Call<List<ConfigurationCountries>> call, Response<List<ConfigurationCountries>> response) {
                list = response.body(); //Results from retrofit are stored in list variable
            }

            @Override
            public void onFailure(Call<List<ConfigurationCountries>> call, Throwable t) {
            }
        });

        while(list == null) //Loop until the data is not stored in the variable list
            continue;

        return list;
    }

    @Override
    protected void onPostExecute(List<ConfigurationCountries> configurationCountries) {
        super.onPostExecute(configurationCountries);
        delegate.processFinish(list); //Calling the method from the interface
    }

}
