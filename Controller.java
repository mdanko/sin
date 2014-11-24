// This file was automatically generated. Do not modify.
package crossroads;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import de.renew.engine.simulator.SimulationThreadPool;
import de.renew.net.NetInstance;
public class Controller {

  public Controller(){
      try {
        de.renew.net.Net net = de.renew.net.Net.forName("intersection");
        System.out.print(net.places());
      } catch (de.renew.net.NetNotFoundException e) {
        throw new RuntimeException(e.toString(), e);
      }
  }
  public boolean newCar(int x, String from){
    System.out.println("------------------ NEW CAR IN--------------------x = " + x + " from: " + from);
    return false;
  }

  public int getTime(){
    return 100;
  }
}

