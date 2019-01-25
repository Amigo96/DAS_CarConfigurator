package mk.ukim.finki.carconfiguratorfinal.Tasks.Dealer;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import mk.ukim.finki.carconfiguratorfinal.Interfaces.MercedesDealerInterface;
import mk.ukim.finki.carconfiguratorfinal.Retrofit.RetrofitServiceCreator;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer.Dealer;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadDealerInformation extends AsyncTask<String, Void, Dealer> {

    private AsyncResponseDealer delegate;
    private static OkHttpClient.Builder httpClient;
    private RetrofitServiceCreator creator;
    private Dealer dealer;
    private Context context;

    public DownloadDealerInformation(AsyncResponseDealer delegate, Context context){
        this.delegate = delegate;
        httpClient = new OkHttpClient.Builder();
        creator = new RetrofitServiceCreator();
        this.context = context;
    }

    @Override
    protected Dealer doInBackground(String... strings) {
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService(strings[0], client);
        MercedesDealerInterface service = retrofit.create(MercedesDealerInterface.class);
        service.getDealersInCity(strings[1], strings[2], strings[3], strings[4]).enqueue(new Callback<Dealer>() {
            @Override
            public void onResponse(Call<Dealer> call, Response<Dealer> response) {

                if (response.isSuccessful()) { //Checks if the response was successful
                    if (response.body() != null) { //Check if data is returned
                        if (response.body().getDealers().size() == 0) //Check if error in collecting the data
                            displayErrorMessage("Error in entry parameters");
                        dealer = response.body(); //Setting the result in the variable
                    } else
                        displayErrorMessage("There are no information about the data you are searching"); //Error message

                } else
                    displayErrorMessage("Api_key failed"); //Api failed inform the user
            }
            @Override
            public void onFailure(Call<Dealer> call, Throwable t) {
                displayErrorMessage("Problem with network"); //Network problem
            }
        });

        while(dealer == null) //Loop until you get the results from retrofit
            continue;

        return dealer;
    }

    /**
     * Informs the user of an error tha occurred while collecting the data.
     * @param message - Message that is going to be displayed to the user
     */
    private void displayErrorMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(Dealer dealer) {
        super.onPostExecute(dealer);
        delegate.processFinish(this.dealer); //Calling the method from the interface
    }
}
