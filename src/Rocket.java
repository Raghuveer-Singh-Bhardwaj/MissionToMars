import java.util.ArrayList;

public class Rocket implements SpaceShip{

    public ArrayList<Item> mListOfItems = new ArrayList<>();
    public int RocketWeight;
    public int Weight;//Tonnes
    public int MaxWeight;
    public int Cost;//Dollars Millions

    public Rocket(int MaxWeight,int Cost,int RocketWeight){
        this.MaxWeight = MaxWeight;
        this.Cost = Cost;
        this.RocketWeight = RocketWeight;
        this.Weight = RocketWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry() {
        int weight = 0;
        for(Item item : mListOfItems){
            weight = weight + item.getWeight();
        }
        return (weight+RocketWeight) < (this.MaxWeight * 1000);
    }

    @Override
    public void carry(Item item) {
        mListOfItems.add(item);
        this.Weight = this.Weight + item.getWeight();
    }
}
