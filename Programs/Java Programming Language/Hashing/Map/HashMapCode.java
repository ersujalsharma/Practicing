package Hashing.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class HashMapCode {
    static class HashMap<K,V>{ // Generic
        /**
         * Node
         */
        private class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                value = value;
            }            
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        public void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); 
            if(di!= -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        private void rehash() {
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node  = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) 
                    return di;
                di++;
            }
            return -1;
        }
        private int hashFunction(K key) {
            return Math.abs(key.hashCode())%N;
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1) return true;
            return false;
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
        public static void main(String[] args) {
            HashMap<String,Integer> hashmap = new HashMap<>();
            hashmap.put("India", 100);
            hashmap.put("China", 150);
            hashmap.put("India", null);
            ArrayList<String> keys = hashmap.keySet();
            for (String string : keys) {
                System.out.println(string);
            }
        }
    }
}
