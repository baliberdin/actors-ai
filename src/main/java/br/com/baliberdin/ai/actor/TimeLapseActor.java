package br.com.baliberdin.ai.actor;

public abstract class TimeLapseActor extends Actor {

	private Long i = 0L;
	protected boolean nextAction = false;
	
	public TimeLapseActor(Long id) {
		super(id);
	}
	
	public void startNextAction() {
		nextAction = true;
	}

	public Long getIterations() {
		return i;
	}

	public void thinkAbout(){
		i++;
	}

}
