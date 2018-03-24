package br.com.baliberdin.ai.sensor;

public abstract class InstinctSensor extends Sensor {

	protected Double sense = 0.5D;
	
	public Double getSense() {
		return sense;
	}

}
