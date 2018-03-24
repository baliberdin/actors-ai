package br.com.baliberdin.ai.sensor;

public abstract class Sensor {


	public Sensor() {
		
	}
	
	public abstract void acquireValue();
	public abstract Object getValue();
	
}
