/**
 * File name: UnitConverterTest.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverterTest;

import pkgUnitConverter.*;

/**
 * This class is the main method to run the UnitConverter program. It uses the
 * strategy pattern to select its path at run time. This classes also uses an
 * interface to help with the code reusability and extendability.
 *
 * @author savil
 */
public class UnitConverterTest {

    /**
     * This is what runs the main program, practices switching between each
     * method with hard-coded values.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();

        context.changeconverter(new CFconverter());
        System.out.println(context.answer(20.0));

        context.changeconverter(new FCconverter());
        System.out.println(context.answer(70.0));

        context.changeconverter(new FMconverter());
        System.out.println(context.answer(6.5));

        context.changeconverter(new MFconverter());
        System.out.println(context.answer(3.0));

        context.changeconverter(new KPconverter());
        System.out.println(context.answer(8.79));

        context.changeconverter(new PKconverter());
        System.out.println(context.answer(3.49));
    }

}
