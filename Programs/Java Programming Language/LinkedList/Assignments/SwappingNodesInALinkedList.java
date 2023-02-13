package LinkedList.Assignments;

public class SwappingNodesInALinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public Node head;
    public Node tail;
    public Node addLast(int data){
        Node n = new Node(data);
        if(head == null){
            head = tail = n;
            return n; 
        }
        tail.next = n;
        tail = n;
        return n;
    }
    public static void main(String[] args) {
        SwappingNodesInALinkedList list1 = new SwappingNodesInALinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        int x = 2, y =4;
        list1.printLinkedList();
        list1.swappingNodes(list1.head,x,y);
        list1.printLinkedList();
    }
    private void swappingNodes(Node head, int x, int y) {
        if(x==y){
            return;
        }
        Node temp = head;
        // x times traversal
        for (int i = 1; i < x-1; i++) {
            temp = temp.next;
        }
        Node firstPointer = temp;
        System.out.println(firstPointer.data);
        // temp = head;
        for (int i = x; i <= y-1; i++) {
            temp = temp.next;
        }
        // change the pointers
        Node secondPointer = temp.next;
        System.out.println(secondPointer.data);
        Node next = secondPointer.next;
        secondPointer.next = temp;
        temp.next = firstPointer.next;
        firstPointer.next = secondPointer;
        temp.next.next = next;
    }
    public void printLinkedList(){
        
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
