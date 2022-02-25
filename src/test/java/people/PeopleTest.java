package people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeopleTest {

    @Test
    void getNumberOfMales() {
        People people = new People();
        int males = people.getNumberOfMales("src/test/resources/people/people.csv");
        assertEquals(545, males);
    }
}