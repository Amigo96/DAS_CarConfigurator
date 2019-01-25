package mk.ukim.finki.carconfiguratorfinal.Tasks.Models;

import android.os.AsyncTask;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.Interfaces.MercedesConfigurationModels;
import mk.ukim.finki.carconfiguratorfinal.Retrofit.RetrofitServiceCreator;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model.Model;
import mk.ukim.finki.carconfiguratorfinal.Tasks.Classes.DownloadCarClasses;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadCarModels extends AsyncTask<String, Void, List<Model>> {

    private AsyncResponseModel delegate;
    private static OkHttpClient.Builder httpClient;
    private RetrofitServiceCreator creator;
    private List<Model> model_list;

    /**
     * Constructor
     * @param delegate - Interface object from AsyncResponseModel interface
     */
    public DownloadCarModels(AsyncResponseModel delegate){
        this.delegate = delegate;
        creator = new RetrofitServiceCreator();
        httpClient = new OkHttpClient.Builder();
    }

    @Override
    protected List<Model> doInBackground(String... strings) {
        //Parameters need for retrofit to function
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService(strings[0], client);
        MercedesConfigurationModels service = retrofit.create(MercedesConfigurationModels.class);
        service.getModels(strings[1], strings[2]).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                model_list = response.body(); //Setting the result in the variable
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
            }
        });

        while(model_list == null) //Loop until the data from retrofit is not stored in the variable
            continue;

        return model_list;
    }

    @Override
    protected void onPostExecute(List<Model> models) {
        super.onPostExecute(models);
        delegate.processFinish(model_list); //Calling the method from the interface
    }
}
