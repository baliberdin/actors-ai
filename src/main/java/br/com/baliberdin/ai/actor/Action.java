package br.com.baliberdin.ai.actor;

import br.com.baliberdin.ai.universe.Universe;

public interface Action {

	String getName();
	boolean canRun(Universe universe);
}
