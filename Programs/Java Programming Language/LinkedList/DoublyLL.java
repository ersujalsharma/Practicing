package LinkedList;

import ArrayList.PrintArrayList;

public class DoublyLL {
    class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }   
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    void printDoublyLL(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    int removeFirst(){
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev =null;
        size--;
        return val;
    }
    void addLast(int data){
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        size++;
    }
    int removeLast(){
        if(size == 1){
            int val = tail.data;
            head = tail = null;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;

    }

    void reverseDoublyLinkedList(Node head){
        Node prev  = null;
        Node cur = tail = head;
        Node next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;
        }
        prev.prev = null;
        DoublyLL.head = prev;
    }
    public void makeCircular(){
        tail.next = head;
        head.prev = tail;
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.addFirst(2);
        list.addFirst(3);
        list.printDoublyLL();
        System.out.println(list.size);
        list.removeFirst();
        list.printDoublyLL();
        System.out.println(list.size);
        list.addLast(4);
        // list.printDoublyLL();
        // list.removeLast();
        // list.printDoublyLL();

        list.addLast(3);
        list.reverseDoublyLinkedList(head);
        list.printDoublyLL();
        // list.makeCircular();
        list.printDoublyLL();
        while(tail!=null){
            System.out.println(tail.data);
            tail = tail.prev;
        }
    }
}
