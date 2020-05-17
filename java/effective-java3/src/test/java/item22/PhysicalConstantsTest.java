package item22;

import static item22.PhysicalConstants.AVOGADROS_NUMBER;

import org.junit.jupiter.api.Test;

class PhysicalConstantsTest {

    @Test
    public void atoms() {
        double atoms = atoms(10.1);
        System.out.println(atoms);
    }

    double atoms(double mols) {
        return AVOGADROS_NUMBER * mols;
    }
}
