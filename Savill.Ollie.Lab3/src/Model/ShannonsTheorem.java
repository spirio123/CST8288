/**
 * File name: ShannonsTheorem.java
 * Package: Model
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package Model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class represents the model for a Model-View-Controller (MVC) application
 * that calculates the maximum data rate based on Shannon's Theorem.
 *
 * Shannon's Theorem is used to determine the theoretical maximum data rate (in
 * bits per second) for a communication channel with a given bandwidth and
 * signal-to-noise ratio.
 *
 * @author Ollie Savill
 */
public class ShannonsTheorem {

    //Declarations
    private final StringProperty bandWidth
            = new SimpleStringProperty(this, "bandWidth", null);
    private final StringProperty signalToNoiseRatio
            = new SimpleStringProperty(this, "signalToNoiseRatio", null);
    private final StringProperty maxDataRate
            = new SimpleStringProperty(this, "maxDataRate", null);

    /**
     * Constructs a ShannonsTheorem object with the given bandwidth and
     * signal-to-noise ratio.
     *
     * @param bandWidth the bandwidth in Hertz (Hz)
     * @param signalToNoiseRatio the signal-to-noise ratio in decibels (dB)
     */
    public ShannonsTheorem(String bandWidth, String signalToNoiseRatio) {
        this.bandWidth.set(bandWidth);
        this.signalToNoiseRatio.set(signalToNoiseRatio);
    }

    /**
     * Constructs a ShannonsTheorem object with default values (null) for
     * bandwidth and signal-to-noise ratio.
     */
    public ShannonsTheorem() {
        this(null, null);
    }

    /**
     * Returns the bandwidth.
     *
     * @return bandwidth as a string
     */
    public final String getBandWidth() {
        return bandWidth.get();
    }

    /**
     * Sets the bandwidth.
     *
     * @param bandWidth the bandwidth to set, as a string
     */
    public void setBandWidth(String bandWidth) {
        bandWidthProperty().set(bandWidth);
    }

    /**
     * Returns the bandwidth property.
     *
     * @return bandwidth property
     */
    public final StringProperty bandWidthProperty() {
        return bandWidth;
    }

    /**
     * Returns the signal to noise ratio.
     *
     * @return signalToNoiseRatio as a string
     */
    public String getSignalToNoiseRatio() {
        return signalToNoiseRatio.get();
    }

    /**
     * Sets the signal to noise ratio
     *
     * @param signalToNoiseRatio the signalToNoiseRatio to set, as a string
     */
    public void setSignalToNoiseRatio(String signalToNoiseRatio) {
        signalToNoiseRatioProperty().set(signalToNoiseRatio);
    }

    /**
     * Returns the signal to noise ratio property
     *
     * @return signalToNoiseRatio property
     */
    public final StringProperty signalToNoiseRatioProperty() {
        return signalToNoiseRatio;
    }

    /**
     * Calculates the maximum data rate based on the bandwidth and
     * signal-to-noise ratio.
     *
     * @param BW the bandwidth in Hertz (Hz)
     * @param SNR the signal-to-noise ratio in decibels (dB)
     * @return the maximum data rate in bits per second (bps)
     */
    public double maxDataRate(double BW, double SNR) {
        //print statement
        double SN = Math.pow(10, SNR / 10);
        return BW * log2(1 + SN);
    }

    /**
     * Computes the base-2 logarithm of a number.
     *
     * @param x the input number
     * @return the base-2 logarithm of x
     */
    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /**
     * Calculates and returns the maximum data rate as a string.
     *
     * @return the maximum data rate as a string
     */
    public String maxDataRate() {
        //System.out.println("Output result: " + this.toString());
        double bw = Double.parseDouble(bandWidth.get());
        double snr = Double.parseDouble(signalToNoiseRatio.get());
        double mdr = maxDataRate(bw, snr);
        maxDataRate.set(Double.toString(mdr));
        return maxDataRate.get();
    }

    /**
     * Returns the max data rate property
     *
     * @return maxDataRate property
     */
    public final StringProperty maxDataRateProperty() {
        return maxDataRate;
    }

    /**
     * Returns a string representation of the ShannonsTheorem object, including
     * bandwidth and signal-to-noise ratio.
     *
     * @return a string representation of the ShannonsTheorem object
     */
    @Override
    public String toString() {
        return "ShannonsTheory ["
                + "bandWidth=" + bandWidth.get() + ""
                + ", signalToNoiseRatio=" + signalToNoiseRatio.get() + "]";
    }

}
