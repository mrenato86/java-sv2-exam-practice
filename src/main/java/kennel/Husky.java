package kennel;

public class Husky extends Dog {

    private static final int HAPPINESS_INCREASE = 4;

    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHappiness(HAPPINESS_INCREASE);
    }

    @Override
    public void play(int hours) {
        increaseHappiness((HAPPINESS_INCREASE - 1) * hours);
    }
}
