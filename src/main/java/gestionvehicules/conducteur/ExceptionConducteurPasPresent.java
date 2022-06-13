package gestionvehicules.conducteur;

/**
 * Exception si le conducteur supprimé n'est pas dans la liste
 */
public class ExceptionConducteurPasPresent extends Exception{
    public ExceptionConducteurPasPresent(Conducteur c1){
        super("ERROR, le conducteur"+c1+" n'est pas présent !");
    }

}
