package LinkedList;

public class ImplementationOfLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
   
    public static void addFirst(int data){
        Node n = new Node(data);
        size++;
        if(head==null){
            head = tail = n;
            return;
        }
        n.next = head;
        head = n;
    }
    public static void addLast(int data){
        Node n = new Node(data);
        size++;
        if(head == null){
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    public static void printLinkedList(){
        
        System.out.println("HEAD=============================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+head.data);
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("TAIL=============================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+tail.data);
        System.out.println("SiZE=============================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+size);
    }
    public static void add(int index,int data){
        if(index ==0){
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        size++;
        Node temp = head;
        while(temp!=null && index-1>0){
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next = node;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i <size-2; i++) {
            prev = prev.next;
        }
        prev.next = null;
        int val = tail.data;
        tail =  prev;
        size--;
        return val;
    }
    public static int findAKeyinLinkedList(int key){
        Node temp = head;
        int i=-1;
        while(temp!=null){
            i++;
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
        }
        return i;
    }

    public static  int  findKeyUsingRecursiveWay(int key){
        return helper(head,key);
    }


    public static int helper(Node head, int key) {
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1)  return -1;
        return idx+1;
    }

    public static void reverseList(){
        Node prev = null;
        Node cur = tail =  head;
        Node next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public static void  removeNthElementFormEnd(int index){
        
        Node firstPointer = head;
        Node secondPointer = head;
        while(index>=0){
            secondPointer = secondPointer.next;
            index--;
        }
        while(secondPointer!=null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        firstPointer.next = firstPointer.next.next;
    }
    public int deleteNthfromEnd(int n){
        // Shraddha's Approach
        // first we will Find the size of the linkedlist
        Node temp = head;
        int i=0;
        while(temp!=null){
            temp = temp.next;
            i++;
        }
        temp = head;
        for (int j = 1; j < i-n; j++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }
    public Node findMidNodeOfLinkedList(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node reverseFromNode(Node temp){
        Node prev = null;
        Node cur = temp.next;
        Node next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        temp.next = prev;
        return prev;
    }

    
    private static boolean checkPalindromeOrNot(Node mid) {
        if(head== null || head.next == null){
            return true;
        }
        Node temp = head;
        while(mid !=null){
            if(mid.data != temp.data){
                return false;
            }
            temp = temp.next;
            mid = mid.next;
        }
        return true;
    }
    public boolean detectCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public void removecycle(){
        Node slow = head;
        Node fast = head;
        boolean val = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                val = true;
                break;
            }
        }
        if(val== false){
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }
    public Node midForMergeSort(Node head){
        Node slow = head;
        Node  fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next == null){
            return head;
        }
        // find mid
        Node mid = midForMergeSort(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right =  mergeSort(rightHead);
        return mergeTwoSortedLinkedList(left,right);
    }
    private Node mergeTwoSortedLinkedList(Node leftHead, Node rightHead) {
        Node mergedList = new Node(-1);
        Node temp= mergedList;
        while(leftHead!=null && rightHead != null){
            if(leftHead.data<=rightHead.data){
                temp.next = leftHead;
                leftHead = leftHead.next;
            }
            else{
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }
        while(leftHead!=null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while(rightHead!=null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedList.next;
    }
    
    public Node zigzagLinkedList(Node head){
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node reversedNode = reverse(rightHead);
        Node merged = mergeTwoInZigZag(head,reversedNode);
        return merged;
    }

    private Node mergeTwoInZigZag(Node head2, Node reversedNode) {
        Node temp = new Node(-1);
        Node nodeToReturn = temp;
        while(head2!=null && reversedNode != null){
            temp.next = head2;
            head2 = head2.next;
            temp.next.next = reversedNode;
            reversedNode = reversedNode.next;
            temp = temp.next.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        while(reversedNode!=null){
            temp.next = reversedNode;
            reversedNode = reversedNode.next;
            temp = temp.next;
        }
        return nodeToReturn.next;
    }
    private Node reverse(Node rightHead) {
        Node prev = null;
        Node cur = rightHead;
        Node next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private Node findMid(Node head2) {
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void makeCircular(){
        tail.next = head;
    }
    public static void main(String[] args) {
        ImplementationOfLinkedList ll = new ImplementationOfLinkedList();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.add(2, 7);
        // ll.add(2, 7);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        // printLinkedList();
        // System.out.println(ll.removeFirst());
        // printLinkedList();
        // System.out.println(ll.removeLast());
        // printLinkedList();
        // int val = findAKeyinLinkedList(1);
        // System.out.println(val);
        // System.out.println(findKeyUsingRecursiveWay(7));
        // ll.reverseList();;
        // ll.removeNthElementFormEnd(4);
        // printLinkedList();
        // System.out.println(ll.deleteNthfromEnd(3));
        // printLinkedList();
        // Node mid = ll.findMidNodeOfLinkedList();
        // Node pointerOfrev = ll.reverseFromNode(mid);
        // System.out.println(checkPalindromeOrNot(pointerOfrev));
        // tail.next = head;
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(ll.detectCycle());
        // ll.removecycle();
        // System.out.println(ll.detectCycle());
        // printLinkedList();
        // head = ll.mergeSort(head);
        // printLinkedList();
        // Node zigNode = ll.zigzagLinkedList(head);
        // while(zigNode!=null){
        //     System.out.println(zigNode.data);
        //     zigNode = zigNode.next;
        // }
        printLinkedList();
        // ll.makeCircular();
        printLinkedList();
    }
}
