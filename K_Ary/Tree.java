import java.util.LinkedList;
import java.util.Queue;

public class Tree implements CHILDS
{

	Node root;
	public Tree(Node[] t)
	{
		int n = t.length/CHILDS;
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j< CHILDS;j++)
			{	
				if(!(t.length % CHILDS == 0 && i == n-1 && j==CHILDS-1))
				{
					t[i].child[j] = t[CHILDS*i+j+1];
				}
			}
			for(int j = 0;j<CHILDS;j++)
			{
				if(!(t.length % CHILDS == 0 && i == n-1))
					t[CHILDS*i+j+1].parent = t[i];
			}
		}
		this.root = t[0];
	}
	public void PreOT(Node t)
	{
		Node temp = t;
		if(temp!=null)
		{
			System.out.print(temp.key+"  ");
			for(int i=0;i<CHILDS;i++)
			{	
				PreOT(temp.child[i]);
			}
		}
	}
	public void LevelOT(Node base){
		Queue<Node> current = new LinkedList<Node>();
		Queue<Node> next = new LinkedList<Node>();
		Queue<Node> tempstack = new LinkedList<Node>();
		Node temp = base;
		current.add(temp);
		while(!current.isEmpty()){
			temp = current.remove();
			System.out.print(temp.key+"  ");
			for(int i=0;i<CHILDS;i++)
			{
				if(temp.child[i] != null)
					next.add(temp.child[i]);
			}
			if(current.isEmpty()){
			while(!next.isEmpty())
					tempstack.add(next.remove());
				while(!tempstack.isEmpty())
					current.add(tempstack.remove());
			}

		}
	}
}	
