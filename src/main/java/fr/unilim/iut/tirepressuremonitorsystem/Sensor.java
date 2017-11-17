package fr.unilim.iut.tirepressuremonitorsystem;

import java.util.Random;

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

public class Sensor {
    public static final double OFFSET = 16;

    public Sensor(){
    	
    }
    
    public double popNextPressurePsiValue() {
        return OFFSET + samplePressure();
    }

    private static double samplePressure() {
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}