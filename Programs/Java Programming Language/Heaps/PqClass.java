package Heaps;

import java.util.ArrayList;

public class PqClass {
    
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();
        private void add(int data) {
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
        public int peek(){
            return list.get(0);
        }
        public void heapify(int i){
            int minIndex = i;
            int left = 2*i+1;
            int right = 2*i+2;
            if(left<list.size() && list.get(left)<list.get(minIndex)){
                minIndex = left;
            }
            if(right<list.size() && list.get(right)<list.get(minIndex)){
                minIndex = right;
            }
            if(minIndex!=i){
                // swap values 
                int temp = list.get(i);
                list.set(i,list.get(minIndex));
                list.set(minIndex,temp);
                // now call heapify for minIndex;
                heapify(minIndex);
            }
        }
        public int remove(){
            int data = list.get(0);
            // swap the data with last;
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1,temp);
            // remove last  
            list.remove(list.size()-1);
            // heapify to fix order
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return list.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(1);
        h.add(0);
        h.add(-1);
        h.add(5);
        h.add(2);
        h.add(-2);
        System.out.println(h.list);
        while(!h.isEmpty()){
            System.out.print(h.peek()+" ");
            h.remove();
        }
    }
}
