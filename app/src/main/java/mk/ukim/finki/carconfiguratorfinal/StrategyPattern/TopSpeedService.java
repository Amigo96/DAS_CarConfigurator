package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * TopSpeedService class has 3 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class TopSpeedService implements Names, Values, CreateString {

    @Override
    public List<String> createNames() {
        List<String> topSpeedNames = new ArrayList<>();
        topSpeedNames.add("Top speed:");
        return topSpeedNames;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> topSpeedValues = new ArrayList<>();
        topSpeedValues.add(carConfiguration.getTechnicalInformation().getTopSpeed().getValue() + " " + carConfiguration.getTechnicalInformation().getTopSpeed().getUnit());
        return topSpeedValues;
    }

    @Override
    public StringBuilder createString(List<String> names, List<String> values) {
        StringBuilder sb = new StringBuilder();
        sb.append(names.get(0)).append(" ").append(values.get(0)).append(" ").append(values.get(1));
        return sb;
    }
}
