package mk.ukim.finki.das.carconfigurator.ExtraClasses.StringBuilders;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.CarEngine;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.FuelEconomy;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.Price;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.TechicalInformation;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.Values;

public class BuilderStrings {


    public String engineString(CarEngine engine){
        return new StringBuilder().append("Horse Power: ").append(engine.getEngine_power().getValue())
                .append(" ").append(engine.getEngine_power().getUnit())
                .append("\t").append("Engine KW: ").append(engine.getEngine_kw().getValue()).append(" ")
                .append(engine.getEngine_kw().getUnit()).append("\n").append("Emission CO2 min: ")
                .append(engine.getEmission_standard()).toString();
    }

    public String fuelString(FuelEconomy fuel){
        return new StringBuilder().append("\t\t\t").append("Min").append("\t\t\t").append("Max").append("\n")
                .append("City").append("\t").append(fuel.getFuel_consumin_city_min()).append(" ").append(fuel.getFuel_consumin_city_max()).append("\n")
                .append("Open Land").append("\t").append(fuel.getFuel_consumin_overlan_min()).append(" ").append(fuel.getFuel_consumin_overlan_max()).append("\n")
                .append("Combined").append("\t").append(fuel.getFuel_consumin_combined_min()).append(" ").append(fuel.getFuel_consumin_combined_max()).append("\n")
                .append("CO2 emission").append("\t").append(fuel.getEmission_co2_min()).append(" ").append(fuel.getEmission_co2_max()).toString();
    }

    public String accelerationString(Values acceleration){
        return new StringBuilder().append("Values: ").append(acceleration.getValue()).append("\t")
                .append(acceleration.getUnit()).toString();
    }

    public String topSpeedString(Values topSpeed){
        return new StringBuilder().append("Top speed: ").append(topSpeed.getValue()).append(" ").append(topSpeed.getUnit())
                .toString();
    }

    public String enterierString(TechicalInformation car){
        return new StringBuilder().append("Number of doors: ").append(car.getNumber_of_doors()).append("        ")
                .append("Number of seats: ").append(car.getNumber_of_seats()).toString();
    }

    public String prizeString(Price car_price){
        return new StringBuilder().append("Price: ").append(car_price.getNetPrice()).append(" ")
                .append(car_price.getCurrency()).toString();
    }

}
