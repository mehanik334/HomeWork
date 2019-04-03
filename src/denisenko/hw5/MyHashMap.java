package denisenko.hw5;

public class MyHashMap<K, V> {

    private int capasity = 8;
    private Node<K, V> table[];
    int size = 0;

    public MyHashMap() {
        this.table = new Node[capasity];
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + key + "] => [" + value + "]";
        }
    }

    public final int hash(K key) {
        return key.hashCode() * 16;
    }

    public void raiseSize() {
        Node<K, V> oldTable[] = table;
        table = (Node<K, V>[]) new Node[size * 2];
        for (int i = 0; i < oldTable.length; i++) {
            table[i] = oldTable[i];
        }
    }

    public void put(K key, V value) {


        if (size - 1 >= table.length) {
            raiseSize();
        }
        int hash = hash(key);
        Node<K, V> node = table[hash];
        if (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
            } else {

                while (node.next != null) {
                    node = node.next;
                }
                Node<K, V> nodeInOld = new Node<>(key, value, null);
                node.next = nodeInOld;
            }
        } else {
            Node<K, V> newNode = new Node<>(key, value, null);
            table[hash] = newNode;
            size++;
        }

    }

    public Node<K, V> get(K key) {

        Node<K, V> node = table[hash(key)];
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public V remove(K key) {

        Node<K, V> result = get(key);
        table[returnIndex(key)] = null;
        size--;
        return result.value;

    }

    public int returnIndex(K key) {
        for (int i = 0; i < table.length; i++) {
            if ((table[i] != null) && (table[hash(key)].key.equals(key))) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void clear() {
        table = (Node<K, V>[]) new Node[capasity];
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
