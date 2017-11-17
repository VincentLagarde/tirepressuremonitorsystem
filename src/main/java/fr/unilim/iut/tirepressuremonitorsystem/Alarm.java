package fr.unilim.iut.tirepressuremonitorsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    public Sensor sensor; 

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < getLowPressureThreshold() || getHighPressureThreshold() < psiPressureValue)
        {
            alarmOn = true;
        }
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