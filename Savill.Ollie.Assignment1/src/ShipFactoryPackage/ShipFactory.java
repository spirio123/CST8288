/**
 * File name: ShipFactory.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipFactoryPackage;

import ShipEquipments.Engine;
import ShipEquipments.Weapon;

/**
 * This class defines the required equipments for each ship. It is implemented
 * by the HCShipFactory and the CSCShipFactory.
 *
 * @author Rama, commented by Ollie
 */
public interface ShipFactory {

    /**
     * The Weapon method used when determining the gun used on the ship.
     *
     * @return addGun
     */
    public Weapon addGun();

    /**
     * The Engine method used when determining the engine used on the ship.
     *
     * @return addEngine
     */
    public Engine addEngine();
}
