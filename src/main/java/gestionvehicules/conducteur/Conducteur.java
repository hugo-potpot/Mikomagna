package gestionvehicules.conducteur;

public abstract class Conducteur{
    /**
     * Le nom du conducteur
     */
    private String nom;
    /**
     * Le prenom du conducteur
     */
    private String prenom;
    /**
     * Le numéro de permis du conducteur
     */
    private String num_permis;
    /**
     * Le type de permis du conducteur (ex : Permis A)
     */
    private Permis type;

    /**
     * Le constructeur du conducteur
     * @param nom nom
     * @param prenom prenom
     * @param num_permis numero de permis
     * @param type type de Permis
     */
    public Conducteur(String nom, String prenom, String num_permis, Permis type){
        this.nom = nom;
        this.prenom = prenom;
        this.num_permis = num_permis;
        this.type = type;
    }

    /**
     * Return le nom du conducteur
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Return le prenom du conducteur
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * return le numéro de permis du conducteur
     * @return num-permis
     */
    public String getNum_permis() {
        return num_permis;
    }

    /**
     * return le type de permis du conducteur
     * @return type
     */
    public Permis getType() {
        return type;
    }

    /**
     * Compare deux conducteurs pour savoir si ils n'ont pas le même prénom et nom.
     * @param c1 Conducteur 1
     * @param c2 Conducteur 2
     * @return true si le même, false si pas les même
     */
    public boolean equals(Conducteur c1, Conducteur c2){
        return ((c1.getNom().equals(c2.getNom()) && c1.getPrenom().equals(c2.getPrenom())));
    }

    /**
     * Affiche le conducteur
     *
     * @return nom, prenom, numero de permis et type de permis.
     */
    @Override
    public String toString() {
        return  "nom = " + nom + '\n' +
                "prenom = " + prenom + '\n' +
                "num_permis = " + num_permis + '\n' +
                "type= " + type;
    }
}
