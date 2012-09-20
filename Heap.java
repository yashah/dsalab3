import java.util.Arrays;
public class Heap
{
	public Node root;
	public Node[] node;
	static int i;
	static int heapsize;
	public Heap(int [] array)
	{
		int l = array.length;
		node = new Node[l];
		int n = l/2;
		for(i=0;i<l;i++)
			node[i] = new Node(array[i]);
		for(i=0;i<n;i++)
		{
			node[i].left = node[2*i+1];
			if(!(n%2 == 0 && i==n-1))
				node[i].right = node[2*i+2];
			node[2*i+1].parent = node[i];
			if(!(n%2 == 0 && i==n-1))
				node[2*i+2].parent = node[i];
		}
		root = node[0];
	}
	static void  printArray(int[] array)
	{
		int length = array.length;
		System.out.println();
		for(i=0;i<length;i++)
		{	
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
	static int   getParent(int index)
	{
		return (index-1)/2;
	}
	static int  getLeft(int index)
	{
		return 2*index+1;
	}
	static int getRight(int index)
	{
		return 2*index+2;
	}
	static void  swap(int x, int y)
	{
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
	static void  minHeapify(int [] A,int index)
	{

		int left = getLeft(index);
		int right = getRight(index);
		int temp,smallest;
		int heapsize = A.length;
		if(index >= heapsize) return;
		if(left < heapsize && A[left] < A[index])
			smallest = left;
		else smallest = index;
		if(right < heapsize && A[right] < A[smallest])
			smallest = right;
		if(smallest != index)
		{
			temp = A[smallest];
			A[smallest]=A[index];
			A[index] = temp;
			minHeapify(A,smallest);
		}
	}
	static void maxHeapify(int [] A,int index)
	{
		int left = getLeft(index);
		int right = getRight(index);
		int largest,temp;
		int heapsize = A.length;
		if(index >= heapsize) return;
		if(left < heapsize && A[left] > A[index])
			largest = left;
		else largest = index;
		if(right < heapsize && A[right] > A[largest])
			largest = right;
		if(largest != index)
		{
			temp = A[largest];
			A[largest]=A[index];
			A[index] = temp;
			maxHeapify(A,largest);
		}
	}
	static void buildMinHeap(int[] A)
	{
		int heapsize = A.length;
		int n = heapsize/2;
		while(n>=0)
		{
			minHeapify(A,n);n--;
		}						
	}
	static void buildMaxHeap(int[] A)
	{
		int heapsize = A.length;
		int n = heapsize/2;
		while(n>=0)
		{
			maxHeapify(A,n);n--;
		}						
	}
	static void siftMinUp(int [] A,int index)
	{
		int temp;
		int parent = getParent(index);
		if(index >= A.length || index < 1)
			return;
		if(A[index] < A[parent])
		{
			temp = A[index];
			A[index] = A[parent];
			A[parent] = temp;
			siftMinUp(A,parent);
		}
	}
	static void siftMaxUp(int [] A,int index)
	{
		int temp;
		int parent = getParent(index);
		if(index >= A.length || index < 1)
			return;
		if(A[index] > A[parent])
		{
			temp = A[index];
			A[index] = A[parent];
			A[parent] = temp;
			siftMaxUp(A,parent);
		}
	}
	static void siftMinDown(int [] A,int index)
	{
		minHeapify(A,index);
	}
	static void siftMaxDown(int [] A,int index)
	{
		maxHeapify(A,index);
	}

	static void heapSort(int[] A)
	{
		buildMaxHeap(A);
		int temp;
		int heapsize = A.length;
		int []B;
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
	public static  void main(String[] args)
	{
		int [] array1 = {2,3,4,5,1,9,7,8,6};
		new Heap(array1);
		printArray(array1);
		System.out.println("Build-Heap is making array in order of Max Heap1");
		buildMaxHeap(array1);
		printArray(array1);
		System.out.println("Build-Heap is making array in order of Min Heap1");
		buildMinHeap(array1);
		printArray(array1);
		System.out.println("introducing array222222...");
		int[] array2 = {6,8,7,9,1,5,4,2,3};
		printArray(array2);
		buildMaxHeap(array2);
		System.out.println("Build-Heap is making array in order of Max Heap2");
		printArray(array2);
		System.out.println("Build-Heap is making array in order of Min Heap2");
		buildMinHeap(array2);
		printArray(array2);
		System.out.println("Heap sort");
		int[] array3 = {6,8,7,9,1,5,4,2,3};
		printArray(array3);
		heapSort(array3);
		printArray(array3);			

	}
}
