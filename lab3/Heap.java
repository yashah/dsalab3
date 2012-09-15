public class Heap
{
	Node root;
	int [] array = {2,3,4,5,1,9,7,8,6};
	public Heap(int [] array)
	{
		int n = array.length;
		int l = n/2;
		for(i=0;i<n;i++)
		{
			node[i] = new Node(array[i]);
		}
		for(i=0;i<l;i++)
		{
			
			node[i].left = node[i*2+1];
			if(!(n%2==0 && i==l-1))
			node[i].right = node[i*2+2];
			node[i*2+1].parent = node[i];
			if(!(n%2==0 && i==l-1))
			node[i*2+2].parent = node[i];
		}
		root = node[0];
	}
	public static void Heapify(int [] array, int i)
	{
		int left,temp,right,smallest,heapsize;
		left = getLeft(i);
		right = getRight(i);
		heapsize = array.size;
		if((left < heapsize) && (array[left] < array[i]))
			smallest = left;
		else
			smallest = i;
		if((right < heapsize) && (array[right] < array[smallest]))
			smallest = right;
		if(smallest != i)
		{
			temp = array[smallest];
			array[smallest] = array[i];
			array[i] = temp;
			Heapify(array, smallest);
		}
	}
	int getParent(int i)
	{
		return (i-1)/2;
	}
	int getLeft(int i)
	{
		return (i*2 + 1);
	}
	int getRight(int i)
	{
		return (i*2 + 2);
	}

	static void main(String args[])
	{
		



}
