package army;

public class Swordsman extends MilitaryUnit {

    private boolean isShieldIntact = true;

    public Swordsman(boolean hasArmor) {
        super(100, 10, hasArmor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isShieldIntact) {
            isShieldIntact = false;
            return;
        }
        super.sufferDamage(damage);
    }
}
