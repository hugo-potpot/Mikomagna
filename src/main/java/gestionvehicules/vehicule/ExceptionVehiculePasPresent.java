package gestionvehicules.vehicule;

import java.util.Locale;

/**
 * Exception si le vehicule supprimé n'est pas present dans la liste
 */
public class ExceptionVehiculePasPresent extends Exception{
    public ExceptionVehiculePasPresent(Vehicule v1){
        super("ERROR, le vehciule "+v1.getModele().toUpperCase(Locale.ROOT)+" n'est pas présent.");
    }
}
