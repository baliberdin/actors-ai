package br.com.baliberdin.ai.actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.com.baliberdin.ai.sensor.Sensor;

public abstract class Actor extends Thread {

	private Long id;
	protected List<Sensor> sensors = new ArrayList<Sensor>();
	protected List<Action> actions = new ArrayList<Action>();

	// Intelligence
	private boolean live;

	// It is no able to register memories, then we have only one register of actual feeling
	protected Vector<Object> feelings = new Vector<Object>();

	public Actor(Long id) {
		this.id = id;
		live = true;
	}

	public long getId() {
		return id;
	}

	public void kill() {
		live = false;
	}

	public List<Action> getActions(){
		return actions;
	}

	public List<Sensor> getSensors(){
		return sensors;
	}

	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

	public  void run() {
		//StringBuffer str = new StringBuffer();
		//str.append(this.getName()+" - Sensors:"+getSensors().size()+" - Actions:"+getActions().size()+"\n");
		//System.out.println(str.toString());

		while(live) {
			feelings.clear();
			for(Sensor sensor: sensors) {
				sensor.acquireValue();
				feelings.add(sensor.getValue());
			}

			thinkAbout();
		};
	}

	public boolean isLive() {
		return live;
	}

	public Vector<Object> getFeelings() {
		return feelings;
	}

	public abstract void thinkAbout();

}
