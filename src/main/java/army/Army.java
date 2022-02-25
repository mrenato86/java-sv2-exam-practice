package army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {

    private static final int MIN_HP = 25;

    private final List<MilitaryUnit> militaryUnits = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        if (militaryUnit != null) {
            militaryUnits.add(militaryUnit);
        }
    }

    public void damageAll(int damage) {
//        militaryUnits.forEach(mu -> mu.sufferDamage(damage));
//        militaryUnits.removeIf(mu -> mu.getHitPoints() < MIN_HP);
        for (Iterator<MilitaryUnit> iterator = militaryUnits.iterator(); iterator.hasNext(); ) {
            MilitaryUnit actual = iterator.next();
            actual.sufferDamage(damage);
            if (actual.getHitPoints() < MIN_HP) {
                iterator.remove();
            }
        }
    }

    public int getArmyDamage() {
        return militaryUnits.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public int getArmySize() {
        return militaryUnits.size();
    }

    public List<MilitaryUnit> getMilitaryUnits() {
        return List.copyOf(militaryUnits);
    }
}
