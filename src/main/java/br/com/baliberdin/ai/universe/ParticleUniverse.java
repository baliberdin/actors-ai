package br.com.baliberdin.ai.universe;

import br.com.baliberdin.ai.actor.TimeLapseActor;

public class ParticleUniverse extends TimeLapseUniverse {

	public static final String NAME = "Particles Universe";
	
	public ParticleUniverse() {
		super(NAME);
	}
	
	public ParticleUniverse(Integer times) {
		super(NAME, times);
	}

	@Override
	public void thinkAbout(TimeLapseActor a) {
		
	}

	
}
