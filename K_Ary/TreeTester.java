import java.util.Scanner;
public class TreeTester implements CHILDS 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter The Number of Nodes for an Arbitrary Tree: ");
		int NODES = scanner.nextInt();
		Node[] node = new Node[NODES];

		for(int i=0;i<NODES;i++)
		{
			node[i] = new Node(i+1);
		}

		Tree tree = new Tree(node);
		System.out.println();
		System.out.println("The Number of Maximum Childs for Each Node is: "+CHILDS);
		System.out.println();

		linehere();
		System.out.println("PreOT for tree is: ");
		linehere();
		tree.PreOT(tree.root);
		System.out.println();

		linehere();
		System.out.println("Level Order Traversal of Arbitrary tree: ");
		linehere();
		tree.LevelOT(tree.root);
		System.out.println();
		linehere();
	}
	public static void linehere()
	{	
		System.out.println("-------------------------------------------------------------------------");
	}
} 
