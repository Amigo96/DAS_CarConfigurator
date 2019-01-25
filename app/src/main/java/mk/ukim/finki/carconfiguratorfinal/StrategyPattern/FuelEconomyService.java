package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.FuelEconomy;

/**
 * FuelEconomyService class has 3 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class FuelEconomyService implements Names, Values, CreateString {
    @Override
    public List<String> createNames() {
        List<String> fuelEconomyNames = new ArrayList<>();
        String[] names = new String[]{"City:", "Overland:", "Combined:", "co2:"};
        for(int i = 0 ; i < names.length ; i++)
            fuelEconomyNames.add(names[i]);
        return fuelEconomyNames;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> fuelEconomyValues = new ArrayList<>();
        FuelEconomy fuelEconomy = carConfiguration.getTechnicalInformation().getEngine().getFuel();
        fuelEconomyValues.add("Min: " + fuelEconomy.getFuel_consumin_city_min().getValue() + " " + fuelEconomy.getFuel_consumin_city_min().getUnit() + " Max: " + fuelEconomy.getFuel_consumin_city_max().getValue() + " " + fuelEconomy.getFuel_consumin_city_max().getUnit());
        fuelEconomyValues.add("Min: " + fuelEconomy.getFuel_consumin_overlan_min().getValue() + " " + fuelEconomy.getFuel_consumin_overlan_min().getUnit() + " Max: " + fuelEconomy.getFuel_consumin_overlan_max().getValue() + " " + fuelEconomy.getFuel_consumin_overlan_max().getUnit());
        fuelEconomyValues.add("Min: " + fuelEconomy.getFuel_consumin_combined_min().getValue() + " " + fuelEconomy.getFuel_consumin_combined_min().getUnit() + " Max: " + fuelEconomy.getFuel_consumin_combined_max().getValue() + " " + fuelEconomy.getFuel_consumin_combined_max().getUnit());
        fuelEconomyValues.add(fuelEconomy.getEmission_co2_min().getValue() + " " + fuelEconomy.getEmission_co2_min().getUnit());
        return fuelEconomyValues;
    }

    @Override
    public StringBuilder createString(List<String> names, List<String> values) {
        StringBuilder sb = new StringBuilder();
        sb.append("Fuel economy:").append("\n");
        int value_iterator = 0;
        for(int i = 0 ; i < names.size() ; i++){
            sb.append(names.get(i)).append(" ").append("min: ").append(values.get(value_iterator++)).append(" ").append(values.get(value_iterator++));
        }
        return sb;
    }
}
