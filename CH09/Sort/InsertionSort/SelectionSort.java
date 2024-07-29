public class SelectionSort
{
	public static void sort(int[] a, int sortOrder)
	{
		int n = a.length;

		for(int i = 0; i < n - 1; i++)
		{
			int lowest = i;
			int lowkey = a[i];

			for(int j = i + 1; j < n; j++)
			{
				if(compare(sortOrder, a[j], lowkey))
				{
					lowest = j;
					lowkey = a[j];
				}
			}
			int temp = a[i];
			a[i] = a[lowest];
			a[lowest] = temp;
		}
	}

	public static boolean compare(int sortOrder, int x, int y){
		if(sortOrder == 1){
			return x < y;
		}
		else{
			return x > y;
		}
	}
}
