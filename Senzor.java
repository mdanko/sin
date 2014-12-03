// This file was automatically generated. Do not modify.
package crossroads;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import de.renew.engine.simulator.SimulationThreadPool;
import de.renew.net.NetElementID;
import de.renew.net.NetInstance;
import de.renew.net.Place;

public class Senzor {


    private double AG;
    private double RGT;
    private double RQL;

    private int W;
    private int E;
    private int N;
    private int S;

    private int phase;
    private int Wgo;
    private int Ego;
    private int Sgo;
    private int Ngo;

    public Senzor(){
//      try {
//        net = de.renew.net.Net.forName("intersection");
//      } catch (de.renew.net.NetNotFoundException e) {
//        throw new RuntimeException(e.toString(), e);
//      }
//        places = net.places();
//        Place fromWest;
//        for (Iterator<Place> iter = places.iterator(); iter.hasNext(); ) {
//            Place p = iter.next();
//            if(p.toString().equals("waitingFromWest")){
//                fromWest = p;
//            }
//        }
//        p.

        W = E = S = N = 0;


        this.AG = 3;
        this.RGT = 0.6;
        this.RQL = 12;

        phase = 0;
    }

    public double getAG() {
        if(phase == 0) return Wgo;
        if(phase == 1) return Sgo;
        if(phase == 2) return Ego;
        return Ngo;
    }

    public double getRQL() {
        if(phase == 0) return W;
        if(phase == 1) return S;
        if(phase == 2) return E;
        return N;
    }

    public void newPhase() {
        phase = (phase + 1) % 4;
        System.err.println("Nova faza! " + phase);
    }

    public void addCar(char from){
        switch (from){
            case 'W': W++; break;
            case 'E': E++; break;
            case 'S': S++; break;
            case 'N': N++; break;
        }
    }
    public void removeCar(char from){
        switch (from){
            case 'W': W--; Wgo++; break;
            case 'E': E--; Ego++; break;
            case 'S': S--; Sgo++; break;
            case 'N': N--; Ngo++; break;
        }
    }

    public void clear() {
        if(phase == 0) Wgo = 0;
        if(phase == 1) Sgo = 0;
        if(phase == 2) Ego = 0;
        if(phase == 3) Ngo = 0;
    }

    public int getPhase() {
        return phase;
    }
}

