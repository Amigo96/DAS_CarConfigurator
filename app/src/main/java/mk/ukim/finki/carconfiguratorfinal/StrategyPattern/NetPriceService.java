package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * NetPriceService class has 2 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class NetPriceService implements Names, Values {

    @Override
    public List<String> createNames() {
        List<String> netPriceNames = new ArrayList<>();
        netPriceNames.add("Net-Price:");
        return netPriceNames;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> netPriceValues = new ArrayList<>();
        netPriceValues.add(carConfiguration.getPrice().getNetPrice() + " " + carConfiguration.getPrice().getCurrency());
        return netPriceValues;
    }

}
