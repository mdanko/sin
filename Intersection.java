// This file was automatically generated. Do not modify.
package crossroads;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import de.renew.engine.simulator.SimulationThreadPool;
import de.renew.net.NetInstance;
public class Intersection
  extends de.renew.net.NetInstanceImpl
{

  private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
                                                        .getLogger(Intersection.class);
  private final NetInstance _instance = this;

  public Intersection()
  {
    super();
    Future<Object> future = SimulationThreadPool.getCurrent()
                                 .submitAndWait(new Callable<Object>() {
      public Object call() throws RuntimeException {
        try {
          de.renew.net.Net net = de.renew.net.Net.forName("intersection");
          net.setEarlyTokens(true);
          initNet(net, true);
          System.out.print(net.places());
          createConfirmation(de.renew.application.SimulatorPlugin.getCurrent().getCurrentEnvironment().getSimulator().currentStepIdentifier());
        } catch (de.renew.net.NetNotFoundException e) {
          throw new RuntimeException(e.toString(), e);
        } catch (de.renew.unify.Impossible e) {
          throw new RuntimeException(e.toString(), e);
        }
        return null;
      }
    });
    try {
        future.get();
    } catch (InterruptedException e) {
        logger.error("Timeout while waiting for simulation thread to finish", e);
    } catch (ExecutionException e) {
        logger.error("Simulation thread threw an exception", e);
    }
  }
}
