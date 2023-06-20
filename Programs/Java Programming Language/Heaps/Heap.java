package Heaps;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> list = new ArrayList<>();
    public void add(int data){
        list.add(data);

        int x = list.size()-1;
        int par = (x-1)/2;

        while(list.get(x)<list.get(par)){

            int temp = list.get(x);
            list.set(x,list.get(par));
            list.set(par,temp);

            x = par;
            par = (x-1)/2;
        }
    }
    public static void main(String[] args) {
        // Heap heap = new Heap();
        // heap.add(4);
        // heap.add(1);
        // heap.add(2);
        // heap.add(3);
        // System.out.println(heap.list);
        // while(!heap.isEmpty()){
        //     System.out.println(heap.peek());
        //     heap.rem ove();
        // }
        int arr[] = {1,2,4,5,3};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void heapify(int[] arr,int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIndex = i;
        if(left<size && arr[left]>arr[maxIndex]){
            maxIndex = left;
        }
        if(right<size && arr[right]>arr[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex !=i){
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr, maxIndex, size);
        }
    }

    public static void heapSort(int arr[]){
        // build maxHeap 
        int n = arr.length;
        for (int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        //push largest at end
        for(int i=n-1;i>0;i--){
            // swap 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0,i);
        }
    }



    private int remove() {
        int data = list.get(0);
        //swap
        int temp = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.set(list.size()-1,temp);
        //remove last
        list.remove(list.size()-1);
        // heapify fix
        heapify(0);
        return data;
    }
    private void heapify(int i) {
        int minIndex = i;
        int leftIndex = 2*i+1;
        int rightIndex = 2*i+2;
        if(leftIndex<list.size() && list.get(minIndex)>list.get(leftIndex)){
            minIndex = leftIndex;
        }
        if(rightIndex<list.size() && list.get(minIndex)>list.get(rightIndex)){
            minIndex = rightIndex;
        }
        if(minIndex!=i){
            int temp = list.get(minIndex);
            list.set(minIndex,list.get(i));
            list.set(i, temp);
            heapify(minIndex);
        }
    }
    private int peek() {
        return list.get(0);
    }
    private boolean isEmpty() {
        return list.size()==0;
    }
}
