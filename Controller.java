package crossroads;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.io.IOException;

/**
 * Created by Matej on 25. 11. 2014.
 */
public class Controller {
    private String fileName;
    public Senzor s;
    private FIS fis;
    private double time[];

    public Controller(Senzor s){
        System.out.print("======> New controller \n");
        this.s = s;
        try {
            fileName = new java.io.File( "." ).getCanonicalPath() + "/crossroads/fuzzy.fcl";
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fis = FIS.load(fileName,true);

        time = new double[4];
        time[0] = 20;
        time[1] = 20;
        time[2] = 20;
        time[3] = 20;

    }
    public double getTime() {
        // Load from 'FCL' file


        // Error while loading?
        if( this.fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0.0;
        }

        // Set inputs
        this.fis.setVariable("green", s.getAG());     // presli na zelenu
//        this.fis.setVariable("RGT", s.getRGT());	// remaining green time
        this.fis.setVariable("red", s.getRQL());	// pocet cakajucich

        // Evaluate
        this.fis.evaluate();



        // Return
//        time[s.getPhase()] = time[s.getPhase()] + fis.getVariable("ST").getValue();
        System.err.println("Cas pre fazu: " + s.getPhase() + " je " + time[s.getPhase()]);
        s.clear();

        return time[s.getPhase()];
//        return fis.getVariable("ST").getValue();
    }

    public void newPhase(){
        s.newPhase();
    }
}
