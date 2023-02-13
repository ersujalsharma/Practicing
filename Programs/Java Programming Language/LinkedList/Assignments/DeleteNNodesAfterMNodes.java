package LinkedList.Assignments;

public class DeleteNNodesAfterMNodes {
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
        DeleteNNodesAfterMNodes list1 = new DeleteNNodesAfterMNodes();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        int m = 2, n =2;
        list1.printLinkedList();
        // deleteNNodesAftermNodes(list1.head,m,n);
        list1.skipMdeleteN(list1.head, m, n);
        list1.printLinkedList();
    }

    void skipMdeleteN(Node head,int M,int N){
        Node cur = head,t;
        int count = 0;
        while(cur!=null){
            for (count=0; count < M && cur!=null; count++) {
                cur = cur.next;
            }
            if(cur==null){
                return;
            }
            t = cur.next;
            for (count=1; count <=N && t!=null ; count++) {
                t= t.next;
            }
            cur.next= t;
            cur = t; 
        }
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
    static Node traverse(Node temp,int traverse){
        while(temp.next!=null && traverse>0){
            temp = temp.next;
            traverse--;
        }
        return temp;
    }
    private static void deleteNNodesAftermNodes(Node head, int m, int n) {
        Node temp =head;
        while(temp!=null){
            // TraverseNode with m-1 times
            int traverse = m-1;
            temp = traverse(temp, traverse);
            // skip with n nodes
            int skipNode = n;
            temp = skipNNodes(temp,skipNode);
            temp = temp.next;
        }
    }
    
    private static Node skipNNodes(Node head, int n) {

        Node temp =head;
        while(temp!=null && n>=0){
            temp = temp.next;
            n--;
        }
        head.next = temp;
        return head;
    }
}
