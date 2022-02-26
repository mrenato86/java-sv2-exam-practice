package forest;

public class Lumberjack {

    private static final int CUT_LIMIT = 4;

    public boolean canCut(Tree tree) {
        return tree.getHeight() > CUT_LIMIT;
    }
}
