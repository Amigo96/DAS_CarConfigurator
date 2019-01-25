package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;

/**
 * CarEngineService class has 3 implemented interface.
 * The description of the methods is in the interfaces.
 */

public class CarEngineService implements Names,Values, CreateString {

    @Override
    public List<String> createNames() {
        List<String> engineReferences = new ArrayList<>();
        String[] listOfNames = new String[]{"Fuel-type:", "Alternative-Fuel-type:", "Engine-Power:", "Engine-Kw:", "Engine-cilinders:", "Engine-Concept:", "Drive-concept:"};
        for(int i = 0 ; i < listOfNames.length ; i++)
            engineReferences.add(listOfNames[i]);
        return engineReferences;
    }

    @Override
    public List<String> createValues(Configuration carConfiguration) {
        List<String> engineValues = new ArrayList<>();
        mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.CarEngine engine = carConfiguration.getTechnicalInformation().getEngine();
        engineValues.add(engine.getFuel_type());
        engineValues.add(engine.getAlternative_fuel_type());
        engineValues.add(engine.getEngine_power().getValue() + " " + engine.getEngine_power().getUnit());
        engineValues.add(engine.getEngine_kw().getValue() + " " + engine.getEngine_kw().getUnit());
        engineValues.add(engine.getEngine_cilinders()+"");
        engineValues.add(engine.getEngine_concept());
        engineValues.add(engine.getDrive_concept());
        return engineValues;
    }

    @Override
    public StringBuilder createString(List<String> names, List<String> values) {
        StringBuilder sb = new StringBuilder();
        sb.append("Car Engine:").append("\n");
        int value_iterator = 0;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals("Engine-Power:") || names.get(i).equals("Engine-Kw:")) {
                sb.append(names.get(i)).append(" ").append(values.get(value_iterator++)).append(" ").append(values.get(value_iterator));
            } else {
                sb.append(names.get(i)).append(" ").append(values.get(value_iterator++));
            }
            sb.append("\n");
        }
        return sb;
    }
}
