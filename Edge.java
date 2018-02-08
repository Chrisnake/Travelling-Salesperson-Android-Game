//Store an edge, from node i to j with weigh w
public class Edge extends Object
{
	public int i,j;
	public double w;
	
	Edge(int ii,int jj,int ww) 
	{
		i = ii; //i is a vertices that connects with j
		j = jj; //j is a vertices that connects with i
		w = ww; //w is the weight of the edge
	}

	public int GetNode(int i)
	{
		
	}
	
	public int GetWeight(int i, int j)
	{
		
	}
	public void Print() //This method prints out the edge.
	{
		System.out.print("(");
		System.out.print(i);
		System.out.print(",");
		System.out.print(j);
		System.out.print(",");
		System.out.print(w);
		System.out.print(")");
	}
}