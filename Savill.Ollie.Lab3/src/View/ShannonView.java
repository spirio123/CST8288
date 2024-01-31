/**
 * File name: ShannonView.java
 * Package: View;
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * The ShannonView class represents the view component of an MVC application
 * that calculates Shannon's Theorem. It consists of a GridPane layout
 * containing labels, text fields, and a button for user input.
 *
 * @author Ollie Savill
 */
public class ShannonView extends GridPane {

    // Labels
    Label bwLbl = new Label("Bandwidth:");
    Label snrLbl = new Label("Signal to noise ratio:");
    Label mdrLbl = new Label("Max Data Rate: ");

    // Fields
    TextField bwFld = new TextField();
    TextField snrFld = new TextField();
    TextField mdrFld = new TextField();

    // Buttons
    Button calculateBtn = new Button("Calculate");

    /**
     * Constructs a new ShannonView with the default layout.
     */
    public ShannonView() {
        layoutForm();
    }

    /**
     * Sets up the form layout with labels, text fields, and a button.
     */
    private void layoutForm() {
        this.setHgap(5);
        this.setVgap(5);

        this.add(bwLbl, 1, 2);
        this.add(snrLbl, 1, 3);
        this.add(mdrLbl, 1, 4);

        this.add(bwFld, 2, 2);
        this.add(snrFld, 2, 3);
        this.add(mdrFld, 2, 4);

        // Add buttons and make them the same width
        VBox buttonBox = new VBox(calculateBtn);
        calculateBtn.setMaxWidth(Double.MAX_VALUE);

        this.add(buttonBox, 3, 4, 1, 5);
    }

}
