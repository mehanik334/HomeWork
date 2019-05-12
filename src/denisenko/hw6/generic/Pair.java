package denisenko.hw6.generic;

import java.util.Objects;

public class Pair<T, V> {

    private T first;
    private V second;

    private Pair() {
        this(null, null);
    }

    private Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public Pair of(T first, V second) {
        return new Pair(first, second);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) obj;

        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());

    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

}
