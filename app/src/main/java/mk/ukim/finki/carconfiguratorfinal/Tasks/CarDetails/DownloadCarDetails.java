package mk.ukim.finki.carconfiguratorfinal.Tasks.CarDetails;

import android.os.AsyncTask;
import android.util.Log;

import mk.ukim.finki.carconfiguratorfinal.Interfaces.MercedesCarConfigurationInterface;
import mk.ukim.finki.carconfiguratorfinal.Retrofit.RetrofitServiceCreator;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Async task class
 */

public class DownloadCarDetails extends AsyncTask<String,Void,Configuration> {

    //Variables
    private AsyncResponseCarDetails delegate;
    private static OkHttpClient.Builder httpClient;
    private RetrofitServiceCreator creator;
    private Configuration configurationDetails;

    /**
     * Constructor
     * @param delegate - AsyncResponseCarDetails (Interface)
     */
    public DownloadCarDetails(AsyncResponseCarDetails delegate){
        this.delegate = delegate;
        httpClient = new OkHttpClient.Builder();
        creator = new RetrofitServiceCreator();
    }

    @Override
    protected Configuration doInBackground(String... strings) {
        //Parameters that are needed so that retrofit can function
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService(strings[0].substring(0, strings[0].length()-8), client);
        MercedesCarConfigurationInterface service = retrofit.create(MercedesCarConfigurationInterface.class);
        service.getConfiguration(strings[1]).enqueue(new Callback<Configuration>() { //Retrofit return results
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                configurationDetails = response.body(); //Setting the result in the variable
            }
            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
            }
        });

        while(configurationDetails == null) //Loops until the result is returned
            continue;

        return configurationDetails;

    }

    @Override
    protected void onPostExecute(Configuration configuration) {
        super.onPostExecute(configuration);
        delegate.processFinish(configurationDetails); //Calling the interface method.
    }

}
