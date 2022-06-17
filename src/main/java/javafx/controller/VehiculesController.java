package javafx.controller;

import client.CarnetClients;
import client.Client;
import client.ClientEntreprise;
import client.ClientParticulier;
import gestionvehicules.conducteur.Conducteur;
import gestionvehicules.conducteur.Conducteurs;
import gestionvehicules.conducteur.ExceptionConducteurDejaPresent;
import gestionvehicules.vehicule.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class VehiculesController {
    private Stage stage;

    private Scene scene;

    @FXML
    private Button ajouter;

    @FXML
    private VBox boxCaracteristiquesObjet;

    @FXML
    private Label conducteur;

    @FXML
    private Label kilometrage;

    @FXML
    private ListView<Vehicule> listChoix;

    @FXML
    private Label marque;

    @FXML
    private Label mise_circulation;

    @FXML
    private Label modele;

    @FXML
    private Label num_immatriculation;

    @FXML
    private Label poids_max;

    @FXML
    private Label type;

    @FXML
    private Label volume_max;

    Conducteurs conducteurs;
    FlotteVehicules flotteVehicules;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage= stage;
    }

    void startEditor(Vehicule vehicule) throws IOException, ExceptionConducteurDejaPresent {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../newvehicules-master-detail.fxml"));
            Parent viewContent = fxmlLoader.load();

            Scene addVehicule = new Scene(viewContent);
            stage.setScene(addVehicule);
            NewVehiculesController controller = fxmlLoader.getController();
            controller.setStage(stage);
            controller.setMainscene(scene);
            if(vehicule != null) controller.setVehicule(vehicule);
            controller.setConducteurs(Conducteurs.defaultConducteurs());
            controller.setFlotteVehicules(flotteVehicules);
            stage.show();


    }
    @FXML
    void onActionAjouter() throws IOException, ExceptionConducteurDejaPresent {
        startEditor(null);
    }
    @FXML
    void onActionRetour() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menu-master-detail.fxml"));
        Parent viewContent = fxmlLoader.load();
        MenuController controller = fxmlLoader.getController();
        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
        controller.setStage(stage);
        controller.setScene(scene);
    }
    @FXML
    void onActionModifier(ActionEvent event) throws IOException, ExceptionConducteurDejaPresent {
        startEditor(listChoix.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onActionSupprimer(ActionEvent event) throws ExceptionVehiculePasPresent {
        flotteVehicules.supVehicule(listChoix.getSelectionModel().getSelectedItem());
    }
    public void setFlotteVehicules(FlotteVehicules flotteVehicules){
        this.flotteVehicules = flotteVehicules;
        listChoix.setItems(flotteVehicules.GetList());
        listChoix.getSelectionModel().selectedItemProperty().addListener((o,p,n) ->{
            num_immatriculation.setText("Numéro d'immatriculation : " + n.getNum_immatriculation());
            modele.setText("Modèle : " +n.getModele());
            marque.setText("Marque : "+n.getMarque());
            kilometrage.setText("Kilométrage : "+Double.toString(n.getKilometrage()));
            mise_circulation.setText("Mise en circulation : "+ n.getMise_circulation());
            if(n instanceof Fourgon fourgon){
                poids_max.setVisible(true);
                volume_max.setVisible(true);
                poids_max.setText("Poids max : " + fourgon.getPoids_max());
                volume_max.setText("Volume max : " + fourgon.getVolume_max());
                type.setText("Véhicule : Fourgon");
                conducteur.setText("Conducteur : "+fourgon.getLivreur().getNom());
            } else if (n instanceof Voiture voiture) {
                poids_max.setVisible(false);
                volume_max.setVisible(false);
                type.setText("Véhicule : Voiture");
                conducteur.setText("Conducteur : "+voiture.getCommercial().getNom());
            }
        });
    }

    public void setMasterDetailController(FlotteVehicules flotteVehicules){
        listChoix.setItems(flotteVehicules.GetList());
        listChoix.setCellFactory(List ->{
            return new ListCell<>(){
                @Override
                public void updateItem(Vehicule vehicule, boolean empty){
                    super.updateItem(vehicule,empty);
                    if(empty || (vehicule == null)){
                        setText(null);
                    }
                    else {
                        setText(vehicule.getNum_immatriculation());
                    }
                }
            };
        });
    }
}