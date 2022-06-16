package javafx.controller;

import java.io.IOException;

import article.Stock;
import client.CarnetClients;
import gestionvehicules.vehicule.ExceptionVehiculeDejaPresent;
import gestionvehicules.vehicule.FlotteVehicules;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
	
	private Stage stage;

    private Scene scene;
    
    private CarnetClients carnet;
    
    private Stock stock;
    
    
    @FXML
    void bouttonClients(ActionEvent event) throws IOException {
    	CarnetClients carnetclient = CarnetClients.defaultCarnet();
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../master-detail.fxml"));
        Parent viewContent = fxmlLoader.load();
        Scene addClient = new Scene(viewContent);
        stage.setScene(addClient);
        CarnetsClientController controller = fxmlLoader.getController();
        controller.setStage(stage); 
        controller.setScene(addClient);
        controller.setCarnet(carnetclient);
        controller.setMasterDetailController(carnetclient);
    }

    @FXML
    void bouttonCommandes(ActionEvent event) {

    }

    @FXML
    void bouttonStock(ActionEvent event) throws IOException {

    }

    @FXML
    void bouttonVehicule(ActionEvent event) throws IOException, ExceptionVehiculeDejaPresent {
        FlotteVehicules flotteVehicules = FlotteVehicules.defaultFlotte();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vehicules-master-detail.fxml"));
        Parent viewContent = fxmlLoader.load();
        Scene addVehicule = new Scene(viewContent);
        stage.setScene(addVehicule);
        VehiculesController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setScene(addVehicule);
        controller.setFlotteVehicules(flotteVehicules);
        controller.setMasterDetailController(flotteVehicules);

    }
    
    public void setScene(Scene scene) {
    	this.scene=scene;
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }

}