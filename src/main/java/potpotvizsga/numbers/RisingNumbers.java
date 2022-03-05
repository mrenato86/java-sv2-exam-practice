package potpotvizsga.numbers;

import java.util.List;

public class RisingNumbers {

    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("There are no numbers!");
        }
        return (int) numbers.stream()
                .filter(this::isSixDigitLong)
                .filter(this::isRisingNumber)
                .count();
    }

    private boolean isSixDigitLong(int number) {
        return 5 == (int) Math.log10(number);
    }

    private boolean isRisingNumber(int number) {
        int last = 10;
        while (number > 0) {
            int digit = number % 10;
            if (digit >= last) {
                return false;
            }
            last = digit;
            number /= 10;
        }
        return true;
    }
}
