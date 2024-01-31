/**
 * File name: HCShip.java
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
 * The HCShip class uses inheritance to get information from the Ship interface
 * to set the weapon and engine wanted by the HCShip. The weapon and engine are
 * defined in separate classes, namely the HCEngine and HCGun classes.
 *
 * @author Ollie Savill
 */
public class HCShip extends Ship {

    ShipFactory shipFactory;

    /**
     * Constructs a new HCShip using the specified ShipFactory.
     *
     * @param shipFactory the factory to be used for creating the ship's
     * components
     */
    public HCShip(ShipFactory shipFactory) {
        this.shipFactory = shipFactory;
    }

    /**
     * This method overrides the equipShip method defined in the Ship class and
     * sets the equipment for the HCShip by using the addGun and addEngine
     * methods previously defined.
     */
    @Override
    public void equipShip() {

        System.out.println("Adding equipments to Halifax Class ship " + getName());
        setWeapon(shipFactory.addGun());
        setEngine(shipFactory.addEngine());
    }
}
