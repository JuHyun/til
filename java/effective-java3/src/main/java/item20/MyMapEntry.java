package item20;

import java.util.Map;

public class MyMapEntry<K, V> extends AbstractMapEntry<K, V> {

    private final Map.Entry<K, V> entry;

    public MyMapEntry(Map.Entry<K, V> entry) {
        this.entry = entry;
    }

    @Override
    public K getKey() {
        return entry.getKey();
    }

    @Override
    public V getValue() {
        return entry.getValue();
    }

    @Override
    public V setValue(V value) {
        return entry.setValue(value);
    }
}
