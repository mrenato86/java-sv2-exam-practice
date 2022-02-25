package cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private final List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        if (cleanable != null) {
            cleanables.add(cleanable);
        }
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext(); ) {
            Cleanable actual = iterator.next();
            if (actual instanceof Office office) {
                sum += office.clean();
                iterator.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(c->c.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }

    public List<Cleanable> getCleanables() {
        return List.copyOf(cleanables);
    }
}
