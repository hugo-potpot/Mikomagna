package gestionvehicules.vehicule;

import java.util.Locale;

/**
 * Exception si le véhicule ajouté est deja present
 */
public class ExceptionVehiculeDejaPresent extends Exception{

    public ExceptionVehiculeDejaPresent(Vehicule v1){
        super("ERROR, le vehicule "+v1.getModele().toUpperCase(Locale.ROOT)+" est deja present");
    }

}
