package fr.unilim.iut.tirepressuremonitorsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class AlarmTest {

	@Test
	public void test_pressionBasse() {
		
		Sensor sensor = mock(Sensor.class);
		Alarm alarme = new Alarm(sensor,17,21);
		when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
		
		alarme.check();
	
		assertEquals(true, alarme.isAlarmOn());
	}
	
	@Test
	public void test_pressionHaute() {
	
		Sensor sensor = mock(Sensor.class);
		Alarm alarme = new Alarm(sensor,17,21);
		when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
		
		alarme.check();
	
		assertEquals(true, alarme.isAlarmOn());
	}
	
	@Test
	public void test_pressionDansLeSeuil() {
	
		Sensor sensor = mock(Sensor.class);
		Alarm alarme = new Alarm(sensor,17,21);
		when(sensor.popNextPressurePsiValue()).thenReturn(17.0);
		
		alarme.check();
	
		assertEquals(false, alarme.isAlarmOn());
	}
	
	@Test
	public void test_alarmeResteDeclenchee() {
	
		Sensor sensor = mock(Sensor.class);
		Alarm alarme = new Alarm(sensor,17,21);
		when(sensor.popNextPressurePsiValue()).thenReturn(15.0).thenReturn(18.0);
		
		alarme.check();
	
		assertEquals(true, alarme.isAlarmOn());
	}
	
	
}
