package br.com.baliberdin.ai;

import br.com.baliberdin.ai.actor.Actor;
import br.com.baliberdin.ai.actor.AliveActor;
import br.com.baliberdin.ai.actor.ParticleActor;
import br.com.baliberdin.ai.actor.TimeLapseActor;
import br.com.baliberdin.ai.sensor.EnergyLevelSensor;
import br.com.baliberdin.ai.sensor.PainSensor;
import br.com.baliberdin.ai.universe.GravityUniverse;


public class App 
{
	public static void main( String[] args ) throws InterruptedException {
		System.out.println("\nExemplo de um universo de inteligência artificial.");
		
		GravityUniverse universe = new GravityUniverse(6);
		System.out.println("Universe: "+universe.getName()+"\n");
		
		for(long i = 0; i< 15; i++) {
			ParticleActor particle = new ParticleActor(i);
			AliveActor alive = new AliveActor(i);
			alive.addSensor(new EnergyLevelSensor());
			particle.addSensor(new EnergyLevelSensor());
			universe.addActor(particle);
			universe.addActor(alive);
		}
		
		universe.start();
		
		System.out.println("\nResults\n");
		for(Actor actor: universe.getActors()) {
			TimeLapseActor a = (TimeLapseActor) actor;
			actor.getLock().acquire();
			System.out.println(actor.getName()+"\t- "+ a.getFeelings().firstElement() + " - "+a.getIterations());
			actor.getLock().release();
		}
	}
}
