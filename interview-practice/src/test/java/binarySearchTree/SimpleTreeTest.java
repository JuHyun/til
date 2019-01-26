package binarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTreeTest {

    @Test
    public void createTree() {
        final SimpleTree<Integer> root = new SimpleTree<Integer>(7, new LeafTree(), new LeafTree());
        root.insert(3);
        root.insert(9);
        root.insert(10);

        assertTrue(root.search(10));

        SimpleTree<Integer> right = (SimpleTree<Integer>) root.getRight();
        SimpleTree<Integer> right1 = (SimpleTree<Integer>) right.getRight();
        assertEquals(Integer.valueOf(10), right1.getValue());
    }
}