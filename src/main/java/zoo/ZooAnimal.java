package zoo;

import java.util.Objects;

public abstract class ZooAnimal {

    private final String name;
    private int length;
    private long weight;
    private AnimalType type;

    public ZooAnimal(String name, int length, long weight) {
        this(name, length);
        this.weight = weight;
    }

    public ZooAnimal(String name, int length) {
        this(name);
        this.length = length;
    }

    public ZooAnimal(String name) {
        this.name = name;
    }

    protected void setAnimalType(AnimalType animalType) {
        this.type = animalType;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ZooAnimal{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", weight=" + weight +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimal zooAnimal = (ZooAnimal) o;
        return length == zooAnimal.length && weight == zooAnimal.weight && Objects.equals(name, zooAnimal.name) && type == zooAnimal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, weight, type);
    }
}
