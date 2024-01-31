/**
 * File name: CFconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
*/
package pkgUnitConverter;
/**
 * class to convert Celsius to Fahrenheit
 * @author kriger, adapted by Ollie Savill
 */
public class CFconverter implements UnitConverter{
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
	/**
         * Overrides using the UnitConverter interface class
	 * @param celsius value in Celsius to be converted
	 * @return equivalent in Fahrenheit
	 */
        @Override
	public String convert(double celsius) {
            double fahrenheit = (celsius*convFactor) + convOrigin;
            String answer = String.format("%5.2f in celsius is %5.2f in fahrenheit.", celsius, fahrenheit);
		return answer;
	}
}
