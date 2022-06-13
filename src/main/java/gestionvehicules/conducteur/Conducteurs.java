package gestionvehicules.conducteur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Conducteurs {
    /**
     * Crée une ObservableList de Conducteur.
     */
    private ObservableList<Conducteur> listConducteur;

    /**
     * Dans le constructeur, initialise listConducteur en LindekList vide
     */
    public Conducteurs() {
        this.listConducteur = FXCollections.observableList(new LinkedList<>());
    }

    /**
     * Trie la listConducteur par nom
     */
    public void trierNom(){
        if (listConducteur.size() > 0)
            listConducteur.sort(new ComparatorConducteurs());
    }

    /**
     * Ajoute le conducteur mis en parametre si il n'est pas déjà present dans la list.
     * @param c1 Conducteur
     * @throws ExceptionConducteurDejaPresent
     */
    public void addConducteur(Conducteur c1) throws ExceptionConducteurDejaPresent{
        if (listConducteur.contains(c1)) throw new ExceptionConducteurDejaPresent(c1);
        listConducteur.add(c1);
    }

    /**
     * Supprime le conducteur mis en parametre si il present dans la list
     * @param c1 Conducteur
     * @throws ExceptionConducteurPasPresent
     */
    public void supConducteur(Conducteur c1) throws ExceptionConducteurPasPresent{
        if(!listConducteur.contains(c1)) throw new ExceptionConducteurPasPresent(c1);
        listConducteur.remove(c1);
    }

    /**
     * retourne une liste de Livreur.
     * @return listLivreur
     */
    public ArrayList<Livreur> onlyLivreur() {
        ArrayList<Livreur> listLivreur = new ArrayList<Livreur>();
        Iterator<Conducteur> iterator = listConducteur.iterator();
        while(iterator.hasNext()){
            if (iterator.next() instanceof Livreur livreur)
                listLivreur.add(livreur);
        }
        return listLivreur;
    }

    /**
     * Affiche les livreurs
     */
    public void afficherLivreur(){
        ArrayList<Livreur> listLivreur = onlyLivreur();
        System.out.println("----------------------------------------------------------------------------------------");
        for (Conducteur conducteur : listLivreur){
            System.out.println(conducteur);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    /**
     * retourne une liste uniquement de Conducteur
     * @return listCommercial
     */
    public ArrayList<Commercial> onlyCommercial() {
        ArrayList<Commercial> listCommercial = new ArrayList<Commercial>();
        Iterator<Conducteur> iterator = listConducteur.iterator();
        while(iterator.hasNext()){
            if (iterator.next() instanceof Commercial commercial)
                listCommercial.add(commercial);
        }
        return listCommercial;
    }

    /**
     * Affiche uniquement les commerciaux
     */
    public void afficherCommericial(){
        ArrayList<Commercial> listCommercial = onlyCommercial();
        System.out.println("----------------------------------------------------------------------------------------");
        for (Conducteur conducteur : listCommercial){
            System.out.println(conducteur);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    /**
     * Affiche tous les conducteurs
     */
    public void afficherListConducteur() {
        System.out.println("----------------------------------------------------------------------------------------");
        for (Conducteur conducteur : listConducteur) {
            System.out.println(conducteur);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }
}
