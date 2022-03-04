package potvizsga.newspaper;

public class Header {

    private final String content;
    private final int level;

    public Header(String content, int level) {
        this.content = content;
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public int getLevel() {
        return level;
    }
}
