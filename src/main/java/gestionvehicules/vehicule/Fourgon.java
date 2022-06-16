package gestionvehicules.vehicule;

import gestionvehicules.conducteur.Livreur;

public class Fourgon extends Vehicule{
    /**
     * variable livreur d'un Objet Livreur
     */
    public Livreur livreur;
    /**
     * variable poids_max
     */
    private double poids_max;
    /**
     * volume_max
     */
    private double volume_max;

    /**
     * Constructeur d'un Fourgon
     * @param num_immatriculation
     * @param modele
     * @param marque
     * @param kilometrage
     * @param mise_circulation
     * @param poids_max
     * @param volume_max
     * @param livreur
     */
    public Fourgon(String num_immatriculation, String modele, String marque, double kilometrage, int mise_circulation, double poids_max, double volume_max,Livreur livreur) {
        super(num_immatriculation, modele, marque, kilometrage, mise_circulation);
        this.poids_max =poids_max;
        this.volume_max = volume_max;
        this.livreur = livreur;
    }

    /**
     * retourne le poids max
     * @return poids_max
     */
    public double getPoids_max() {
        return poids_max;
    }

    public void setPoids_max(double poids_max) {
        this.poids_max = poids_max;
    }

    public void setVolume_max(double volume_max) {
        this.volume_max = volume_max;
    }

    /**
     * retourne le volume_max
     * @return volume_max
     */
    public double getVolume_max() {
        return volume_max;
    }

    /**
     * retourne le livreur
     * @return livreur
     */
    public Livreur getLivreur() {
        return livreur;
    }

    /**
     * modifie le livreur
     * @param livreur livreur
     */
    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    /**
     * supprime le livreur et le met à null
     */
    public void enleverLivreur(){
        this.livreur =null;
    }

    @Override
    public String toString() {
        return "[Fourgon]\n" + super.toString() +" poids max : "+ poids_max +" volume max : "+ volume_max +"\n"+ livreur;
    }
}