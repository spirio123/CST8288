/**
 * File name: CSCShipFactory.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipFactoryPackage;

import ShipEquipments.CSCGun;
import ShipEquipments.Engine;
import ShipEquipments.Weapon;
import ShipEquipments.CSCEngine;

/**
 * This class is used the define the weapon and the engine for the CSCShip using
 * the ShipFactory interface. It implements the Weapon and Engine methods.
 *
 * @author Ollie Savill
 */
public class CSCShipFactory implements ShipFactory {

    /**
     * Creates and defines a new object called gun to add the CSCGun to the
     * CSCShip.
     *
     * @return gun
     */
    @Override
    public Weapon addGun() {
        CSCGun gun = new CSCGun();
        return gun;
    }

    /**
     * Creates and defines a new object called engine to add the CSCEngine to
     * the CSCShip.
     *
     * @return engine
     */
    @Override
    public Engine addEngine() {
        CSCEngine engine = new CSCEngine();
        return engine;
    }
}
