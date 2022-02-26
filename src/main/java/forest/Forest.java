package forest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Forest {

    private List<Tree> trees;

    public Forest(List<Tree> trees) {
        if (trees != null) {
            this.trees = new ArrayList<>(trees);
        }
    }

    public void rain() {
        trees.forEach(Tree::irrigate);
    }

    public void cutTrees(Lumberjack lumberjack) {
        trees.removeIf(lumberjack::canCut);
    }

    public boolean isEmpty() {
        return trees.isEmpty();
    }

    public List<String> getStatus() {
        return trees.stream()
                .map(Tree::getStatus)
                .collect(Collectors.toList());
    }

    public List<Tree> getTrees() {
        return List.copyOf(trees);
    }
}
