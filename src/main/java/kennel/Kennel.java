package kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    private final List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        if (dog != null) {
            dogs.add(dog);
        }
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(dog -> dog.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Found!"));
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(dog -> dog.getHappiness() > minHappiness)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }

    public List<Dog> getDogs() {
        return List.copyOf(dogs);
    }
}
