package Heaps;

import java.util.PriorityQueue;

public class PQ {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student o) {
            // TODO Auto-generated method stub
            return this.rank-o.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 1));
        pq.add(new Student("Chacha", 4));
        pq.add(new Student("Kaka", 2));
        pq.add(new Student("LALA", 0));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"-->"+pq.peek().rank);
            pq.remove();
        }
    }
}









































