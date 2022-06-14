package javafx.controller;

import client.CarnetClients;
import client.Client;
import client.ClientEntreprise;
import client.ClientParticulier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CarnetsClientController {

    private Stage stage;

    private Scene scene;
    @FXML
    private Label genre;
    @FXML
    private Label prenom;
    @FXML
    private Label adresse;
    @FXML
    private Label nom;

    @FXML
    private Label contact;

    @FXML
    private Label pointfidelite;

    @FXML
    private VBox boxCaracteristiquesObjet;

    @FXML
    private ListView<Client> listChoix;

    private CarnetClients carnet;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage= stage;
    }


    void startEditor(Client client) throws IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../new-master-detail.fxml"));
            Parent viewContent = fxmlLoader.load();

            Scene addClient = new Scene(viewContent);
            stage.setScene(addClient);
            NewCarnetsClientController controller = fxmlLoader.getController();
            controller.setStage(stage);
            controller.setMainscene(scene);
            if(client != null) controller.setClient(client);
            controller.setCarnet(carnet);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
    @FXML
    void onActionAjouter() throws IOException {
        startEditor(null);
    }

    @FXML
    void onActionModifier(ActionEvent event) throws IOException{
        startEditor(listChoix.getSelectionModel().getSelectedItem());

    }

    @FXML
    void onActionSupprimer(ActionEvent event) {
        carnet.supprimerClient(listChoix.getSelectionModel().getSelectedItem());
    }
    public void setCarnet(CarnetClients carnet){
        this.carnet = carnet;
        listChoix.setItems(carnet.GetList());
        listChoix.getSelectionModel().selectedItemProperty().addListener((o,p,n) ->{
            nom.setText("Nom : " + n.getNom());
            adresse.setText("Adresse : " +n.getAdresse());
            pointfidelite.setText("Points de fidelite : "+Integer.toString(n.getPointsFidelite()));
            if(n instanceof ClientParticulier client){
                prenom.setVisible(true);
                genre.setVisible(true);
                prenom.setText("Prenom : " + client.getPrenom());
                genre.setText("Genre : " + client.getGenre());
                contact.setVisible(false);
            } else if (n instanceof ClientEntreprise client) {
                prenom.setVisible(false);
                genre.setVisible(false);
                contact.setVisible(true);
                contact.setText("Contact : " + client.getContact());
            }
        });
    }
    public void setMasterDetailController(CarnetClients carnet){
        listChoix.setItems(carnet.GetList());
        listChoix.setCellFactory(List ->{
            return new ListCell<>(){
                @Override
                public void updateItem(Client client, boolean empty){
                    super.updateItem(client,empty);
                    if(empty || (client == null)){
                        setText(null);
                    }
                    else {
                        setText(client.getNom());
                    }
                }
            };
        });
    }
}