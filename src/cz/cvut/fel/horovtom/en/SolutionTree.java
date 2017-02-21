package cz.cvut.fel.horovtom.en;


import java.util.logging.Logger;

/**
 * Created by Hermes235 on 21.2.2017.
 */
public class SolutionTree {
    private static final Logger LOGGER = Logger.getLogger(SolutionTree.class.getName());
    
    private final int n;
    private Node root;


    public SolutionTree(int n) {
        this.n = n;
        initialize();
    }

    private void initialize() {
        root = new Node(n);


    }
}
