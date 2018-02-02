
public class Node extends Object
{
	public int nodenumber, x,y;
	
	Node(int pp, int xx,int yy) 
	{
		nodenumber = pp; //nodenumber is the number of the node. For example node A = 1.
		x = xx; //x is the x coordinates (not translated) of the node
		y = yy; //y is the y coodinates (not translated) of the node
	}
	
	public void Print() //This method prints out the node position
	{
		System.out.print("(");
		System.out.print(x);
		System.out.print(",");
		System.out.print(y);
		System.out.print(")");
	}
}
