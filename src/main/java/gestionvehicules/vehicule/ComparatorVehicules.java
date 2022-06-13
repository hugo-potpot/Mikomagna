package gestionvehicules.vehicule;

import java.util.Comparator;

/**
 * Comparator par année de mise en circulation
 */
public class ComparatorVehicules implements Comparator<Vehicule> {
    @Override
    public int compare(Vehicule v1, Vehicule v2) {
        if (v1.getMise_circulation()> v2.getMise_circulation()) return +1;
        else if (v1.getMise_circulation()< v2.getMise_circulation()) return -1;
        return 0;
    }
}