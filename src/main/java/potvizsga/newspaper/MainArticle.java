package potvizsga.newspaper;

import java.util.List;

public class MainArticle extends Article {

    public MainArticle(String author, Header header, List<String> paragraphs) {
        super(author, header, paragraphs);
    }

    @Override
    public int getImportance() {
        return super.getParagraphs().size() + super.getHeader().getLevel();
    }
}
