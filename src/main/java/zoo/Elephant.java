package zoo;

public class Elephant extends ZooAnimal {

    public Elephant(String name, int length, long weight) {
        super(name, length, weight);
        super.setAnimalType(AnimalType.ELEPHANT);
    }
}
