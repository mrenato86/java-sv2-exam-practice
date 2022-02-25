package army;

public abstract class MilitaryUnit {

    private int hitPoints;
    private final int damage;
    private final boolean hasArmor;

    public MilitaryUnit(int hitPoints, int damage, boolean hasArmor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.hasArmor = hasArmor;
    }

    public int doDamage() {
        return damage;
    }

    public void sufferDamage(int damage) {
        hitPoints -= hasArmor ? damage / 2 : damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }
}
