package digitscounter;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        return (s == null) ? 0 : IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .filter(Character::isDigit)
                .collect(Collectors.toCollection(HashSet::new))
                .size();
    }

}
