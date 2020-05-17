package item14;

import java.util.Comparator;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparing(pn -> pn.prefix)
            .thenComparing(pn -> pn.lineNum);

    private final short areaCode, prefix, lineNum;

    private int hashCode;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof item11.PhoneNumber)) return false;
        item14.PhoneNumber that = (item14.PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = this.hashCode;

        if (result != 0) return result;

        result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    protected item11.PhoneNumber clone() {
        try {
            return (item11.PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

//    @Override
//    public int compareTo(PhoneNumber pn) {
//        int result = Short.compare(areaCode, pn.areaCode);
//        if (result == 0) {
//            result = Short.compare(prefix, pn.prefix);
//            if (result == 0) {
//                result = Short.compare(lineNum, pn.lineNum);
//            }
//        }
//        return result;
//    }

    @Override
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }
}
