package denisenko.hw12.list;

import denisenko.hw4.MyList;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;
    private Node<T> d;

    private static class Node<T> {

        private T value;
        private Node<T> next = null;
        private Node<T> previous = null;

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

    private Node getNode(int index) {
        checkIndex(index);
        if (index == 0) {
            return first;
        }
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
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

    public void checkIndex(int index)  {
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException("Index mast be positiv and more size");
        }
    }

    public void add(T value, int index) {
        checkIndex(index);
        if (index > size || index < 0) {
            System.out.println("Wrong");
        } else if (index == 0 && size == 0) {
            add(value);
        } else {
            Node<T> cur = null;
            Node<T> beforeCur = getNode(index - 1);
            Node<T> afterCur = null;
            Node<T> newCur = new Node(value);
            if (size != index) {
                cur = getNode(index);
                afterCur = getNode(index + 1);
                cur.previous = newCur;
                cur.next = afterCur;
                afterCur.previous = cur;
            }
            last = newCur;
            beforeCur.next = newCur;
            newCur.next = cur;
            newCur.previous = beforeCur;
            size++;
        }
    }

    public void addAll(MyList<T> list) {
        MyLinkedList<T> addList = (MyLinkedList<T>) list;
        size += list.size();
        last.next = addList.first;
        addList.first.previous = last;
        last = addList.last;
    }

    public T get(int index) {
        checkIndex(index);
        Node node = getNode(index);
        return (T) node.getValue();
    }

    public void set(T value, int index) {
        checkIndex(index);
        Node<T> res = getNode(index);
        res.setValue(value);
    }

    public T remove(int index) {
        checkIndex(index);
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

    public T remove(T t) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).value == t) {
                d = getNode(i);
                remove(i);
            }
        }
        return d.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
