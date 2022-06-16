package test;

import gestionvehicules.conducteur.*;
import gestionvehicules.vehicule.ExceptionVehiculeDejaPresent;
import gestionvehicules.vehicule.FlotteVehicules;
import gestionvehicules.vehicule.Fourgon;
import gestionvehicules.vehicule.Voiture;

public class TestGestionVehicules {
    public static void main(String args[])  {
        Livreur l1 = new Livreur("Potier","Hugo","1", Permis.A);
        Livreur l2 = new Livreur("Joly","Yoann","2", Permis.A);
        Livreur l3 = new Livreur("Riquart","Antonin","3", Permis.A);
        Livreur l4 = new Livreur("Guyot","Lucas","4", Permis.A);
        Livreur l5 = new Livreur("Mahieux","Clement","5", Permis.A);
        Commercial c1 = new Commercial("Grasso","Antoine","6", Permis.B);
        Commercial c2 = new Commercial("Hochard","Lucas","7", Permis.B);
        Commercial c3 = new Commercial("Hochard","Quentin","8", Permis.B);
        Commercial c4 = new Commercial("Khounviseth","Max","9", Permis.B);
        Commercial c5 = new Commercial("Delcourt","Mattis","10", Permis.B);

        Fourgon f1 = new Fourgon("ABCC","Sandero","Dacia",60000,2008,800,50,l1);
        Fourgon f2 = new Fourgon("EVGR","RS8","Audi",51506,2007,800,50,l2);
        Fourgon f3 = new Fourgon("FAFF","Q7","Audi",60000,2018,800,50,l3);
        Fourgon f4 = new Fourgon("FHEZ","Laguna","Renault",60000,2016,800,50,l4);
        Fourgon f5 = new Fourgon("HJZD","RS7","Audi",60000,2020,800,50,l5);
        Voiture v1 = new Voiture("AZCE","A1","Audi",78000,2015,c2);
        Voiture v2 = new Voiture("BFEG","A2","Audi",78000,2016,c3);
        Voiture v3 = new Voiture("NCXJ","A3","Audi",78000,2017,c4);
        Voiture v4 = new Voiture("ZEJF","A4","Audi",78000,2018,c5);
        Voiture v5 = new Voiture("FAKP","A5","Audi",78000,2019,c1);

        FlotteVehicules flotte = new FlotteVehicules();
        Conducteurs list = new Conducteurs();

        try{
            flotte.addVehicule(f1);
            flotte.addVehicule(f2);
            flotte.addVehicule(f3);
            flotte.addVehicule(f4);
            flotte.addVehicule(f5);
            flotte.addVehicule(v1);
            flotte.addVehicule(v2);
            flotte.addVehicule(v3);
            flotte.addVehicule(v4);
            flotte.addVehicule(v5);
        }catch (ExceptionVehiculeDejaPresent e){
            System.err.println(e.getMessage());
        }
        try {
            list.addConducteur(l1);
            list.addConducteur(l2);
            list.addConducteur(l3);
            list.addConducteur(l4);
            list.addConducteur(l5);
            list.addConducteur(c1);
            list.addConducteur(c2);
            list.addConducteur(c3);
            list.addConducteur(c4);
            list.addConducteur(c5);
        }catch (ExceptionConducteurDejaPresent e){
            System.err.println(e.getMessage());
        }

//        try{
//            list.supConducteur(c3);
//        }catch (ExceptionConducteurPasPresent e){
//            System.err.println(e.getMessage());
//        }
//        System.out.println("AVANT TRI CONDUCTEUR");
//        list.afficherListConducteur();
//        list.trierNom();
//        System.out.println("APRES TRI CONDUCTEUR");
//        list.afficherListConducteur();

        System.out.println("AVANT TRI VEHICULE");
        flotte.afficherListVehicules();
        flotte.triVehicule();
        System.out.println("APRES TRI VEHICULE");
        flotte.afficherListVehicules();
    }
}