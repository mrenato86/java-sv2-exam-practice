package potpotvizsga.bistros;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class City {

    private final Set<Bistro> bistros = new LinkedHashSet<>();

    public void addBistro(Bistro bistro) {
        if (bistro != null) {
            bistros.add(bistro);
        }
    }

    public Set<Bistro> getBistros() {
        return new LinkedHashSet<>(bistros);
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
                .filter(b -> b.getAddress().equals(address))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No bistro with this address!"));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
                .max(Comparator.comparingInt(b -> b.getMenu().size()))
                .orElseThrow(() -> new IllegalArgumentException("No bistro in list!"));
    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        return bistros.stream()
                .filter(b -> b.getMenu().stream()
                        .anyMatch(item -> item.getName().equalsIgnoreCase(menuItemName)))
                .collect(Collectors.toList());
    }
}
