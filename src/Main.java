import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<Item> itemsforPhase1 = Simulation.loadItems("Phase1.txt");
        ArrayList<Item> itemsforPhase2 = Simulation.loadItems("Phase2.txt");

        ArrayList<U1> mListOfU1RocketsforPhase1 = Simulation.loadU1(itemsforPhase1);
        ArrayList<U1> mListOfU1RocketsforPhase2 = Simulation.loadU1(itemsforPhase2);

        ArrayList<U2> mListOfU2RocketsforPhase1 = Simulation.loadU2(itemsforPhase1);
        ArrayList<U2> mListOfU2RocketsforPhase2 = Simulation.loadU2(itemsforPhase2);

       int budgetForU1OfPhase1 = Simulation.runSimulation((ArrayList)mListOfU1RocketsforPhase1);
       int budgetForU1OfPhase2 = Simulation.runSimulation((ArrayList)mListOfU1RocketsforPhase2);

       System.out.println("Toatal budget for U1 Rocket is "+(budgetForU1OfPhase1+budgetForU1OfPhase2)+" million dollars");

        int budgetForU2OfPhase1 = Simulation.runSimulation((ArrayList)mListOfU2RocketsforPhase1);
        int budgetForU2OfPhase2 = Simulation.runSimulation((ArrayList)mListOfU2RocketsforPhase2);

        System.out.println("Toatal budget for U2 Rocket is "+(budgetForU2OfPhase1+budgetForU2OfPhase2)+" million dollars");
    }
}
