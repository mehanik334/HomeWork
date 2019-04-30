package denisenko.hw12.map;

public class MyHashMap<K, V> {

    private static final int CAPACITY = 8;
    private static final double INIT_LOAD_FACTOR = 0.8;
    private Node[] table;
    private int size;
    private double loadFactor;

    public MyHashMap() {
        this.table = new Node[CAPACITY];
        this.loadFactor = INIT_LOAD_FACTOR;
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private final int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public String toString() {
            return "[" + key + "] => [" + value + "]";
        }
    }

    public final int hash(K key) {
        return Math.abs(key.hashCode() * 16);
    }

    public void raiseSize() {
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[size * 2];
        int currentSize = size;
        helpRaise(newTable,currentSize);
        table = newTable;
        size = newTable.length;
    }

    public void helpRaise(Node[] arrNode, int curSize){
        for (int i = 0; i < table.length && curSize > 0; i++) {
            Node next;
            for (Node<K, V> e = table[i]; e != null; e = next) {
                int newIndex = hash(e.key) % (size * 2);
                if (arrNode[newIndex] == null) {
                    arrNode[newIndex] = e;
                } else {
                    arrNode[newIndex].next = e;
                }
                next = e.next;
                e.next = null;
                curSize--;
            }
        }
    }

    public void put(K key, V value) {
        if (size >= loadFactor * CAPACITY) {
            raiseSize();
        }
        int hash = hash(key);
        Node<K, V> node = null;
        if (size == 0) {
            node = new Node<>(key, value, null, hash);
            table[0] = node;
            size++;
        } else {
            node = new Node<>(key, value, null, hash);
            table[size] = node;
            table[size - 1].next = node;
            size++;
        }
    }

    public Node<K, V> getNode(K key) {
        Node temp = null;
        for (int i = 0; i < size; i++) {
            if (table[i].key == key) {
                temp = table[i];
            }
        }
        return temp;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (table[i].key == key)
                return (V) table[i].value;
        }
        return null;
    }

    public V remove(K key) {
        Node<K, V> result = getNode(key);
        table[returnIndex(key)] = null;
        size--;
        return result.value;
    }

    private int returnIndex(K key) {
        for (int i = 0; i < table.length; i++) {
            if ((table[i] != null) && (table[i].key.equals(key))) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void clear() {
        table = (Node<K, V>[]) new Node[CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            res.append(table[i].toString()).append(System.getProperty("line.separator"));
        }
        return res.toString();
    }
}
