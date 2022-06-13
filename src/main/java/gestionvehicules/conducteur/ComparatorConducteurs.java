package gestionvehicules.conducteur;

import java.util.Comparator;

/**
 * Comparateur par nom de conducteurs
 */
public class ComparatorConducteurs implements Comparator<Conducteur> {
    @Override
    public int compare(Conducteur o1, Conducteur o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
