package br.com.baliberdin.ai;

import br.com.baliberdin.ai.actor.Actor;
import br.com.baliberdin.ai.actor.ParticleActor;
import br.com.baliberdin.ai.sensor.EnergyLevelSensor;
import br.com.baliberdin.ai.sensor.PainSensor;
import br.com.baliberdin.ai.universe.GravityUniverse;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) {
		System.out.println("\nExemplo de um universo de inteligência artificial.");
		
		GravityUniverse universe = new GravityUniverse(5);
		System.out.println("Universe: "+universe.getName()+"\n");
		
		System.gc();
		
		for(long i = 0; i< 15; i++) {
			ParticleActor particle = new ParticleActor(i);
			EnergyLevelSensor energy = new EnergyLevelSensor();
			particle.addSensor(energy);
			
			//PainSensor pain = new PainSensor();
			//particle.addSensor(pain);
			
			universe.addActor(particle);
		}
		
		universe.start();
		
		System.out.println("\nResults\n");
		for(Actor actor: universe.getActors()) {
			ParticleActor a = (ParticleActor) actor;
			System.out.println(actor.getName()+" - "+ a.getFeelings().firstElement() + " - "+a.getIterations());
		}
	}
}
