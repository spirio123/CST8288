/**
 * File name: CSCEngine.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipEquipments;

/**
 * A class implementing the engine interface that overrides the toString method
 * to set the string to equal the accurate equipment for the CSCEngine used in
 * the CSCShip. The output is a simple string.
 *
 * @author Ollie Savill
 */
public class CSCEngine implements Engine {

    /**
     * A toString method that overrides the Engine interface class to set the
     * input to the string below.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "maximum speed of 27 Knots (50 Km/hour)";
    }
;
}
