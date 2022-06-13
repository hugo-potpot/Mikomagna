package gestionvehicules.conducteur;

public class Livreur extends Conducteur {
    /**
     * Le nombre d'heures du livreur
     */
    private int nbHeures;

    /**
     * Le constructeur livreur
     * @param nom nom
     * @param prenom prenom
     * @param num_permis numéro de permis
     * @param type type de permis
     */
    public Livreur(String nom, String prenom, String num_permis, Permis type) {
        super(nom, prenom, num_permis, type);
        nbHeures = 0;
    }

    /**
     * retourne son nombre d'heures
     * @return nbHeures
     */
    public int getNbHeures() {
        return nbHeures;
    }

    /**
     * Modifie son nombre d'heures avec le paramatre
     * @param nbHeures nbHeures
     */
    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    @Override
    public String toString() {
        return "[Livreur]\nNombres Heures : " + nbHeures +"\n"+ super.toString();
    }
}
