package LinkedList.LeetCode;

import java.util.LinkedList;

public class MyHashSet {

    LinkedList<Integer> list;

    public MyHashSet() {
        list = new LinkedList<>();
    }
    
    public void add(int key) {
        if(!contains(key)){
            list.add(key);
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            
        }
    }
    
    public boolean contains(int key) {
        return false;
    }
}