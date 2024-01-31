/**
 * File name: ShannonPresenter.java
 * Package: View
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package View;

import Model.ShannonsTheorem;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * This class represents the presenter component in the Model-View-Presenter
 * (MVP) pattern for the Shannon's Theorem application. The ShannonPresenter is
 * responsible for managing the communication between the Model
 * (ShannonsTheorem) and the View (ShannonView). It updates the View based on
 * the Model's state and updates the Model based on user interactions with the
 * View.
 *
 * @author Ollie Savill
 */
public class ShannonPresenter {

    //Declarations
    private final ShannonsTheorem model;
    private final ShannonView view;
    private final SimpleStringProperty bwInternal = new SimpleStringProperty();
    private final SimpleStringProperty snrInternal = new SimpleStringProperty();
    private final SimpleStringProperty mdrInternal = new SimpleStringProperty();

    /**
     *
     * Constructor that initializes the model and view instances and sets up the
     * data bindings and event handling.
     *
     * @param model ShannonsTheorem instance representing the model.
     * @param view ShannonView instance representing the view.
     */
    public ShannonPresenter(ShannonsTheorem model, ShannonView view) {
        this.model = model;
        this.view = view;
        bindToModel();
        attachViewEvents();
    }

    /**
     *
     * Binds the presenter's internal properties to the corresponding model
     * properties.
     */
    private void bindToModel() {
        bwInternal.bindBidirectional(model.bandWidthProperty());
        snrInternal.bindBidirectional(model.signalToNoiseRatioProperty());
        mdrInternal.bind(model.maxDataRateProperty());
    }

    /**
     *
     * Attaches event listeners to the view components and binds the view's
     * properties to the presenter's internal properties.
     */
    private void attachViewEvents() {
        view.bwFld.textProperty().bindBidirectional(bwInternal);
        view.snrFld.textProperty().bindBidirectional(snrInternal);
        view.mdrFld.textProperty().bind(mdrInternal);
        view.calculateBtn.setOnAction(e -> {
            handle();
        });
    }

    /**
     *
     * A method that holds a try catch with an alert that only shows if either
     * of the inputs are not numbers. If both of the inputs are numbers it runs
     * the program as per normal.
     */
    public void handle() {
        try {
            Double.valueOf(view.bwFld.getText());
            Double.valueOf(view.snrFld.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText(view.bwFld.getText()+ "\n" + view.snrFld.getText());
            alert.setHeaderText("Please enter a valid number and not:");
            alert.showAndWait();
            clean();
            return;
        }
        maxDataRate();
    }

    /**
     *
     * Calls the maxDataRate() method of the model to calculate the maximum data
     * rate based on the current bandwidth and signal-to-noise ratio.
     */
    private void maxDataRate() {
        model.maxDataRate();
        System.out.println(model.toString());
    }

    private void clean() {
        view.bwFld.setText("");
        view.snrFld.setText("");
        view.mdrFld.setText("");
    }
}
