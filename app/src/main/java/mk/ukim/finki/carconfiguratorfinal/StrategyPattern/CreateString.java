package mk.ukim.finki.carconfiguratorfinal.StrategyPattern;

import java.util.List;

/**
 * CreateString interface is used for the strategy design pattern
 */

public interface CreateString {
    /**
     * createString is a method that creates a StringBuilder of the lists
     * @param names - List of strings.
     * @param values - List of strings.
     * @return StringBuilder of the connected names and values.
     */
    StringBuilder createString(List<String> names, List<String> values);
}
