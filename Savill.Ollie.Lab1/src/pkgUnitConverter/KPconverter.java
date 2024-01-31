/**
 * File name: KPconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * This is a class to convert kilograms to pounds using an interface and a
 * strategy pattern for extendability. It uses convFactor as the conversion
 * factor that is used to transition from one unit of measurement to the other
 * and convOrigin as the conversion origin which is the base for the conversion.
 *
 * @author savil
 */
public class KPconverter implements UnitConverter {

    private final double convFactor = 2.204623;
    private final double convOrigin = 1.0;

    /**
     * Overrides using the UnitConverter interface class
     *
     * @param kilograms value in kilograms to be converted
     * @return equivalent in pounds
     */
    @Override
    public String convert(double kilograms) {
        double pounds = kilograms * (convOrigin / convFactor);
        String answer = String.format("%.2f in kilograms is %.2f in pounds.", kilograms, pounds);
        return answer;
    }

}
