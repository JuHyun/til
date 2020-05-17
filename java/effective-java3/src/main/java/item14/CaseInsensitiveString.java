package item14;

import java.util.Objects;

public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaseInsensitiveString)) return false;
        CaseInsensitiveString that = (CaseInsensitiveString) o;
        return s.equalsIgnoreCase(that.s);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s;
    }

    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}
