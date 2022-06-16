package gestionvehicules.vehicule;

import gestionvehicules.conducteur.Commercial;
import gestionvehicules.conducteur.Livreur;
import gestionvehicules.conducteur.Permis;
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

    public static FlotteVehicules defaultFlotte() throws ExceptionVehiculeDejaPresent {
        FlotteVehicules flotteVehicules = new FlotteVehicules();

        flotteVehicules.addVehicule(new Fourgon("ABCC","Sandero","Dacia",60000,2008,800,50,new Livreur("Potier","Hugo","1", Permis.A)));
        flotteVehicules.addVehicule(new Fourgon("EVGR","RS8","Audi",51506,2007,800,50,new Livreur("Joly","Yoann","2", Permis.A)));
        flotteVehicules.addVehicule(new Fourgon("FAFF","Q7","Audi",60000,2018,800,50,new Livreur("Riquart","Antonin","3", Permis.A)));
        flotteVehicules.addVehicule(new Fourgon("FHEZ","Laguna","Renault",60000,2016,800,50,new Livreur("Guyot","Lucas","4", Permis.A)));
        flotteVehicules.addVehicule(new Fourgon("HJZD","RS7","Audi",60000,2020,800,50,new Livreur("Mahieux","Clement","5", Permis.A)));
        flotteVehicules.addVehicule(new Voiture("AZCE","A1","Audi",78000,2015,new Commercial("Grasso","Antoine","6", Permis.B)));
        flotteVehicules.addVehicule(new Voiture("BFEG","A2","Audi",78000,2016,new Commercial("Hochard","Lucas","7", Permis.B)));
        flotteVehicules.addVehicule(new Voiture("NCXJ","A3","Audi",78000,2017,new Commercial("Hochard","Quentin","8", Permis.B)));
        flotteVehicules.addVehicule(new Voiture("ZEJF","A4","Audi",78000,2018,new Commercial("Khounviseth","Max","9", Permis.B)));
        flotteVehicules.addVehicule(new Voiture("FAKP","A5","Audi",78000,2019,new Commercial("Delcourt","Mattis","10", Permis.B)));
        return flotteVehicules;
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

    public ObservableList<Vehicule> GetList() {
        return this.vehicules;
    }
}