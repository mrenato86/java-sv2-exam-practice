package forest;

public abstract class Tree {

    private int height;

    public Tree() {
    }

    public Tree(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    protected void incrementHeight(int increment) {
        if (increment > 0) {
            height += increment;
        }
    }

    public String getStatus() {
        return String.format("There is a %d tall %s in the forest.", height, this.getClass().getSimpleName());
    }

    public abstract void irrigate();
}
