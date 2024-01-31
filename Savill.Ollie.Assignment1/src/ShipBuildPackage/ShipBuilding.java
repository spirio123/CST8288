/**
 * File name: ShipBuilding.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipBuildPackage;

import ShipPackage.Ship;

/**
 * An abstract interface class used in conjunction with the SurfaceShipBuilding
 * class. When the SurfaceShipBuilding class determines the type of ship, it
 * makes and equips that ship.
 *
 * @author Rama, commented by Ollie
 */
public abstract class ShipBuilding {

    protected abstract Ship makeCanadianShip(String typeOfShip);

    /**
     * Creates the new ship of the specified type and returns it after it has
     * been equipped.
     *
     * @param typeOfShip the type of ship
     * @return theShip the new ship object
     */
    public Ship orderTheShip(String typeOfShip) {
        Ship theShip = makeCanadianShip(typeOfShip);
        theShip.equipShip();
        return theShip;

    }
}
