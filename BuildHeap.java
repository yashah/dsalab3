public class BuildHeap
{
	Node root;
	int i,size;
	int [] ar;
	public BuildHeap(int []array)
	{
		size = array.length;
		Node[] node = new Node[size];
		ar = new int[size];
		for(i=0;i<size;i++)
		{
			node[i] = new Node(array[i]);
			ar[i]=array[i];
		}
		root = node[0];
		int len = size/2;
		for(i=0;i<len;i++)
		{
			node[i].left = node[2*i+1];
			if(!(i==len-1 && size%2==0)) 
				node[i].right = node[2*i+2];
			node[2*i+1].parent = node[i];
			if(!(i==len-1 && size%2==0)) 
				node[2*i+2].parent = node[i];
		}
	}
	void heapify(int[] A,int index)
	{
		int size = A.length;
		int l = getLeft(index);
		int r = getRight(index);
		int smallest;
		if(l < size && A[l] < A[index])
			smallest = l;
		else
			smallest = index;
		if(r < size && A[r] < A[smallest])
			smallest = r;
		if(index != smallest)
		{
			swap(A[index],A[smallest]);
			heapify(A,smallest);
		}
	}
	void swap(int x,int y)
	{
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
	int getLeft(int i)
	{
		return 2*i+1;
	}
	int getRight(int i)
	{
		return 2*i+2;
	}
	int getParent(int i)
	{
		return (i-1)/2;
	}

	
	void PreOT(Node n)
	{
		Node temp = n;
		if(temp != null)
		{
			System.out.print(temp.key+"  ");
			PreOT(temp.left);
			PreOT(temp.right);
		}
	}
}		
