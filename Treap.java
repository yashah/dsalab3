public class Treap
{
	int heaplength;
	int bstlength;
	public Treap(int [] heaparray,int [] bstarray)
	{
		heaplength = heaparray.length;
		bstlength = bstarray.length;
		if(heaplength != bstlength) 
			throw new RuntimeException("Treap can not be defined by two different size of arrays!");
	}		
	
}
