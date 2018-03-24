package br.com.baliberdin.ai.universe;

import br.com.baliberdin.ai.actor.TimeLapseActor;

public class GravityUniverse extends TimeLapseUniverse {
	
	public static final String NAME = "Gravitational Universe";

	public GravityUniverse(String name) {
		super(name);
	}
	
	public GravityUniverse(Integer times) {
		super(NAME,times);
	}

	@Override
	public void thinkAbout(TimeLapseActor a) {
		
		if(a.getFeelings().size() > 0) {
			System.out.println("Thinking...");
			
			if(a.getFeelings().size() > 0) {
				Object obj = a.getFeelings().firstElement();
				Number n = (Number) obj;
				Double f = n.doubleValue();
				f = (f*100)/1;
				
//				try {
//					a.sleep(f.longValue());
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}

}
