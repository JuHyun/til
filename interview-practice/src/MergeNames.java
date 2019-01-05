import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        if (names1.length == 0 && names1.length == 0) {
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }

        Set<String> set = new HashSet<String>();

        for (String name : names1) {
            set.add(name);
        }

        for (String name : names2) {
            set.add(name);
        }

        return set.toArray(new String[0]);

    }
}
