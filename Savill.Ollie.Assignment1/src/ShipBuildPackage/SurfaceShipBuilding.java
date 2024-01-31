/**
 * File name: SurfaceShipBuilding.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipBuildPackage;

import ShipFactoryPackage.CSCShipFactory;
import ShipFactoryPackage.HCShipFactory;
import ShipPackage.Ship;
import ShipPackage.HCShip;
import ShipPackage.CSCShip;
import ShipFactoryPackage.ShipFactory;

/**
 * This class is used to decide which type of ship is created. It uses the
 * ShipBuilding interface. It helps with connecting the Ship factory with the
 * Ship class.
 *
 * @author Rama, commented by Ollie
 */
public class SurfaceShipBuilding extends ShipBuilding {

    @Override
    protected Ship makeCanadianShip(String typeOfShip) {
        Ship theCanadianShip = null;
        if (typeOfShip.equals("HC")) {
            ShipFactory shipPartsFactory = new HCShipFactory();
            theCanadianShip = new HCShip(shipPartsFactory);
            theCanadianShip.setName("HMCS Ottawa");
            System.out.println("Created Halifax Class ship " + theCanadianShip.getName());
        } else if (typeOfShip.equals("CSC")) {
            ShipFactory shipPartsFactory = new CSCShipFactory();
            theCanadianShip = new CSCShip(shipPartsFactory);
            theCanadianShip.setName("HMCS CSC001");
            System.out.println("Created Canadian Surface Combatant ship " + theCanadianShip.getName());

        }
        return theCanadianShip;
    }
}
