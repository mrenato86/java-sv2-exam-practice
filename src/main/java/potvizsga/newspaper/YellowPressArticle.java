package potvizsga.newspaper;

import java.util.List;

public class YellowPressArticle extends Article {

    private static final int DEFAULT_IMPORTANCE = 1;
    private static final int MAX_HEADER = 5;

    public YellowPressArticle(String author, Header header, List<String> paragraphs) {
        super(author, header, paragraphs);
        if (header.getLevel() > MAX_HEADER) {
            throw new IllegalArgumentException("Header size cannot be greater than " + MAX_HEADER + "!");
        }
    }

    @Override
    public int getImportance() {
        return DEFAULT_IMPORTANCE;
    }
}
