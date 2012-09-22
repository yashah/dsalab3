public class MainHeap
{
	static final int ARRAY_SIZE = 25;
	public static void main(String[] args)
	{
		int[] array = { 2,3,5,2,7,8,9,1 };
		Heap heap = new Heap(ARRAY_SIZE);
		for(int i=0;i<array.length;i++)
		{	
			heap.insert(array[i]);
		}
		System.out.println(heap.n);
		printArray(array);
	}
	public static void printArray(int[] array)
	{
		for(int i = 0;i<array.length;i++)
		{
			System.out.print(array[i]+"  ");
		}
		System.out.println();
	}	
}
			
