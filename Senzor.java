// This file was automatically generated. Do not modify.
package crossroads;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import de.renew.engine.simulator.SimulationThreadPool;
import de.renew.net.NetInstance;
public class Senzor {


    private double AG;
    private double RGT;
    private double RQL;

    public Senzor(){
//      try {
//        de.renew.net.Net net = de.renew.net.Net.forName("intersection");
//        System.out.print(net.places());
//      } catch (de.renew.net.NetNotFoundException e) {
//        throw new RuntimeException(e.toString(), e);
//      }
        this.AG = 10;
        this.RGT = 100;
        this.RQL = 50;
  }
  public boolean newCar(int x, String from){
    System.out.println("------------------ NEW CAR IN--------------------x = " + x + " from: " + from);
    return false;
  }


    public double getAG() {
        return this.AG;
    }

    public double getRGT() {
        return RGT;
    }

    public double getRQL() {
        return RQL;
    }

    public void newPhase() {
        System.out.print("======> New phase \n");
    }
}

