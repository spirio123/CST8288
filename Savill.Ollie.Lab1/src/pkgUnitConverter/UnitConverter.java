/**
 * File name: UnitConverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * This is the interface for the unit conversion program. The interface is used
 * for getting the double value and the string from the class selected by using
 * the strategy pattern.
 *
 * @author savil
 */
public interface UnitConverter {

    /**
     *
     * @param convert used in the other classes easy conversion
     * @return String
     */
    public String convert(double convert);
}
