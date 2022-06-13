package gestionvehicules.vehicule;

import gestionvehicules.conducteur.Commercial;

public class Voiture extends Vehicule{
    /**
     * Un véhicule de type commercial
     */
    private Commercial commercial;

    /**
     * Le constructeur Voiture
     * @param num_immatriculation num_immatriculation
     * @param modele modele
     * @param marque marque
     * @param kilometrage kilometrage
     * @param mise_circulation mise_circulation
     * @param commercial commercial
     */
    public Voiture(String num_immatriculation, String modele, String marque, double kilometrage, int mise_circulation, Commercial commercial) {
        super(num_immatriculation, modele, marque, kilometrage, mise_circulation);
        this.commercial = commercial;
    }

    /**
     * Return le commercial
     * @return commercial
     */
    public Commercial getCommercial() {
        return commercial;
    }

    /**
     * Change le commercial
     * @param commercial
     */
    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    /**
     * met a null le commercial
     */
    public void enleverCommercial(){
        this.commercial = null;
    }

    @Override
    public String toString() {
        return "[Voiture]\n" + super.toString() + commercial;
    }
}