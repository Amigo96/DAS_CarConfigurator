package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * NumberOfSearsService class has 2 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class NumberOfSeatsService implements Names, Values {
    @Override
    public List<String> createNames() {
        List<String> numberOfSeatsNames = new ArrayList<>();
        numberOfSeatsNames.add("Number of seats:");
        return numberOfSeatsNames;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> numberOfSeatsValue = new ArrayList<>();
        numberOfSeatsValue.add(carConfiguration.getTechnicalInformation().getNumber_of_seats()+"");
        return numberOfSeatsValue;
    }
}
