package army;

public class HeavyCavalry extends MilitaryUnit {

    private int numberOfAttacks;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        return (numberOfAttacks++ < 1) ? 3 * getDamage() : getDamage();
    }
}
