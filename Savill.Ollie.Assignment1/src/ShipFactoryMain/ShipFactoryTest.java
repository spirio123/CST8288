/**
 * File name: ShipFactoryTest.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: March, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package ShipFactoryMain;

import ShipPackage.Ship;
import ShipBuildPackage.ShipBuilding;
import ShipBuildPackage.SurfaceShipBuilding;

/**
 * The main method class that uses hard coded ship choices to demonstrate the
 * factory building pattern of the CSCShip and the HCShip. It calls the ship
 * type along which the required engine and weapon for each and prints out the
 * information.
 *
 * @author Rama, commented by Ollie
 */
public class ShipFactoryTest {

    /**
     * The main method that creates both types of ships along with their
     * required equipment and prints out the information.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ShipBuilding MakeHCs = new SurfaceShipBuilding();
        Ship theHC = MakeHCs.orderTheShip("HC");
        theHC.displayShipSpeed();
        theHC.shipGunDesc();
        System.out.println(theHC + "\n");
        Ship theCSC = MakeHCs.orderTheShip("CSC");
        theCSC.displayShipSpeed();
        theCSC.shipGunDesc();
        System.out.println(theCSC + "\n");

    }

}
