/**
 * File name: HCShipFactory.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipFactoryPackage;

import ShipEquipments.HCEngine;
import ShipEquipments.Engine;
import ShipEquipments.Weapon;
import ShipEquipments.HCGun;

/**
 * This class is used the define the weapon and the engine for the HCShip using
 * the ShipFactory interface. It implements the Weapon and Engine methods.
 *
 * @author Ollie Savill
 */
public class HCShipFactory implements ShipFactory {

    /**
     * Creates and defines a new object called gun to add the HCGun to the
     * HCShip.
     *
     * @return gun
     */
    @Override
    public Weapon addGun() {
        HCGun gun = new HCGun();
        return gun;
    }

    /**
     * Creates and defines a new object called engine to add the HCEngine to the
     * HCShip.
     *
     * @return engine
     */
    @Override
    public Engine addEngine() {
        HCEngine engine = new HCEngine();
        return engine;
    }
}
