package br.com.baliberdin.ai.actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

import br.com.baliberdin.ai.sensor.Sensor;

public abstract class Actor extends Thread {

	private Long id;
	protected List<Sensor> sensors = new ArrayList<Sensor>();
	protected List<Action> actions = new ArrayList<Action>();
	protected Semaphore lock;

	// Intelligence
	protected boolean live;

	// It is no able to register memories, then we have only one register of actual feeling
	protected Vector<Object> feelings = new Vector<Object>();

	public Actor(Long id) {
		this.id = id;
		live = true;
		this.lock = new Semaphore(1);
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

		while(live) {
			try {
				lock.acquire();

				feelings.clear();
				for(Sensor sensor: sensors) {
					sensor.acquireValue();
					feelings.add(sensor.getValue());
				}

				thinkAbout();

				lock.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isLive() {
		return live;
	}

	public Vector<Object> getFeelings() {
		return feelings;
	}

	public abstract void thinkAbout();

	public Semaphore getLock(){
		return lock;
	}

}
