package ArrayList;

import java.util.ArrayList;

public class MultiDimensionalArrays {
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);list.add(2);
//		ArrayList<Integer> list2 = new ArrayList<>();
//		list2.add(3);list2.add(4);
//		arraylist.add(list);
//		arraylist.add(list2);
//		System.out.println(arraylist);
//		for (int i = 0; i < arraylist.size(); i++) {
//			for (int j = 0; j < arraylist.get(i).size(); j++) {
//				System.out.print(arraylist.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		// 1 2 3 4 5 
		// 2 4 6 8 10
		// 3 6 9 12 15
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			list1.add(i*1);
			list2.add(i*2);
			list3.add(i*3);
		}
		list.add(list1);
		list.add(list2);
		list.add(list3);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print( list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
