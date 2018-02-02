import java.util.ArrayList;

public class Practice
{
	public static void main(String args[])
	{
		ArrayList <Levels> Level1 = new ArrayList<Levels>(); //Creating the matrix for level1
		
		int g[][] = {{0,1,2},
				 	{1,0,3},
				 	{2,3,0}};

		Levels Matrix = new Levels(g); //I have created a level above in the form of a 2D array and have inputted the information into level 1.
		Level1.add(Matrix);
		
		Levels.showNodes(Levels.NodePosition(g));
		
	}
}
