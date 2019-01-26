package binarySearchTree;

public class LeafTree<E extends Comparable> implements Tree<E> {

    private E value;
    private Tree<E> left;
    private Tree<E> right;

    @Override
    public void insert(E toInsert) {
        value = toInsert;
        left = new LeafTree<>();
        right = new LeafTree<>();
    }

    @Override
    public boolean search(E toFind) {
        return false;
    }
}
