import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {

    public static ArrayList<Item> loadItems(String path) throws FileNotFoundException{
        File file = new File(path);
        ArrayList<Item> mItems = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] props = line.split("=");
            Item item = new Item();
            item.setName(props[0]);
            item.setWeight(Integer.parseInt(props[1]));
            mItems.add(item);
        }

        return mItems;
    }

    public static ArrayList<U1> loadU1(ArrayList<Item> mItems){
        ArrayList<U1> mListOfU1Rockets = new ArrayList<>();

        U1 u1 = new U1();

        for(Item item : mItems){
            if(u1.canCarry()){
                u1.carry(item);
            }else{
                mListOfU1Rockets.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
        }

        if(mListOfU1Rockets.isEmpty()){
            mListOfU1Rockets.add(u1);
        }

        return mListOfU1Rockets;
    }

    public static ArrayList<U2> loadU2(ArrayList<Item> mItems){
        ArrayList<U2> mListOfU2Rockets = new ArrayList<>();

        U2 U2 = new U2();

        for(Item item : mItems){
            if(U2.canCarry()){
                U2.carry(item);
            }else{
                mListOfU2Rockets.add(U2);
                U2 = new U2();
                U2.carry(item);
            }
        }

        if(mListOfU2Rockets.isEmpty()){
            mListOfU2Rockets.add(U2);
        }

        return mListOfU2Rockets;
    }

    public static int runSimulation(ArrayList<Rocket> mListOfRocket){
        int budget = 0; // In Million
        for(Rocket rocket : mListOfRocket){
            budget += rocket.Cost;
            while(!(rocket.launch() && rocket.land())){
                budget += rocket.Cost;
            }
        }
        return budget;
    }
}
