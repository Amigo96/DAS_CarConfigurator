package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * PriceService class has 2 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class PriceService implements Names, Values {
    @Override
    public List<String> createNames() {
        List<String> priceNames = new ArrayList<>();
        priceNames.add("Price:");
        return priceNames;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> priceValues = new ArrayList<>();
        priceValues.add(carConfiguration.getPrice().getPrice() + " " + carConfiguration.getPrice().getCurrency());
        return priceValues;
    }
}
