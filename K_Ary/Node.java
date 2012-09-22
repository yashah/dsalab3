public class Node implements CHILDS
{
	public Node []child = new Node[CHILDS];
	public Node parent;
	public Node sibling;
	public int key;
	public Node(int k)
	{int i;
		for(i=0;i<CHILDS;i++)
		{
			this.child[i] = null;
		}
		this.parent=null;
		key = k;
	}
}
