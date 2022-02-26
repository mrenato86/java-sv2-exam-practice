package lettermultiplier;

import java.util.stream.IntStream;

public class LetterMultiplier {
    public String multiply(String input, int number) {
        if (input == null || input.isBlank() || number < 0) {
            throw new IllegalArgumentException("Invalid parameters!");
        }
        StringBuilder sb = new StringBuilder(input.length() * number);
        IntStream.range(0, input.length())
                .forEach(i -> sb.append(String.valueOf(input.charAt(i)).repeat(number)));
        return sb.toString();
    }

}
