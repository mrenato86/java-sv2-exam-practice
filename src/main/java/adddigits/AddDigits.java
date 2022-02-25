package adddigits;

import java.util.stream.IntStream;

public class AddDigits {

    public int addDigits(String input) {
        return (input == null || input.isBlank()) ? -1 : IntStream.range(0, input.length())
                .filter(i -> Character.isDigit(input.charAt(i)))
                .map(i -> Character.getNumericValue(input.charAt(i)))
                .sum();
    }
}
