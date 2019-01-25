package mk.ukim.finki.carconfiguratorfinal.Tasks.Models;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model.Model;

public interface AsyncResponseModel {
    /**
     * processFinish is a method that connects the Async task and the MainActivity thread
     * @param output - List of objects from the Model class
     */
    void processFinish(List<Model> output);
}
