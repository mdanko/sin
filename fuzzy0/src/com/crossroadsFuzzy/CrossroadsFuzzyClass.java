package com.crossroadsFuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class CrossroadsFuzzyClass {

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
        fis.setVariable("RQL", 8);
        fis.setVariable("RGT", 0.7);
        fis.setVariable("AG", 2);
        
        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        //Variable tip = functionBlock.getVariable("ST");
        //JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println("Result ="+fis.getVariable("ST").getValue());
    }
}
