import java.util.ArrayList;

public class Levels 
{
	private int weight;
	private int[][] levelsarray;
	//One level will have a graph consisting of an 2D array that is a matrix where the values in the matrix are the weight
	//This class readslevels with the inputted array and stores the levels in an arraylist consisting of edges where the weights are included between the two nodes.
	//This class also finds the amount of nodes in the level and gets its X and Y values. 
	/* EXAMPLE 
	 *    1 2 3
	 * 1 {0,1,2}
	 * 2 {1,0,3}
	 * 3 {2,3,0}
	 *   
	 * Array[][] Example;
	 * Example[0][0] = 0
	 * Example[0][1] = 4 (here at position 0, 1) the weight is 4.
	 * The example above shows an example of an easy level. Hence n = the amount of nodes in the graph. In this case n = 2
	 * This class will allow me to create an instance of a level by inputting a predetermined 2D array.
	 */
	Levels(int[][] matrix)
	{
		levelsarray = matrix;
	}
	
	public ArrayList<Edge> Readlevel() //This reads and inputs the 2D array that has been inputted into the instance. It then goes through the array and stores the edges connected and the weights they are connected at.
	{
		ArrayList<Edge> LevelEdges = new ArrayList<Edge>(); //Use the edges class to store the information on the edges of the level.
		for (int row = 0; row < levelsarray.length; row++)
		{
			for (int col = 0; col < levelsarray.length; col++)
			{
				weight = levelsarray[row][col]; //Find the weight of the edge that is connected in the matrix at position row, col.
				LevelEdges.add(new Edge(row, col, weight));
			}
		}
	
		return LevelEdges;
		/* EXAMPLE RETURN
		 * edges[0] = 0, 0, 0
		 * edges[1] = 0, 1, 4
		 * .....
		 * After it has stored the edges we now know that there is a connection at vertices 0 and 1 with weight 4.
		 */
		
		//method to get max x and max y(drawable area)
		//method call the code that populates arraylist of data
	}
	
	public static ArrayList<Node> NodePosition(int[][]levelsarray) //I need to find a way to get the X and Y coordinates of a node and translate the X and Y value into real values depending on the screen.
	{
		ArrayList<Node> LevelNodes = new ArrayList<Node>();
		for (int x = 0; x < levelsarray.length; x++)
		{
			LevelNodes.add(new Node(x, 0, 0)); //Add the node 0 and give its coordinates as 0, 0
		}
		
		return LevelNodes;
		/* EXAMPLE RETURN
		 * nodes[0] = 0, 1, 3
		 * nodes[1] = 1, 3, 4
		 * It will then mathematically change the x and y inputs into values that can be used in android studios.
		 */
	}
	
	public ArrayList<Node> GetNode(int[][]levelsarray, int NodeToGet) //I need to find a way to get a specific node along with its X and Y coordinates.
	{
		ArrayList<Node> Node = new ArrayList<Node>(); //Declares a new Node ArrayList which will contain the node that the user is trying to get.
		ArrayList<Node> CopyNodes = new ArrayList<Node>(); //Copies the Node arraylist that is obtained from the NodePosition array.
		
		CopyNodes = NodePosition(levelsarray);
		Node.add(CopyNodes.get(NodeToGet)); //Get the node in the position that we are trying to find.
		
		return Node;
	}

	public static void PrintArray(int matrix[][])
	{
		for (int row = 0; row < matrix.length; row++) //This will print the row values!!! 
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				System.out.print(matrix[row][column] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void showNodes(ArrayList<Node> nodes)
	{
		for (Node d : nodes) //Calls the toString method on each of the nodes
		{
			System.out.println(d);
		}
	}
}
