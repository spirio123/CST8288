/**
 * File name: CSCShip.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipPackage;

import ShipFactoryPackage.ShipFactory;

/**
 * The CSCShip class uses inheritance to get information from the Ship interface
 * to set the weapon and engine wanted by the CSCShip. The weapon and engine are
 * defined in separate classes, namely the CSCEngine and CSCGun classes.
 *
 * @author Ollie Savill
 */
public class CSCShip extends Ship {

    ShipFactory shipFactory;

    /**
     * Constructs a new CSCShip using the specified ShipFactory.
     *
     * @param shipFactory the factory to be used for creating the ship's
     * components
     */
    public CSCShip(ShipFactory shipFactory) {

        this.shipFactory = shipFactory;
    }

    /**
     * This method overrides the equipShip method defined in the Ship class and
     * sets the equipment for the CSCShip by using the addGun and addEngine
     * methods previously defined.
     */
    @Override
    public void equipShip() {

        System.out.println("Adding equipments to Canadian Surface Combatant ship " + getName());
        setWeapon(shipFactory.addGun());
        setEngine(shipFactory.addEngine());
    }
}
