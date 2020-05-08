package chap10;

import java.util.Optional;
import java.util.Properties;

public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.get(name))
                .flatMap(prop -> stringToInt((String) prop))
                .filter(i -> i > 0)
                .orElse(0);
    }
}
