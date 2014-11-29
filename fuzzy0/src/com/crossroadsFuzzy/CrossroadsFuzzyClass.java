package com.crossroadsFuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class CrossroadsFuzzyClass {

	// main function for independent usage
	public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "fuzzy.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show 
        //JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("AG", Double.parseDouble(args[0]));     // red queue list   
        fis.setVariable("RGT", Double.parseDouble(args[1]));	// remaining green time
        fis.setVariable("RQL", Double.parseDouble(args[2]));	// arrival during green
        
        // Evaluate
        fis.evaluate();        
      
        // Show output variable's chart
        //Variable tip = functionBlock.getVariable("ST");
        //JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println("Result ="+fis.getVariable("ST").getValue());
    }
	
	// method for another classes
	public static double getOutput(double AG, double RGT, double RQL) throws Exception {
        // Load from 'FCL' file
        String fileName = "fuzzy.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return -100.0;
        }

        // Set inputs
        fis.setVariable("AG", AG);     // red queue list   
        fis.setVariable("RGT", RGT);	// remaining green time
        fis.setVariable("RQL", RQL);	// arrival during green
        
        // Evaluate
        fis.evaluate();
        
        // Return
        return fis.getVariable("ST").getValue();   
    }
}
