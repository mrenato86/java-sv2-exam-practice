package potvizsga.numbers;

import java.util.stream.IntStream;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
        return number == 0 || number == requiredNumber(number);
    }

    private int requiredNumber(int number) {
        int length = (int) (Math.log10(number) + 1);
        int sum = 0;
        while (number > 0) {
            sum += Math.pow(number % 10, length);
            number = number / 10;
        }
        return sum;
    }

}
