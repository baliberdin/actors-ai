package br.com.baliberdin.ai.memory;

import java.util.List;

public abstract class Memory {

	public abstract void addItem(Object obj);
	public abstract List<Object> getItens();
	
}
