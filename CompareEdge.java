//Compare edge weights - used to sort an ArrayList of edges
public class CompareEdge implements java.util.Comparator 
{
	public int compare(Object a, Object b) //This method compares two objects a and b and uses the class Edge
	{
		if (((Edge)a).w < ((Edge)b).w) return(-1); //This compares edge a, with edge b and checks if it is greater than edge a
		if (((Edge)a).w > ((Edge)b).w) return(1); //This compares edge a, with edge b and checks if it is larger and returns 1.
		return(0);
	}
}
