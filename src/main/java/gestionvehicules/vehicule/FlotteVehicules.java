package gestionvehicules.vehicule;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class FlotteVehicules {
    /**
     * ObservableList de vehicule
     */
    private ObservableList<Vehicule> vehicules;

    /**
     * Constructeur de la FlotteVehicules qui initialise l'observableList en FXCollections de ArrayList.
     */
    public FlotteVehicules(){
        vehicules = FXCollections.observableList(new ArrayList<>());
    }

    /**
     * tri les voitures en fonction de leur date de mise en circulation.
     */
    public void triVehicule(){
        if(vehicules.size()>0)
            vehicules.sort(new ComparatorVehicules());
    }

    /**
     * ajoute un véhicule si il n'est pas deja present
     * @param v1 Vehicule
     * @throws ExceptionVehiculeDejaPresent
     */
    public void addVehicule(Vehicule v1) throws ExceptionVehiculeDejaPresent {
            if(vehicules.contains(v1)) throw new ExceptionVehiculeDejaPresent(v1);
            vehicules.add(v1);
    }

    /**
     * Supprime un véhicule si il est present dans la liste
     * @param v1 Vehicule
     * @throws ExceptionVehiculePasPresent
     */
    public void supVehicule(Vehicule v1) throws ExceptionVehiculePasPresent{
        if(!vehicules.contains(v1)) throw new ExceptionVehiculePasPresent(v1);
        vehicules.remove(v1);

    }

    /**
     * retourne une liste de fourgon
     * @return onlyFourgon
     */
    public ArrayList<Vehicule> onlyFourgon(){
        ArrayList<Vehicule> onlyFourgon = new ArrayList<Vehicule>();
        for(Vehicule vehicule : vehicules){
            if (vehicule instanceof Fourgon){
                onlyFourgon.add(vehicule);
            }
        }
        return onlyFourgon;
    }

    /**
     * retourne une liste de Voiture
     * @return onlyVoiture
     */
    public ArrayList<Vehicule> onlyVoiture(){
        ArrayList<Vehicule> onlyVoiture = new ArrayList<Vehicule>();
        for(Vehicule vehicule : vehicules){
            if (vehicule instanceof Voiture){
                onlyVoiture.add(vehicule);
            }
        }
        return onlyVoiture;
    }

    /**
     * affiche les véhicules d'un certains type.
     * @param vehicules
     */
    public void afficherOnlyVehicules(ArrayList<Vehicule> vehicules){
        System.out.println("----------------------------------------------------------------------------------------");
        for (Vehicule vehicule : vehicules){
            System.out.println(vehicule);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    /**
     * affiche tous les véhicules
     */
    public void afficherListVehicules() {
        System.out.println("----------------------------------------------------------------------------------------");
        for (Vehicule vehicule : vehicules) {
            System.out.println(vehicule);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

}