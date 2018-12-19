package sortWay;

public class TestQuickSort {

	public static void main(String[] args)
	{
		Integer[] list = {34, 3, 53, 2, 23, 7, 14, 10};
		QuickSort qs = new QuickSort();
		qs.quick(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
		
	}
	
	
}
