package chap13;

public class Empty<T> implements MyList<T> {
    @Override
    public T head() {
        return (T) new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        return (MyList<T>) new UnsupportedOperationException();
    }
}
