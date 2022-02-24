package kennel;

public abstract class Dog {

    private final String name;
    private int happiness;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    protected void increaseHappiness(int diff) {
        happiness += diff;
    }

    public abstract void feed();

    public abstract void play(int hours);
}
