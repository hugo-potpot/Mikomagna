package javafx.controller;

import client.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewCarnetsClientController {
    private Client clienttmp;
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

    @FXML
    private Label erreur;

    private CarnetClients carnet;
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setMainscene(Scene mainscene) {
        this.mainscene = mainscene;
    }

    public void setCarnet(CarnetClients carnet){
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
        if(InNom.getText().equals("")){
            erreur.setText("Rentrer nom");
            return;
        }
        if (InAdresse.getText().equals("")){
            erreur.setText("Rentrer adresse");
            return;
        }
        if (InPoint.getText().equals("")){
            erreur.setText("Rentrer point de fidélité en chiffre");
            return;
        }
        if(clienttmp == null){
            if(Title.getText().contains("Particulier")){
                if(InPrenom.getText().equals("")){
                    erreur.setText("Rentrer prénom");
                    return;
                }
                if(SelectGenre.getSelectionModel().getSelectedItem() == null){
                    erreur.setText("Rentrer GENRE");
                    return;
                }
                carnet.ajouterClient(new ClientParticulier(InNom.getText(),InAdresse.getText(),Integer.parseInt(InPoint.getText()),InPrenom.getText()
                        ,SelectGenre.getValue()));
            }
            else if (Title.getText().contains("Entreprise")){
                if(InPrenom.getText().equals("")){
                    erreur.setText("Rentrer Contact");
                    return;
                }
                carnet.ajouterClient(new ClientEntreprise(InNom.getText(),InAdresse.getText(),Integer.parseInt(InPoint.getText()),InPrenom.getText()));
            }

        }
        if(clienttmp !=null) {
            if(!clienttmp.getNom().equals(InNom.getText()))
                clienttmp.setNom(InNom.getText());
            if(!clienttmp.getAdresse().equals(InAdresse.getText()))
                clienttmp.setAdresse(InAdresse.getText());
            if(!Integer.valueOf(clienttmp.getPointsFidelite()).equals(Integer.valueOf(InPoint.getText())))
                clienttmp.setAdresse(InPoint.getText());
            if(clienttmp instanceof ClientParticulier){
                if(!((ClientParticulier) clienttmp).getGenre().equals(SelectGenre.getValue()))
                    ((ClientParticulier) clienttmp).setGenre(SelectGenre.getValue());
                if (!((ClientParticulier) clienttmp).getPrenom().equals(InPrenom.getText()))
                    ((ClientParticulier) clienttmp).setPrenom(InPrenom.getText());
                if(InPrenom.getText().equals("")){
                    erreur.setText("Rentrer prénom");
                    return;
                }
                if(SelectGenre.getSelectionModel().getSelectedItem() == null){
                    erreur.setText("Rentrer GENRE");
                    return;
                }
            }
            if(clienttmp instanceof ClientEntreprise){
                if(!((ClientEntreprise) clienttmp).getContact().equals(InPrenom.getText()))
                    ((ClientEntreprise) clienttmp).setContact(InPrenom.getText());
                if(InPrenom.getText().equals("")){
                    erreur.setText("Rentrer Contact");
                    return;
                }
            }
        }

        stage.setScene(mainscene);
    }

    public void setClient(Client client) {
        this.clienttmp = client;
        SelectType.setDisable(true);
        InNom.setText(client.getNom());
        InAdresse.setText(client.getAdresse());
        InPoint.setText(Integer.toString(client.getPointsFidelite()));
        if(client instanceof ClientEntreprise){
            SelectType.getSelectionModel().select("Entreprise");
            InPrenom.setText(((ClientEntreprise) client).getContact());
        }
        else{
            SelectType.getSelectionModel().select("Particulier");
            InPrenom.setText(((ClientParticulier) client).getPrenom());
            SelectGenre.getSelectionModel().select(((ClientParticulier) client).getGenre());
        }

    }
}