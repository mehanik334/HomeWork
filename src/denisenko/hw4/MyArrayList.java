package denisenko.hw4;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private T arrayValue[];
    private int size = 0;
    private int capasity = 7;
    private T d;

    public MyArrayList() {
        this.arrayValue = (T[]) new Object[capasity];
    }

    public void additionSize() {

        capasity = capasity * 3 / 2;
        arrayValue = Arrays.copyOf(arrayValue, capasity);

    }

    @Override
    public void add(T value) {

        if (this.size == capasity) {

            additionSize();

        }

        arrayValue[size] = value;
        size++;

    }

    @Override
    public void add(T value, int index) {

        if (size == capasity) {

            additionSize();

        }

        System.arraycopy(arrayValue, index, arrayValue, index + 1, size - index);
        arrayValue[index] = value;
        size++;

    }

    @Override
    public void addAll(MyList<T> list) {

        if (!list.isEmpty()) {

            if (capasity < this.size + list.size()) {

                capasity += list.size();
                additionSize();

            }
            for (int i = size + 1, j = 0; i < list.size(); i++, j++) {

                arrayValue[i] = list.get(j);

            }
        } else {

            System.out.println("List is empty");

        }
    }

    @Override
    public T get(int index) {

        return this.arrayValue[index];

    }

    @Override
    public void set(T value, int index) {

        arrayValue[index] = value;

    }

    @Override
    public T remove(int index) {

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

        if (size == 0) {

            return true;

        }

        return false;

    }

}

