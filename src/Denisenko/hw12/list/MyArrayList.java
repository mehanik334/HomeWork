package denisenko.hw12.list;

import denisenko.hw4.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private T arrayValue[];
    private int size = 0;
    private int capacity = 7;
    private T d;

    public MyArrayList() {
        this.arrayValue = (T[]) new Object[capacity];
    }

    public int getCapasity() {
        return capacity;
    }

    public T[] getArrayValue() {
        return arrayValue;
    }

    public void additionSize() {
        capacity = capacity * 3 / 2;
        arrayValue = Arrays.copyOf(arrayValue, capacity);
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(T value) {
        if (this.size == capacity) {
            additionSize();
        }
        arrayValue[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (size == capacity) {
            additionSize();
        }
        System.arraycopy(arrayValue, index, arrayValue, index + 1, size - index);
        arrayValue[index] = value;
        size++;
    }

    @Override
    public void addAll(MyList<T> list) {
        if (!list.isEmpty()) {
            if (capacity < this.size + list.size()) {
                capacity += list.size();
                additionSize();
            }
            for (int i = getSize() + 1, j = 0; i < list.size(); i++, j++) {
                getArrayValue()[i] = list.get(j);
            }
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return this.arrayValue[index];
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        arrayValue[index] = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            arrayValue[i] = arrayValue[i + 1];
            arrayValue[size] = null;
        }
        size--;
        return get(index);
    }

    @Override
    public T remove(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(arrayValue[i])) {
                d = remove(i);
            }
        }
        return d;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index must be more than 0 and less than size - 1");
        }
    }
}

