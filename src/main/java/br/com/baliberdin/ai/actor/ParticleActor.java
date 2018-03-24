package br.com.baliberdin.ai.actor;

public class ParticleActor extends TimeLapseActor {
	
	private Long i = 0L;

	public ParticleActor(Long id) {
		super(id);
		setName("Particle-"+id);
	}

	@Override
	public void thinkAbout() {
		i++;
		//System.out.println(this.getName()+" is thinking..."+feelings.toString()+" | "+i);
	}
	
	public Long getIterations() {
		return i;
	}

}