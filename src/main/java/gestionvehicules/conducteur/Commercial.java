package gestionvehicules.conducteur;

public class Commercial extends Conducteur {
    /**
     * Le nombre de visite du commerical
     */
    private int nbVisites;

    /**
     * Le constructeur du commercial avec les info super du conducteur
     * + l'initialisation de son nombre de visites à 0
     * @param nom nom
     * @param prenom prenom
     * @param num_permis numéro de permis
     * @param type type
     */
    public Commercial(String nom, String prenom, String num_permis, Permis type) {
        super(nom, prenom, num_permis, type);
        nbVisites =0;
    }

    /**
     * return le nombre de visite du commercial
     * @return le nombre de visite
     */
    public int getNbVisites() {
        return nbVisites;
    }

    /**
     * modifie le nombre de visite du commerical
     * @param nbVisites nombre de visite
     */
    public void setNbVisites(int nbVisites) {
        this.nbVisites = nbVisites;
    }

    /**
     * affiche les info du conducteur commercial
     * @return info conducteur + nombre de visite
     */
    public String toString() {
        return "[Commercial] | Nombres Visites : " + nbVisites+ " | "+ super.toString();
    }
}
