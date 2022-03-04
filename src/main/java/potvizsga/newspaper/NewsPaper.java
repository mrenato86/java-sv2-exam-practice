package potvizsga.newspaper;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class NewsPaper {

    private final String name;
    private final Set<Article> articles = new TreeSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public void addArticle(Article article) {
        if (article != null) {
            articles.add(article);
        }
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return new TreeSet<>(articles);
    }

    public List<Article> findArticlesByAuthor(String author) {
        return articles.stream()
                .filter(a -> a.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Article> findArticleByParagraphPart(String part) {
        return articles.stream()
                .filter(a -> a.getParagraphs().stream()
                        .anyMatch(p -> p.contains(part)))
                .collect(Collectors.toList());
    }
}
