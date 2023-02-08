package ArrayList;

import java.util.ArrayList;

public class MaximumNumberInArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(7);
		arrayList.add(3);
		arrayList.add(-1);
		System.out.println(
		maximum(arrayList));
	}

	private static int maximum(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arrayList.size();i++) {
			max = max>arrayList.get(i)?max:arrayList.get(i);
		}
		return max;
	}
}
