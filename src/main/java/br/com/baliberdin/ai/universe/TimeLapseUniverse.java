package br.com.baliberdin.ai.universe;

import br.com.baliberdin.ai.actor.Actor;
import br.com.baliberdin.ai.actor.TimeLapseActor;

public abstract class TimeLapseUniverse extends Universe {
	
	private Integer times;

	public TimeLapseUniverse(String name) {
		super(name);
		times = 10;
	}
	
	public TimeLapseUniverse(String name, Integer times) {
		super(name);
		this.times = times;
	}
	
	@Override
	public void start() {
		super.start();
		
		// Control the time lapse
		System.out.println("TimeLapseUniverse starting...\n");
		while(times > 0) {
			System.out.println("TimeLapseUniverse time: "+times);
			for(Actor actor: actors) {
				//System.out.println("Actor: "+actor);
				if(actor instanceof TimeLapseActor) {
					TimeLapseActor tla = (TimeLapseActor) actor;
					//tla.startNextAction();
					//Universe thinks about each actor 
					thinkAbout(tla);
				}else {
					System.out.println(actor.getName()+" is an Invalid Actor. TimeLapseUniverse require TimeLapseActors.");
				}
			}
			
			System.out.println("Sleeping Threads...");
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			times--;
		}
		
		for(Actor actor: actors) {
			actor.kill();
		}
	}
	
	public abstract void thinkAbout(TimeLapseActor a);
	
	public void addActor(Actor actor) {
		if(actor != null && actor instanceof TimeLapseActor) {
			super.addActor(actor);
		}
	}

}
