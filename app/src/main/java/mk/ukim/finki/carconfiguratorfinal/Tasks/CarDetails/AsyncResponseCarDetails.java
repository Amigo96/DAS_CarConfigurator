package mk.ukim.finki.carconfiguratorfinal.Tasks.CarDetails;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

public interface AsyncResponseCarDetails {
    /**
     * processFinish is a method that connects the Async task and the MainActivity thread
     * @param output - Object from Configuration class that contains the data returned from retrofit.
     */
    void processFinish(Configuration output);
}
