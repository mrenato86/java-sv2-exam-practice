package kennel;

public class Beagle extends Dog {

    private static final int HAPPINESS_INCREASE = 2;

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHappiness(HAPPINESS_INCREASE);
    }

    @Override
    public void play(int hours) {
        increaseHappiness(HAPPINESS_INCREASE * hours);
    }


}
