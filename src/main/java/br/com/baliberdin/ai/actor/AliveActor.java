package br.com.baliberdin.ai.actor;

import br.com.baliberdin.ai.sensor.Sensor;

/***
 * Alive Actors should do things that we consider essential to deserve that name
 * These things in Biology are:
 * Metabolism,
 * Nutrition,
 * Reproduction,
 * Irritability,
 * Evolution
 *
 * And needs a...
 * Chemical composition,
 * Cells,
 * Genetic Material.
 *
 */
public class AliveActor extends TimeLapseActor {

    // Genetic material
    protected DNA dna;

    public AliveActor(Long id) {
        super(id);
        setName("Alive -"+id);
    }

    public  void run() {

        while(live) {
            try {
                lock.acquire();

                feelings.clear();
                for(Sensor sensor: sensors) {
                    sensor.acquireValue();
                    feelings.add(sensor.getValue());
                }

                lock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            thinkAbout();
        };
    }

    @Override
    public void thinkAbout() {
        super.thinkAbout();
    }

    protected void doMetabolism(){

    }

    protected void doReproduction(){

    }

    protected void doIrritability(){

    }

    protected void doEvolution(){

    }
}
