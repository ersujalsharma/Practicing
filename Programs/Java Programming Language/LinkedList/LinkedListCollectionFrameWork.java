package LinkedList;

import java.util.LinkedList;

public class LinkedListCollectionFrameWork {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);   
        System.out.println(list);
    }
}
