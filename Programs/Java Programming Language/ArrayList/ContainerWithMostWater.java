package ArrayList;

import java.util.ArrayList;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>() ;
		arrayList.add(1);
		arrayList.add(8);
		arrayList.add(6);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(4);
		arrayList.add(8);
		arrayList.add(3);
		arrayList.add(7);
		int value = containerWithMostWaterOptimized(arrayList);
		System.out.println(value);
	}

	private static int containerWithMostWaterOptimized(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		int i=0,j=arrayList.size()-1,max=Integer.MIN_VALUE;
		while(i<j) {
			int minPillar = Math.min(arrayList.get(i),arrayList.get(j));
			int area = minPillar*(j-i);
			if(arrayList.get(i)<arrayList.get(j)) {
				i++;
			}
			else {
				j--;
			}
			max = Math.max(max, area);
		}
		return max;
	}

	private static int containerWithMostWater(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = i+1; j < arrayList.size(); j++) {
				int area =  Math.min(arrayList.get(j),arrayList.get(i))*(j-i);
				max = max>area?max:area;
			}
		}
		return max;
	}
}
