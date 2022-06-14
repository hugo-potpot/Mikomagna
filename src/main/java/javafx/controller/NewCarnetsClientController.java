package javafx.controller;

import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class NewCarnetsClientController {

    private Scene mainscene;

    private Stage stage;
    @FXML
    private TextField InAdresse;

    @FXML
    private TextField InNom;

    @FXML
    private TextField InPoint;

    @FXML
    private TextField InPrenom;

    @FXML
    private ComboBox<Genre> SelectGenre;

    @FXML
    private ComboBox<String> SelectType;

    @FXML
    private Label Title;
    @FXML
    private Label labelPrename;

    private CarnetClients carnet;
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setMainscene(Scene mainscene) {
        this.mainscene = mainscene;
    }

    public void bind(CarnetClients carnet){
        this.carnet = carnet;
    }
    @FXML
    void initialize(){
        SelectGenre.setItems(FXCollections.observableArrayList(Genre.values()));
        SelectType.setItems(FXCollections.observableArrayList("Particulier", "Entreprise"));
        SelectType.getSelectionModel().selectedItemProperty().addListener((o,p,n) -> {
            Title.setText("Client "+n);
            if(n.equals("Particulier")){
                SelectGenre.setVisible(true);
                labelPrename.setText("Prenom : ");
                InPrenom.setPromptText("Prenom");
            }
            else{
                SelectGenre.setVisible(false);
                InPrenom.setPromptText("Contact");
                labelPrename.setText("Contact : ");
            }
        });
    }

    @FXML
    void onActionAnnuler() {
        stage.setScene(mainscene);
    }
    @FXML
    void onActionValider() {
        if(Title.getText().contains("Particulier")){
            carnet.ajouterClient(new ClientParticulier(InNom.getText(),InAdresse.getText(),Integer.parseInt(InPoint.getText()),InPrenom.getText()
                    ,SelectGenre.getValue()));
        }
        else
            carnet.ajouterClient(new ClientEntreprise(InNom.getText(),InAdresse.getText(),Integer.parseInt(InPoint.getText()),InPrenom.getText()));
        stage.setScene(mainscene);
    }

}