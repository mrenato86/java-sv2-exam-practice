package numberofdigits;

import java.util.stream.IntStream;

public class NumberOfDigits {

    public int getNumberOfDigits(int number) {
        return IntStream.rangeClosed(1, number)
                .map(i -> String.valueOf(i).length())
                .sum();
    }
}
