package br.com.baliberdin.ai.sensor;

import br.com.baliberdin.ai.sensor.position.PositionXY;

public class MatrixPositionSensor extends Sensor {
	
	protected PositionXY position;
	
	public MatrixPositionSensor() {
		position = new PositionXY(0, 0);
	}
	
	public MatrixPositionSensor(PositionXY position) {
		this.position = position;
	}

	@Override
	public Object getValue() {
		return position;
	}

	@Override
	public void acquireValue() {
		// TODO Auto-generated method stub
		
	}

}
