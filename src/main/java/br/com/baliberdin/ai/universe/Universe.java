package br.com.baliberdin.ai.universe;

import java.util.ArrayList;
import java.util.List;

import br.com.baliberdin.ai.actor.Actor;

public abstract class Universe {

	private String name;
	protected List<Actor> actors;
	
	public Universe(String name) {
		this.name = name;
		this.actors = new ArrayList<Actor>();
	}
	
	public void start() {
		for(Actor a : actors) {
			a.start();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void addActor(Actor actor) {
		actors.add(actor);
	}
}
