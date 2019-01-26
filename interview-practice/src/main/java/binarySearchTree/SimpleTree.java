package binarySearchTree;

public class SimpleTree<E extends Comparable> implements Tree<E> {

    private E value;
    private Tree<E> left;
    private Tree<E> right;

    public SimpleTree(E value, Tree<E> left, Tree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public Tree<E> getLeft() {
        return left;
    }

    public Tree<E> getRight() {
        return right;
    }

    @Override
    public void insert(final E toInsert) {
        if (toInsert.compareTo(value) < 0) {
            if (left instanceof LeafTree) {
                left = new SimpleTree<>(toInsert, new LeafTree<>(), new LeafTree<>());
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right instanceof LeafTree) {
                right = new SimpleTree<>(toInsert, new LeafTree<>(), new LeafTree<>());
            } else {
                right.insert(toInsert);
            }
        }
    }

    @Override
    public boolean search(E toFind) {
        if (toFind.compareTo(value) == 0) {
            return true;
        }
        if (toFind.compareTo(value) < 0 && !(left instanceof LeafTree)) {
            return left.search(toFind);
        }

        return right.search(toFind) && !(right instanceof LeafTree);
    }
}
