package LinkedList;

import java.util.LinkedList;

public class MergeSortOnALinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(6);
        System.out.println(list);
        mergeSort(list);
        System.out.println(list);
    }

    private static void mergeSort(LinkedList<Integer> list) {
        // find mid in linkedlist
        
    }
}
