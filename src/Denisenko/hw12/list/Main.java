package denisenko.hw12.list;

import denisenko.hw4.MyList;

public class Main {

    public static void main(String[] args) {

        MyList<String> list = new MyLinkedList<>();
        list.add("S");
        list.add("t");
        list.add("r");
        showLinked(list);
        System.out.println("-------");
        System.out.println("Delete element - " + list.remove(1));
        showLinked(list);
        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.add("q");
        list2.add("w");
        list.addAll(list2);
        System.out.println("-------");
        showLinked(list);
        System.out.println("-------");
        list.add("e", 2);
        showLinked(list);
        System.out.println("-------");
        System.out.println("Delete element - " + list.remove("q"));
        showLinked(list);
        System.out.println("-------");
        System.out.println(list.get(0));
        System.out.println("-------");
        System.out.println(list.size());
        System.out.println("-------");
        System.out.println(list.isEmpty());
    }

    public static void showLinked(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
