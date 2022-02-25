package aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {

    private final List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        if (fish != null) {
            fishes.add(fish);
        }
    }

    public void feed() {
        fishes.forEach(Fish::feed);
    }

    public void removeFish() {
        fishes.removeIf(f -> f.getWeight() >= 11);
    }

    public List<String> getStatus() {
        return fishes.stream()
                .map(Fish::status)
                .collect(Collectors.toList());
    }

    public List<Fish> getFishes() {
        return List.copyOf(fishes);
    }
}
