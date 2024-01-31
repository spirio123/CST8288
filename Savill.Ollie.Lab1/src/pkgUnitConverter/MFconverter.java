/**
 * File name: MFconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * This is a class to convert metres to feet using an interface and a strategy
 * pattern for extendability. It uses convFactor as the conversion factor that
 * is used to transition from one unit of measurement to the other and
 * convOrigin as the conversion origin which is the base for the conversion.
 *
 * @author savil
 */
public class MFconverter implements UnitConverter {

    private final double convFactor = 3.2808;
    private final double convOrigin = 1.0;

    /**
     * Overrides using the UnitConverter interface class
     *
     * @param metres value in metres to be converted
     * @return equivalent in feet
     */
    @Override
    public String convert(double metres) {
        double feet = metres * (convOrigin * convFactor);
        String answer = String.format("%.2f in metres is %.2f in feet.", metres, feet);
        return answer;
    }
}
