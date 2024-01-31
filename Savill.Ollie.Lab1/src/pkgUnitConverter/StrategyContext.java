/**
 * File name: StrategyContext.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Data: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * The "context" class for implementing the strategy design pattern in the code.
 *
 * @author savil
 */
public class StrategyContext {

    private UnitConverter unit;

    /**
     * Used for selecting which converter to use when called in the main method.
     */
    public StrategyContext() {
    }

    /**
     * To change the converter to whichever is called in the main method.
     *
     * @param unit
     */
    public void changeconverter(UnitConverter unit) {
        this.unit = unit;
    }

    /**
     * For getting a string from each class and the value hard-coded into the
     * main method.
     *
     * @param value the value being converted through the interface
     * @return String
     */
    public String answer(double value) {
        return unit.convert(value);
    }
}
