public class MainTester
{
	public static void main(String[] args)
	{
		int array[] = {2,3,6,1,9,7,12,8,4};
		BuildHeap heap = new BuildHeap(array);
		System.out.println("Pre-order Traversal of Created Heap..");
		linehere();
		heap.PreOT(heap.root);
		linehere();
		System.out.println("Array: ");
		printArray(array);
		space();
		System.out.println();
		heap.heapify(array,0);
		
		printArray(array);
	}
	static void heapify(int[] A,int index)
	{
		int size = A.length;
		int l = getLeft(index);
		int r = getRight(index);
		System.out.println("l is: "+l+" r is: "+r);
		int smallest;
		if(l < size && A[l] < A[index])
		{
			smallest = l;
		}
		else
		{
			smallest = index;
		}
		if(r < size && A[r] < A[smallest])
			smallest = r;
		if(index != smallest)
		{
			int temp = A[index];
			A[index] = A[smallest];
			A[smallest] = temp;
			heapify(A,smallest);
		}
	}
	static int getLeft(int i)
	{
		return 2*i+1;
	}
	static int getRight(int i)
	{
		return 2*i+2;
	}
	static int getParent(int i)
	{
		return (i-1)/2;
	}
	static void swap(int x,int y)
	{
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
	static void printArray(int[] array)
	{
		int size = array.length;
		for(int i = 0; i< size; i++)
		{
			System.out.print(array[i]+"  ");
		}
		space();
	}
	static void space()
	{
		System.out.println();
	}
	static void linehere()
	{
		System.out.println("\n---------------------------");
	}
}	
