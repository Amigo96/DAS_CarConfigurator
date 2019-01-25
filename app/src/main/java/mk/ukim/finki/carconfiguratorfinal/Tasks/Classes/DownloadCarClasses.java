package mk.ukim.finki.carconfiguratorfinal.Tasks.Classes;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.Interfaces.MercedesConfigurationClassesInterface;
import mk.ukim.finki.carconfiguratorfinal.Retrofit.RetrofitServiceCreator;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes.MercedesClasses;
import mk.ukim.finki.carconfiguratorfinal.Tasks.Country.AsyncResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadCarClasses extends AsyncTask<String, Void, List<MercedesClasses>> {

    //Variables
    public AsyncResponseClasses delegate;
    private static OkHttpClient.Builder httpClient;
    private RetrofitServiceCreator creator;
    private List<MercedesClasses> classes;

    /**
     * Constructor
     * @param delegate - Object from the AsyncResponseClass interface
     */
    public DownloadCarClasses(AsyncResponseClasses delegate){
        this.delegate = delegate;
        creator = new RetrofitServiceCreator();
        httpClient = new OkHttpClient.Builder();
    }

    @Override
    protected List<MercedesClasses> doInBackground(String... strings) {
        //Parameters needed for retrofit to function
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService(strings[0], client);
        MercedesConfigurationClassesInterface service = retrofit.create(MercedesConfigurationClassesInterface.class);
        service.getClasses(strings[1]).enqueue(new Callback<List<MercedesClasses>>() {
            @Override
            public void onResponse(Call<List<MercedesClasses>> call, Response<List<MercedesClasses>> response) {
                classes = response.body(); //Setting the result that retrofit returned
            }

            @Override
            public void onFailure(Call<List<MercedesClasses>> call, Throwable t) {
                //Network fail
            }
        });

        while(classes == null) //Loop until the result is returned from retrofit
            continue;

        return classes;
    }

    @Override
    protected void onPostExecute(List<MercedesClasses> mercedesClasses) {
        super.onPostExecute(mercedesClasses);
        delegate.processFinish(classes); //Calling the method from the interface
    }
}
