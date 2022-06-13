package gestionvehicules.conducteur;
/**
 * Exception si le conducteur ajouté est deja present
 */
public class ExceptionConducteurDejaPresent extends Exception{
    public ExceptionConducteurDejaPresent(Conducteur c1){
        super("ERROR, le conducteur "+c1+" conducteur deja present.");
    }
}
