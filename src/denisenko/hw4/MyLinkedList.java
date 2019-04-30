package denisenko.hw4;

public class MyLinkedList<T> implements MyList<T> {


    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;
    private Node<T> d;

    private static class Node<T> {

        private T value;
        Node<T> next;
        Node<T> previous;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node(T elem) {
            this.value = elem;
        }

        public Node() {
        }

    }

    public Node getNode(int index) {
        if (index == 0) {
            return first;
        }

        Node<T> result = first;

        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result;
    }


    @Override
    public void add(T value) {

        Node<T> newNode = new Node<>(value);
        if (first == null) {

            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;

        } else {

            newNode.previous = last;
            newNode.next = null;
            last.next = newNode;
            last = newNode;

        }
        size++;
    }

    @Override
    public void add(T value, int index) {

        if (index > size || index < 0) {

            System.out.println("Wrong");

        } else if (index == 0 && size == 0) {

            add(value);

        } else {

            Node<T> cur = getNode(index);
            Node<T> beforeCur = getNode(index - 1);
            Node<T> afterCur = getNode(index + 1);
            Node<T> newCur = new Node<>(value);
            beforeCur.next = newCur;
            newCur.next = cur;
            newCur.previous = beforeCur;
            cur.previous = newCur;
            cur.next = afterCur;
            afterCur.previous = cur;
            size++;

        }
    }

    @Override
    public void addAll(MyList<T> list) {

        MyLinkedList<T> addList = (MyLinkedList<T>) list;
        size += list.size();
        last.next = addList.first;
        addList.first.previous = last;
        last = addList.last;

    }

    @Override
    public T get(int index) {

        Node<T> node = getNode(index);
        return node.getValue();

    }

    @Override
    public void set(T value, int index) {

        Node<T> res = getNode(index);
        res.setValue(value);

    }

    @Override
    public T remove(int index) {

        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {

            d = first;
            first = first.next;
            first.previous = null;

        } else if (index == size - 1) {

            d = last;
            d.previous = null;
            last = getNode(index - 1);
            last.next = null;

        } else {

            d = getNode(index);

            Node<T> prevNode = getNode(index - 1);
            Node<T> nextNode = getNode(index + 1);
            nextNode.previous = prevNode;
            prevNode.next = nextNode;
            d.next = null;
            d.previous = null;

        }
        size--;
        return d.value;
    }

    @Override
    public T remove(T t) {

        for (int i = 0; i < size; i++) {
            if (getNode(i).value == t) {
                d = getNode(i);
                remove(i);
            }
        }

        size--;
        return d.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
