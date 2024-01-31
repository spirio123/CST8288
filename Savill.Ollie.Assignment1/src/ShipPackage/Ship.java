/**
 * File name: Ship.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipPackage;

import ShipEquipments.Engine;
import ShipEquipments.Weapon;

/**
 * This is an abstract class implemented by the CSCShip and the HCShip
 * classes. It defines all of the parts and the name used throughout the factory
 * build pattern.
 *
 * @author Rama, commented by Ollie Savill
 */
public abstract class Ship {

    private String name;
    Weapon weapon;
    Engine engine;

    /**
     * The get method for the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * The set method that sets the name for the specific ship called.
     *
     * @param newName the set name for the ship
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * The get method for the weapon
     *
     * @return weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * The get method for the engine
     *
     * @return engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * The set method that sets the weapon for the specific ship called.
     *
     * @param weapon the set weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * the set method that sets the engine for the specific ship called.
     *
     * @param engine the set engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * The equipShip method used to set the objects used on each ship. Very
     * expandable if more equipment is required.
     */
    public abstract void equipShip();

    /**
     * Displays the ship speed by using the getName method to get the name
     * depending on what ship is being displayed and the engine for that same
     * ship. engine uses the toString method to print out the information.
     */
    public void displayShipSpeed() {

        System.out.println(getName() + " Engine: " + engine);

    }

    /**
     * Displays the weapon used by using the getName method to get the name
     * depending on what ship is being displayed and the weapon for that same
     * ship. weapon uses the toString method to print out the information.
     */
    public void shipGunDesc() {

        System.out.println(getName() + " Gun: " + weapon);

    }

    /**
     * The toString method that gathers all of the information from the ship and
     * turns it into a string.
     *
     * @return infoOnShip The String made with the hip information using the
     * toString method.
     */
    @Override
    public String toString() {
        String infoOnShip = "The " + name + " with " + engine
                + " and has  " + weapon;
        return infoOnShip;

    }

}
