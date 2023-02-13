package LinkedList.Assignments;


public class IntersectionOfTwoLinkedList {
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
        IntersectionOfTwoLinkedList list1 = new IntersectionOfTwoLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        Node mid = list1.addLast(6);
        list1.addLast(7);
        list1.printLinkedList();
        System.out.println();
        IntersectionOfTwoLinkedList list2 = new IntersectionOfTwoLinkedList();
        list2.addLast(4);
        list2.addLast(5);
        list2.tail.next = mid;
        list2.printLinkedList();
        System.out.println();
        Node ans = findIntersectionPoint(list1, list2);
        if(ans !=null)
            System.out.println(ans.data);
        Node find = findIntersectionInN2(list1.head, list2.head);
        System.out.println(find.data);
    }
    static Node findIntersectionPoint(IntersectionOfTwoLinkedList list1,IntersectionOfTwoLinkedList list2){
        Node headOflist1 = list1.head;
        Node headOflist2 = list2.head;
        while(headOflist1 != headOflist2){
            if(headOflist1 == null){
                headOflist1 = list2.head;
            }
            if(headOflist2 == null){
                headOflist2 = list1.head;
            }
            headOflist1 = headOflist1.next;
            headOflist2 = headOflist2.next;
        }
        return headOflist2;
    }
    static Node findIntersectionInN2(Node head1,Node head2){
        while(head2!=null){
            Node temp = head1;
            while(temp!=null){
                if(temp==head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }        
        return null;
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
