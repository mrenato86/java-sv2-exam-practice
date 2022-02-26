package zoo;

public class Giraffe extends ZooAnimal {

    public Giraffe(String name, int length) {
        super(name, length);
        super.setAnimalType(AnimalType.GIRAFFE);
    }
}
