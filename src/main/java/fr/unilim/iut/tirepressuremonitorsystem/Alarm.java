package fr.unilim.iut.tirepressuremonitorsystem;

public class Alarm
{
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;

    public Sensor sensor; 
    boolean alarmOn;;

    public Alarm(Sensor sensor, double LowPressureThreshold, double HighPressureThreshold) {
		this.sensor = sensor;
		this.alarmOn = false;
		this.LowPressureThreshold = LowPressureThreshold;
		this.HighPressureThreshold = HighPressureThreshold;
	}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (isPressureTooLow(psiPressureValue) || isPressureTooHigh(psiPressureValue))
        {
            setAlarmOn();
        }
    }

	public boolean isPressureTooHigh(double psiPressureValue) {
		return getHighPressureThreshold() < psiPressureValue;
	}

	public boolean isPressureTooLow(double psiPressureValue) {
		return psiPressureValue < getLowPressureThreshold();
	}

	public void setAlarmOn() {
		alarmOn = true;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }

	public double getLowPressureThreshold() {
		return LowPressureThreshold;
	}

	public double getHighPressureThreshold() {
		return HighPressureThreshold;
	}
}