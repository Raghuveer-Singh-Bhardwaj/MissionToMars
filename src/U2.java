public class U2 extends Rocket{
    int launchExplosion;
    int landExplosion;
    int cargoLimit;
    int cargoCarried;

    public U2() {
        super(29,120,18);
    }

    @Override
    public boolean launch(){
        cargoLimit = MaxWeight - Weight;
        cargoCarried = Weight - RocketWeight;
        launchExplosion = (int) 0.05 * (cargoCarried/cargoLimit);

        return launchExplosion < 100;
    }

    @Override
    public boolean land(){
        cargoLimit = MaxWeight - Weight;
        cargoCarried = Weight - RocketWeight;
        landExplosion = (int) 0.01 * (cargoCarried/cargoLimit);

        return landExplosion < 100;
    }
}
