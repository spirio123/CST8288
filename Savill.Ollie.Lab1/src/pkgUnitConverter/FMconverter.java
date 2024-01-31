/**
 * File name: FMconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * This is a class to convert feet to metres using an interface and a strategy
 * pattern for extendability. It uses convFactor as the conversion factor that
 * is used to transition from one unit of measurement to the other and
 * convOrigin as the conversion origin which is the base for the conversion.
 *
 * @author savil
 */
public class FMconverter implements UnitConverter {

    private final double convFactor = 3.2808;
    private final double convOrigin = 1.0;

    /**
     * Overrides using the UnitConverter interface class
     *
     * @param feet value in feet to be converted
     * @return equivalent in metres
     */
    @Override
    public String convert(double feet) {
        double metres = feet * (convOrigin / convFactor);
        String answer = String.format("%.2f in feet is %.2f in metres.", feet, metres);
        return answer;
    }
}
