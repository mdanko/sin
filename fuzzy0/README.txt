MANUAL

*Druha verzia fuzzy java classy (CrossroadsFuzzyClass.java), ktora manipuluje s fuzzy kontrolerom (fuzzy.fcl).
*Metoda getOutput prijima vstupne argumenty double AG, RGT a RQL a vracia double ST.

Pracuje s hodnotami : 
	-> RQL - pocet aut vo fronte na cervenu,
	-> RGT - podiel casu, ktory zostava zelenej,
	-> AG - pocet aut, ktore prebehli cez zelenu
	<- ST - pripadna zmena intervalu trvania zelenej
	
Pouzitie :
1)Zobrazenie grafov fuzzy mnozin pre dane vstupy:
	$cd fuzz0
	$java -jar lib/jFuzzyLogic.jar -e fuzzy.fcl [RQL] [RGT] [AG]
	($java -jar lib/jFuzzyLogic.jar -e fuzzy.fcl 1 0.6 8)

2)Vypis hodnoty ST:
	v Eclipse

	oder

	$cd fuzz0
	$javac -cp lib/jFuzzyLogic.jar src/com/crossroadsFuzzy/CrossroadsFuzzyClass.java
	$java -cp lib/jFuzzyLogic.jar com.crossroadsFuzzy.CrossroadsFuzzyClass