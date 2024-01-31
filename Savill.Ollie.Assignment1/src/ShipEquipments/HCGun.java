/**
 * File name: HCGun.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipEquipments;

/**
 * A class implementing the weapon interface that overrides the toString method
 * to set the string to equal the accurate equipment for the HCGun used in the
 * HCShip. The output is a simple string.
 *
 * @author Ollie Savill
 */
public class HCGun implements Weapon {

    /**
     * A toString method that overrides the Weapon interface class to set the
     * input to the string below.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "57mm/70 caliber gun from Bofors";
    }
}
