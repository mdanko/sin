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
        if(phase == 0) return Wgo;	// auta, ktore presli cez zelenu na West
        if(phase == 1) return Sgo;	// auta, ktore presli cez zelenu na South
        if(phase == 2) return Ego;	// auta, ktore presli cez zelenu na East
        return Ngo;					// auta, ktore presli cez zelenu na North
    }

    public double getRQL() {
        //if(phase == 0) return W;        
    	//if(phase == 1) return S;
        //if(phase == 2) return E;
        //return N;
        if(phase == 0) return S+E+N; // auta, ktore cakali, ked bola zelena na West    
    	if(phase == 1) return W+E+N; // auta, ktore cakali, ked bola zelena na South 
        if(phase == 2) return W+S+N; // auta, ktore cakali, ked bola zelena na East 
        return W+S+E;				 // auta, ktore cakali, ked bola zelena na North 
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
        if(phase == 0) { System.err.println("W preslo  " + Wgo); System.err.println("a stalo  " + (W+S+E+N)); Wgo = 0; }
        if(phase == 1) { System.err.println("S preslo  " + Sgo); System.err.println("a stalo  " + (W+S+E+N)); Sgo = 0; }
        if(phase == 2) { System.err.println("E preslo  " + Ego); System.err.println("a stalo  " + (W+S+E+N)); Ego = 0; }
        if(phase == 3) { System.err.println("N preslo  " + Ngo); System.err.println("a stalo  " + (W+S+E+N)); Ngo = 0; }
    }

    public int getPhase() {
        return phase;
    }
}

