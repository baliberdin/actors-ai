package br.com.baliberdin.ai.sensor.position;

public class PositionXY {

	private long x;
	private long y;
	
	public PositionXY(long x, long y) {
		this.x = x;
		this.y = y;
	}
	
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
}
