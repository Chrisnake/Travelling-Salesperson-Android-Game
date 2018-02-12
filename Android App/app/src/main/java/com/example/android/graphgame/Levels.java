package com.example.android.graphgame;
import org.w3c.dom.Node;
import java.util.ArrayList;

public class Levels
{
    private int weight;
    private int[][] levelsarray;
    private static int levelid;

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
    Levels(int lid, int[][] matrix)
    {
        levelsarray = matrix;
        levelid = lid;
    }

    public ArrayList<Edge> Readlevel() //This reads and inputs the 2D array that has been inputted into the instance. It then goes through the array and stores the edges connected and the weights they are connected at.
    {
        ArrayList<Edge> LevelEdges = new ArrayList<Edge>(); //Use the edges class to store the information on the edges of the level.
        for (int row = 0; row < levelsarray.length; row++)
        {
            for (int col = 0; col < levelsarray.length; col++)
            {
                weight = levelsarray[row][col]; //Find the weight of the edge that is connected in the matrix at position row, col.
                LevelEdges.add(new Edge(levelid, row, col, weight));
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
