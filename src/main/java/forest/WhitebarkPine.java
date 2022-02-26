package forest;

public class WhitebarkPine extends Tree {

    public WhitebarkPine() {
    }

    public WhitebarkPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        incrementHeight(2);
    }
}
