package javafx.controller;

import client.*;
import gestionvehicules.conducteur.Commercial;
import gestionvehicules.conducteur.Conducteur;
import gestionvehicules.conducteur.Conducteurs;
import gestionvehicules.conducteur.Livreur;
import gestionvehicules.vehicule.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewVehiculesController {

    private Vehicule vehiculetmp;
    private Scene mainscene;

    private Stage stage;
    @FXML
    private ComboBox<String> SelectType;

    @FXML
    private Label Title;

    @FXML
    private Label erreur;

    @FXML
    private TextField inKilo;

    @FXML
    private TextField inMarque;

    @FXML
    private TextField inMiseCircu;

    @FXML
    private TextField inModele;

    @FXML
    private TextField inNumImma;

    @FXML
    private TextField inPoidsMax;

    @FXML
    private TextField inVolumeMax;

    @FXML
    private Label labelPrename;

    @FXML
    private VBox vboxFourgon;

    @FXML
    private ComboBox<Conducteur> selectConducteur;

    private Conducteurs conducteurs;

    FlotteVehicules flotteVehicules;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setMainscene(Scene mainscene) {
        this.mainscene = mainscene;
    }

    public void setFlotteVehicules(FlotteVehicules flotteVehicules){
        this.flotteVehicules = flotteVehicules;
    }

    @FXML
    void initialize(){
        selectConducteur.setItems(FXCollections.observableArrayList(conducteurs.getListConducteur()));
        SelectType.setItems(FXCollections.observableArrayList("Fourgon", "Voiture"));
        SelectType.getSelectionModel().selectedItemProperty().addListener((o,p,n) -> {
            Title.setText("Véhicule"+n);
            if(n.equals("Fourgon")){
                vboxFourgon.setVisible(true);
            }
            else{
                vboxFourgon.setVisible(false);
            }
        });
    }

    @FXML
    void onActionAnnuler() {
        stage.setScene(mainscene);
    }
    @FXML
    void onActionValider() throws ExceptionVehiculeDejaPresent {
        if(inNumImma.getText().equals("")){
            erreur.setText("Rentrer numéro d'immatriculation");
            return;
        }
        if (inModele.getText().equals("")){
            erreur.setText("Rentrer modèle");
            return;
        }
        if (inMarque.getText().equals("")){
            erreur.setText("Rentrer marque");
            return;
        }
        if(inKilo.getText().equals("")){
            erreur.setText("Rentrer kilométrage en chiffre");
            return;
        }
        if(inMiseCircu.getText().equals("")){
            erreur.setText("Rentrer année mise en circulation en chiffre");
            return;
        }
        if(vehiculetmp == null){
            if(Title.getText().contains("Fourgon")){
                if(inPoidsMax.getText().equals("")){
                    erreur.setText("Rentrer poids maximum");
                    return;
                }
                if(inVolumeMax.getText().equals("")){
                    erreur.setText("Rentrer volume maximum");
                }
                if(selectConducteur.getSelectionModel().getSelectedItem() == null){
                    erreur.setText("Rentrer CONDUCTEUR");
                    return;
                }
                flotteVehicules.addVehicule(new Fourgon(inNumImma.getText(),inModele.getText(),inMarque.getText(),Double.parseDouble(inKilo.getText()),Integer.parseInt(inMiseCircu.getText()),Double.parseDouble(inPoidsMax.getText()),Double.parseDouble(inVolumeMax.getText()),((Livreur) selectConducteur.getSelectionModel().getSelectedItem())));
            }
            else if (Title.getText().contains("Voiture")){
                if(selectConducteur.getSelectionModel().getSelectedItem() == null){
                    erreur.setText("Rentrer CONDUCTEUR");
                    return;
                }
                flotteVehicules.addVehicule(new Voiture(inNumImma.getText(),inModele.getText(),inMarque.getText(),Double.parseDouble(inKilo.getText()),Integer.parseInt(inMiseCircu.getText()),((Commercial) selectConducteur.getSelectionModel().getSelectedItem())));
            }

        }
        if(vehiculetmp !=null) {
            if(!vehiculetmp.getNum_immatriculation().equals(inNumImma.getText()))
                vehiculetmp.setNum_immatriculation(inNumImma.getText());

            if(!vehiculetmp.getModele().equals(inModele.getText()))
                vehiculetmp.setModele(inModele.getText());

            if(!vehiculetmp.getMarque().equals(inMarque.getText()))
                vehiculetmp.setMarque(inMarque.getText());

            if(!Double.valueOf(vehiculetmp.getKilometrage()).equals(Double.valueOf(inKilo.getText())))
                vehiculetmp.setKilometrage(Double.valueOf(inKilo.getText()));

            if(selectConducteur.getSelectionModel().getSelectedItem() == null){
                erreur.setText("Rentrer CONDUCTEUR");
                return;
            }

            if(vehiculetmp instanceof Fourgon fourgon){
                if(!Double.valueOf(fourgon.getVolume_max()).equals(Double.valueOf(inVolumeMax.getText())))
                    fourgon.setVolume_max(Double.valueOf(inVolumeMax.getText()));

                if(!Double.valueOf(fourgon.getPoids_max()).equals(Double.valueOf(inPoidsMax.getText())))
                    fourgon.setPoids_max(Double.valueOf(inPoidsMax.getText()));

                if(inVolumeMax.getText().equals("")){
                    erreur.setText("Rentrer volume max");
                    return;
                }

                if(inPoidsMax.getText().equals("")){
                    erreur.setText("Rentrer poids max");
                    return;
                }

                if(selectConducteur.getSelectionModel().getSelectedItem() == null){
                    erreur.setText("Rentrer CONDUCTEUR");
                    return;
                }
            }
        }

        stage.setScene(mainscene);
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehiculetmp = vehicule;
        SelectType.setDisable(true);
        inNumImma.setText(vehicule.getNum_immatriculation());
        inModele.setText(vehicule.getModele());
        inMarque.setText(vehicule.getMarque());
        inMiseCircu.setText(Double.toString(vehicule.getMise_circulation()));
        selectConducteur.getSelectionModel().getSelectedItem();
        if(vehicule instanceof Fourgon fourgon){
            inVolumeMax.setText(Double.toString(fourgon.getVolume_max()));
            inPoidsMax.setText(Double.toString(fourgon.getPoids_max()));
            SelectType.getSelectionModel().select("Fourgon");
        }
        else{
            SelectType.getSelectionModel().select("Vehicule");
        }

    }

}