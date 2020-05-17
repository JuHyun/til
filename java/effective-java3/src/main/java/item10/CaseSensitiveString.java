package item10;

import java.util.Objects;

public class CaseSensitiveString {

    private final String str;

    public CaseSensitiveString(String str) {
        this.str = Objects.requireNonNull(str);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseSensitiveString)
            return str.equalsIgnoreCase(((CaseSensitiveString) o).str);
//        if (o instanceof String)
//            return str.equalsIgnoreCase((String) o);
        return false;
    }
}
