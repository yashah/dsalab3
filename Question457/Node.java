public class Node
{
	int key;
	public Node parent;
	public Node [] child= new Node[2];
	public Node(int k)
	{
		this.key = k;
		this.parent=null;
		this.child[0] = null;
		this.child[1] = null;
	}
}
