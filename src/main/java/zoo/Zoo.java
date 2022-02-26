package zoo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Zoo {

    private final Set<ZooAnimal> animals = new HashSet<>();
    private JdbcTemplate jdbcTemplate;

    public Zoo() {
    }

    public Zoo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void addAnimal(ZooAnimal animal) {
        if (animal != null) {
            animals.add(animal);
        }
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream()
                .max(Comparator.comparingLong(ZooAnimal::getWeight))
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public long countWeights() {
        return animals.stream()
                .mapToLong(ZooAnimal::getWeight)
                .sum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        return findExactAnimalByPredicate(a -> a.equals(animal));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return findExactAnimalByPredicate(a -> a.getName().equalsIgnoreCase(name));
    }

    private ZooAnimal findExactAnimalByPredicate(Predicate<ZooAnimal> predicate) {
        return animals.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public long getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .collect(Collectors.toList());
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals.stream()
                .collect(Collectors.groupingBy(ZooAnimal::getType, Collectors.summingInt(a -> 1)));
    }

    public void loadAnimals() {
        String sql = "SELECT animal_name, length_of_member, weight, animal_type FROM animals";
        animals.addAll(jdbcTemplate.query(sql, createAnimalRowMapper()));
    }

    private RowMapper<ZooAnimal> createAnimalRowMapper() {
        return (rs, rowNum) -> {
            AnimalType type = AnimalType.valueOf(rs.getString("animal_type"));
            return switch (type) {
                case LION -> new Lion(rs.getString("animal_name"));
                case GIRAFFE -> new Giraffe(rs.getString("animal_name"), rs.getInt("length_of_member"));
                case ELEPHANT -> new Elephant(rs.getString("animal_name"), rs.getInt("length_of_member"), rs.getLong("weight"));
            };
        };
    }

    public void addAnimalToDatabase(ZooAnimal animal) {
        String sql = "INSERT INTO animals(animal_name, length_of_member, weight, animal_type) values (?,?,?,?)";
        jdbcTemplate.update(sql,animal.getName(),animal.getLength(),animal.getWeight(),animal.getType().toString());
    }

}
