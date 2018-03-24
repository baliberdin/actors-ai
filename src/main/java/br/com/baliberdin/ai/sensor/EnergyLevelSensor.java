package br.com.baliberdin.ai.sensor;

public class EnergyLevelSensor extends InstinctSensor {

	private Double energy;
	
	public EnergyLevelSensor() {
		energy = 10000.0D;
	}
	
	@Override
	public Double getValue() {
		return energy;
	}

	@Override
	public void acquireValue() {
		// A fake energy lost
		energy = energy - 0.001D;
		if(energy < 0D)energy = 0D;
		
		//TODO acquire real energy;
	}

}
