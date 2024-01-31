/**
 * File name: FCconverter.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
*/
package pkgUnitConverter;
/**
 * class to convert Fahrenheit to Celsius
 * @author kriger adapted by Ollie Savill
 */
public class FCconverter implements UnitConverter {
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
	
	/**
         * Overrides using the UnitConverter interface class.
	 * @param fahrenheit value in Fahrenheit to be converted
	 * @return equivalent in Celsius
	 */
        @Override
	public String convert(double fahrenheit) {
            double celsius = (fahrenheit - convOrigin)/convFactor;
            String answer = String.format("%5.2f in fahrenheit is %5.2f in celsius.", fahrenheit, celsius);
		return answer;
	}
        
	
}