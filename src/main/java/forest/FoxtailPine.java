package forest;

public class FoxtailPine extends Tree {

    public FoxtailPine() {
    }

    public FoxtailPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        incrementHeight(1);
    }
}
