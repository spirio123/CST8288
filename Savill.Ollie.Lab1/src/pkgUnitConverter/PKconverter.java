/**
 * File name: PKconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * This is a class to convert pounds to kilograms using an interface and a
 * strategy pattern for extendability. It uses convFactor as the conversion
 * factor that is used to transition from one unit of measurement to the other
 * and convOrigin as the conversion origin which is the base for the conversion.
 *
 * @author savil
 */
public class PKconverter implements UnitConverter {

    private final double convFactor = 2.204623;
    private final double convOrigin = 1.0;

    /**
     * Overrides using the UnitConverter interface class
     *
     * @param pounds value in pounds to be converted
     * @return equivalent in kilograms
     */
    @Override
    public String convert(double pounds) {
        double kilograms = pounds * (convOrigin * convFactor);
        String answer = String.format("%.2f in pounds is %.2f in kilograms.", pounds, kilograms);
        return answer;
    }
}
