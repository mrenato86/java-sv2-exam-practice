package words;

import java.util.stream.IntStream;

public class Words {

    public boolean hasMoreDigits(String s) {
        long digits = IntStream.range(0, s.length())
                .filter(i -> Character.isDigit(s.charAt(i)))
                .count();
        return digits > s.length() - digits;

//        Map<Boolean, List<Character>> data = IntStream.range(0, s.length())
//                .mapToObj(s::charAt)
//                .collect(Collectors.partitioningBy(Character::isDigit));
//        return data.get(true).size() > data.get(false).size();
    }
}
