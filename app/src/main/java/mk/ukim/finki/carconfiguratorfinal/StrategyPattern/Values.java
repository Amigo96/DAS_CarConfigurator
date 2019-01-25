package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * Values interface is used for the strategy design pattern
 */

public interface Values {
    /**
     * createValues is a method that creates a list of values based from the data that is given through the input
     * @param carConfiguration - Object from the Configuration class.
     * @return List of string.
     */
    List<String> createValues(Configuration carConfiguration);
}
