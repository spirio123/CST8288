/**
 * File name: ShannonLaunch.java
 * Package: Launch
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package Launch;

import Model.ShannonsTheorem;
import View.ShannonPresenter;
import View.ShannonView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for the Shannon's Theorem application. This class extends
 * Application and initializes the model, view, and presenter.
 *
 * @author Ollie Savill
 */
public class ShannonLaunch extends Application {

    /**
     * The main method for launching the application.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Starts the JavaFX application by initializing the model, view, and
     * presenter. Sets up the primary stage with the view and shows it.
     *
     * @param stage The primary stage for this JavaFX application
     */
    @Override
    public void start(Stage stage) {
        ShannonsTheorem model = new ShannonsTheorem();
        ShannonView view = new ShannonView();

        Scene scene = new Scene(view);
        scene.getStylesheets().add(getClass().getResource("shannon.css").toExternalForm());

        ShannonPresenter presenter = new ShannonPresenter(model, view);

        stage.setScene(scene);
        stage.setTitle("Shannon Theorem");
        stage.show();
    }
}
