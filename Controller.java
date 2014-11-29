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
    public Controller(Senzor s){
        System.out.print("======> New controller \n");
        this.s = s;
        try {
            fileName = new java.io.File( "." ).getCanonicalPath() + "/crossroads/fuzzy.fcl";
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public double getTime() {
        // Load from 'FCL' file


        // Error while loading?
        if( this.fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0.0;
        }

        // Set inputs
        this.fis.setVariable("AG", s.getAG());     // red queue list
        this.fis.setVariable("RGT", s.getRGT());	// remaining green time
        this.fis.setVariable("RQL", s.getRQL());	// arrival during green

        // Evaluate
        this.fis.evaluate();



        // Return
        return fis.getVariable("ST").getValue();
    }

    public void newPhase(){
        s.newPhase();
    }
}
