package Heaps;

import java.util.ArrayList;

public class classRoom {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();
        public void add(int data){
            list.add(data);
            int x = list.size()-1;
            int par = (list.size()-2)/2;
            while(list.get(x)<=list.get(par)){
                //swap
                int temp = list.get(x);
                list.set(x, list.get(par));
                list.set(par, temp);
            }
        }
        public int peek(){
            return list.get(0);
        }
    }
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        System.out.println(heap.peek());
    }
}
