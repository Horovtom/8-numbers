package cz.cvut.fel.horovtom.en;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Hermes235 on 21.2.2017.
 */
public class Node {
    private static final Logger LOGGER = Logger.getLogger(Node.class.getName());

    private final int[] ordering;
    private final HashMap<Direction, Node> children = new HashMap<>();
    private final Node parent;

    public Node(int n, Node parent) {
        this.parent = parent;
        ordering = new int[n];
    }

    public Node(int n) {
        ordering = new int[n];
        this.parent = null;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public Node getParent() {
        return parent;
    }

    public int[] getOrdering() {
        return ordering;
    }

    public void setOrdering(int[] ordering) {
        if (ordering.length != this.ordering.length) {
            LOGGER.severe("Wrong size of ordering!");
            System.exit(1);
        }

        boolean hadZero = false;
        for (int i = 0; i < ordering.length; i++) {
            this.ordering[i] = ordering[i];
            if (ordering[i] == 0) {
                if (hadZero) {
                    LOGGER.warning("Ordering has two zeros! Ignoring");
                } else {
                    hadZero = true;
                }
            }
        }
    }

    public boolean isThisOrdering(int[] ordering) {
        if (ordering.length != this.ordering.length) {
            LOGGER.warning("Trying to compare two orderings that are not the same length");
            return false;
        }
        for (int i = 0; i < ordering.length; i++) {
            if (this.ordering[i] != ordering[i]) return false;
        }
        return true;
    }

    //TODO NOT SAFE
    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.isThisOrdering(ordering);
    }


}
