public class Heap
{
	static final int ARRAY_SIZE = 25;
	int[] array;
	int n=0;
	public Heap(int size)
	{
		array = new int[size];
	}
	public void insert(int key)
	{
		if(array.length==n)
		{
			throw new RuntimeException("heap is full!");
		}
		array[n] = key;
		siftUp(n);
		n++;
	}
	public void swap(int i,int j)
	{
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	void buildMinHeap(int[] A)
	{
		int p = n/2;
		while(p>=0)
		{
			minHeapify(A,p);p--;
		}
	}
	void buildMaxHeap(int[] A)
	{
		int p = n/2;
		while(p>=0)
		{
			maxHeapify(A,p);p--;
		}
	}
	void heapSort(int[] A)
	{
		buildMaxHeap(A);
		int temp;
		int heapsize = n;
		while(heapsize != 0)
		{
			temp = A[0];
			A[0] = A[heapsize -1];
			A[heapsize-1] = temp;
			heapsize -= 1;
			B = Arrays.copyOfRange(A,0,heapsize);
			int l = B.length;
			maxHeapify(B,0);
			for(int i = 0;i< l;i++)
				A[i]=B[i];
		}
	}

	public static getMinimum(int []A)
	{
		buildMinHeap(A);
		int min = A[0];
		array[n--]=0;
		return min;
	}
	public void siftUp(int index)
	{	
		if(index > n) return;
		if(index>0)
		{
			int parent = getParent(index);
			if(array[parent] > array[index])
			{
				swap(parent,index);
				siftUp(parent);
			}
		}
	}
	public int getParent(int index)
	{
		return (index-1)/2;
	}
	int  getLeft(int index)
	{
		return 2*index+1;
	}
	int getRight(int index)
	{
		return 2*index+2;
	}

}
