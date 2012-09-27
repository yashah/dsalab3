import java.util.ArrayList;

public class Treap {

    public ArrayList<Node> array;
    public Node root;
    
    public Treap(ArrayList<Node> array){
        this.array=array;
        this.root=null;
    }
    
   
    public ArrayList<Node> sort(){
        int i,j;
        ArrayList<Node> li=this.array;
        int l=li.size();
        
        for(i=0;i<(l-1);i++){
            for(j=0;j<(l-i-1);j++){
                if(li.get(j).priority>li.get(j+1).priority){
                  Node temp=li.get(j);
                  Node x= li.set(j,li.get(j+1));
                  Node y=li.set(j+1,temp);
                }
            }
        }
        return li;
    }
    
    public void insert(Node n){
        Node curr=this.root;
        if(curr==null){
            this.root=n;
            n.left=null;
            n.right=null;
            n.parent=null;
        }
        else{
            while(((n.key<curr.key)&&(curr.left!=null))||((n.key>curr.key)&&(curr.right!=null))){
            if(n.key>curr.key){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
            if(n.key<curr.key){
                curr.left=n;
            }
            else{
                curr.right=n;
            }
            n.parent=curr;
            n.left=null;
            n.right=null;
        }
    }
    
    public void createTreap(){
        ArrayList<Node> sortedArray=this.sort();
        int ln=sortedArray.size();
        int i;
        for(i=0;i<ln;i++){
            this.insert(sortedArray.get(i));
        }
    }
    
    public void inOrder(Node x){
        if(x!=null){
            this.inOrder(x.left);
            System.out.println(x.priority+","+x.key);
            this.inOrder(x.right);
        }
    }
    
    public void printTreap(){
        this.inOrder(this.root);
    }
    
}
