package LinkedList.Assignments;

public class OddEvenLinkedList {
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
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.addLast(8);
        list.addLast(12);
        list.addLast(10);
        list.addLast(5);
        list.addLast(4);
        list.addLast(1);
        list.addLast(6);
        // list.addLast(4);
        list.printLinkedList();
        list.head = oddEvenLinkedList(list.head);
        list.printLinkedList();
    }
    
    private static Node oddEvenLinkedList(Node head2) {
        Node oddPointer = new Node(-1);
        Node tempOdd = oddPointer;
        Node evenPointer = new Node(-1);
        Node tempEven = evenPointer;
        while(head2!=null){
            if((head2.data&1)==0){
                evenPointer.next = head2;
                evenPointer = evenPointer.next;
                head2 = head2.next;
            }
            else{
                oddPointer.next = head2;
                oddPointer = oddPointer.next;
                head2 = head2.next;
            }
        }
        oddPointer.next = null;
        evenPointer.next = tempOdd.next;
        return tempEven.next;
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
