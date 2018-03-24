package br.com.baliberdin.ai.actor;

public abstract class TimeLapseActor extends Actor {

	protected boolean nextAction = false;
	
	public TimeLapseActor(Long id) {
		super(id);
	}
	
	public void startNextAction() {
		nextAction = true;
	}

}
