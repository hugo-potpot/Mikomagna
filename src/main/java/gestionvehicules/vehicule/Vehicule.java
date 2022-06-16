package gestionvehicules.vehicule;

public abstract class Vehicule {
    /**
     * le numéro d'immatriculation
     */
    private String num_immatriculation;
    /**
     * le modele
     */
    private String modele;
    /**
     * la marque
     */
    private String marque;
    /**
     * le kilométrage
     */
    private double kilometrage;
    /**
     * l'année de mise en circulation
     */
    private int mise_circulation;

    /**
     * Le constructeur Vehicule
     * @param num_immatriculation
     * @param modele
     * @param marque
     * @param kilometrage
     * @param mise_circulation
     */
    protected Vehicule(String num_immatriculation, String modele, String marque, double kilometrage, int mise_circulation) {
        this.num_immatriculation = num_immatriculation;
        this.modele = modele;
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.mise_circulation = mise_circulation;
    }

    /**
     * retourne le numéro d'immatriculation
     * @return num_immatriculation
     */
    public String getNum_immatriculation() {
        return num_immatriculation;
    }

    public void setNum_immatriculation(String num_immatriculation) {
        this.num_immatriculation = num_immatriculation;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setMise_circulation(int mise_circulation) {
        this.mise_circulation = mise_circulation;
    }

    /**
     * retourne un modele
     * @return modele
     */
    public String getModele() {
        return modele;
    }

    /**
     * retourne la marque
     * @return marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * retourne l'année de mise en circulation
     * @return mise_circulation
     */
    public int getMise_circulation() {
        return mise_circulation;
    }

    /**
     * retourne le kilometrage
     * @return kilometrage
     */
    public double getKilometrage() {
        return kilometrage;
    }

    /**
     * modifie le kilometrage
     * @param kilometrage
     */
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String toString(){
        return "numéro d'immatriculation : " + num_immatriculation + " Modele : " + modele +" Marque : " + marque+" Kilométrage : " + kilometrage + " mise en circulation : "+ mise_circulation;
    }
}