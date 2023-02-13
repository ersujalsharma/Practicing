package LinkedList.Assignments;

public class MergeKSortedLinkedList {
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
        int k = 3;
        int n = 4;
        Node arr[] = new Node[k];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(7);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        Node head = merged(arr,k-1);
        printList(head);
    }
    private static void printList(Node head2) {
        while(head2!=null){
            System.out.print(head2.data+"-->");
            head2 = head2.next;
        }
        System.out.println("null");
    }
    private static Node merged(Node arr[],int last) {
        while(last!=0){
            int i=0,j=last;
            while(i<j){
                arr[i] = sortedMerge(arr[i],arr[j]);
                i++;
                j--;
                if(i>=j)
                    last = j;
            }
        }
        return arr[0];
    }
    private static Node sortedMerge(Node a, Node b) {
        Node result = null;
        if(a==null)
            return b;
        else if(b == null)
            return a;
        if(a.data<=b.data){
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
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
