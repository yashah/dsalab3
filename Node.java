/* Node class for all the questions except for Treap */
public class Node
{
int key;
public Node right,left,parent;

	public Node(int k)
	{
		key = k;
		right = null;
		left = null;
		parent = null;
	}
}
