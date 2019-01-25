package mk.ukim.finki.carconfiguratorfinal.Tasks.Country;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes.MercedesClasses;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country.ConfigurationCountries;

public interface AsyncResponse {
    /**
     * processFinish is a method that connects the Async task and the MainActivity thread
     * @param output - List of objects from the ConfigurationCountries class
     */
    void processFinish(List<ConfigurationCountries> output);
}
