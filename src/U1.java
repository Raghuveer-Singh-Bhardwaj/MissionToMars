public class U1 extends Rocket {

    int launchExplosion;
    int landExplosion;
    int cargoLimit;
    int cargoCarried;

    public U1() {
        super(18,100,10);
    }

    @Override
    public boolean launch(){
        cargoLimit = MaxWeight - Weight;
        cargoCarried = Weight - RocketWeight;
        launchExplosion = (int) 0.04 * (cargoCarried/cargoLimit);

        return launchExplosion < 100;
    }

    @Override
    public boolean land(){
        cargoLimit = MaxWeight - Weight;
        cargoCarried = Weight - RocketWeight;
        landExplosion = (int) 0.08 * (cargoCarried/cargoLimit);

        return landExplosion < 100;
    }
}
