/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package javafx;

import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import javafx.application.Application;
import javafx.controller.CarnetsClientController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La classe HelloApplication illustre le fonctionnement d'une {@link Application} JavaFX.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class GestionApplication extends Application {

    /**
     * Cette méthode permet d'initialiser l'affichage de la fenêtre de l'application.
     *
     * @param stage La fenêtre (initialement vide) de l'application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        CarnetClients carnetClients = CarnetClients.defaultCarnet();
        // Il faut d'abord récupérer la description de la vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("master-detail.fxml"));
        Parent viewContent = fxmlLoader.load();
        CarnetsClientController controller = fxmlLoader.getController();
        controller.setMasterDetailController(carnetClients);
        // Ensuite, on la place dans une Scene...
		Scene scene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre.
        controller.bind(carnetClients);
        stage.setScene(scene);

        // On peut ensuite donner un titre à la fenêtre.
        stage.setTitle(CarnetClients.defaultCarnet().getNom());

        // Enfin, on affiche la fenêtre.
        stage.show();
    }

    /**
     * Cette méthode exécute l'application JavaFX.
     * Pour le cours d'IHM, la méthode {@code main} d'une application JavaFX sera
     * toujours la même : un simple appel à la méthode {@link #launch(String...)}
     * définie dans la classe {@link Application}.
     *
     * @param args Les arguments de la ligne de commande (dont on ne tient pas compte).
     *
     * @see #launch(String...)
     */
    public static void main(String[] args) {
        launch();
    }

}
