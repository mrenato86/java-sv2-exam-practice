package potpotvizsga.bistros;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bistro {

    private final String name;
    private final Address address;
    private final List<MenuItem> menu = new ArrayList<>();

    public Bistro(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem != null) {
            menu.add(menuItem);
        }
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<MenuItem> getMenu() {
        return List.copyOf(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bistro bistro = (Bistro) o;
        return Objects.equals(name, bistro.name) && Objects.equals(address, bistro.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
