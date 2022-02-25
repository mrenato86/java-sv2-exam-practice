package uniquefinder;

import java.util.List;
import java.util.stream.Collectors;

public class UniqueFinder {

    public List<Character> uniqueChars(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Input must be present!");
        }
//        List<Character> chars = new ArrayList<>();
//        for (char c : line.toCharArray()) {
//            if (!chars.contains(c)) {
//                chars.add(c);
//            }
//        }
//        return chars;
//
        return line.chars()
                .distinct()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }
}
