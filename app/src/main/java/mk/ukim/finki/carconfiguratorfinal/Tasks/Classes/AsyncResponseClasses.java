package mk.ukim.finki.carconfiguratorfinal.Tasks.Classes;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes.MercedesClasses;

public interface AsyncResponseClasses {
    /**
     * processFinish is a method that connects the Async task and the MainActivity thread
     * @param output - List of objects from MercedesClasses
     */
    void processFinish(List<MercedesClasses> output);
}
